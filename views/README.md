# 前言
捣鼓了两天，总算是做了demo 啦。整体思路如下：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020031310594595.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzI3NzkwMDEx,size_16,color_FFFFFF,t_70)
可以看到整体思路还是比较简单的，真机IP访问的话，很容易被限制，所以增加代理访问。主要就是三步走，1将url 存入到url 缓存池中。2 将代理信息存入到代理池中，3.分别从url缓存池和代理池中取出一个进行爬取页面，并将页面数据解析出来。下面来仔细看看如何实现的吧。

# 代理相关
代理的信息可以从如下两个地址中获取。
```
https://raw.githubusercontent.com/fate0/proxylist/master/proxy.list,https://www.xicidaili.com/wt/
```

所以我在application.properties 中增加获取代理路径的配置。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200313110848844.png)
然后增加一个ipbean 和ipPool.
ipbean
```
@Setter
@Getter
public class IpBean {
    private String ip;
    private int port;
    private String type;

    public IpBean(String ip, int port, String type) {
        this.ip = ip;
        this.port = port;
        this.type = type;
    }

}
```

ipPool 
```
public class IpPool {

    public static List<IpBean> ipBeanList = new ArrayList<>();

    /**
     * 支持并发操作
     *
     * @param bean
     */
    public static synchronized void add(IpBean bean) {
        if(ipBeanList.size()>=1000){
            return;
        }
        ipBeanList.add(bean);
    }

    public static synchronized void remove(IpBean bean) {
        ipBeanList.remove(bean);
    }
}
```
这里做了一个处理，就是当代理池中的数量大于1000时，我们就不再向代理池中增加代理了。

## 爬取代理信息
接下来就是从上面的两个地址爬取代理信息啦。
整体代码如下:
```
@Slf4j
@Component
public class Spider {
    private int pages;
    private List<IpBean> ipList = new ArrayList<>();


    /**
     * 带页数的爬取(适用于西刺代理和快代理)
     * @param url
     * @param pages 页数
     * @return
     */
    public List<IpBean> crawl(String url,int pages) throws Exception {
        this.pages = pages;
        return crawl(url);
    }

    /**
     * 不带页数的爬取，爬取URL返回的页面数据。
     * @param url
     * @return
     */
    public List<IpBean> crawl(String url) throws Exception {
        String[] urlArr=url.split(ConstantPool.SEPARATORCOMMA);
        for(int i=0;i<urlArr.length;i++){
            String temp=urlArr[i];
            if(temp.substring(temp.length()-1,temp.length()).equalsIgnoreCase(ConstantPool.SEPARATORSLASH)){
                crawlHasPage(temp);
            }else{
                crawlNoPage(temp);
            }
        }
        return ipList;
    }

    /**
     * 带页数的爬取
     * @param url
     */
    private void crawlHasPage(String url){
        for(int i=1;i<pages;i++){
            getResponseFromXiCi(url,i);
        }
    }

    /**
     * 不带页数的爬取
     * @param url
     */
    private void crawlNoPage(String url) throws Exception {
        IpBean ipBean=null;
        getResponseFromJson(HttpUtils.getHttpURLConnection(url,ipBean));
    }

    /**
     * 从https://raw.githubusercontent.com/fate0/proxylist/master/proxy.list上爬取代理IP并放入ipList中
     * @param conn
     * @return
     */
    private void getResponseFromJson(HttpURLConnection conn){
        try {
           int code = conn.getResponseCode();
            if (code == 200) {
                InputStream is = conn.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                String oneJson = in.readLine();
                while (oneJson != null && oneJson.trim().length() != 0) {
                    JSONObject jsonObject =JSON.parseObject(oneJson);
                    String ip= (String) jsonObject.get("host");
                    int port= Integer.parseInt(jsonObject.get("port").toString());
                    String type= (String) jsonObject.get("type");
                    ipList.add(new IpBean(ip, port, type));
                    oneJson = in.readLine();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 从西刺带上爬取代理IP。
     * @param url
     * @param index
     */
    private void getResponseFromXiCi(String url, int index) {
        String html = null;
        try {
            html =HttpUtils.getResponseContent(url + index,null);
        } catch (Exception e) {
            log.error("{}",e);
        }
        Document document = Jsoup.parse(html);
        Elements eles = document.selectFirst("table").select("tr");
        for (int i = 1; i < eles.size(); i++){
            Element ele = eles.get(i);
            String ip = ele.children().get(1).text();
            int port = Integer.parseInt(ele.children().get(2).text().trim());
            String type = ele.children().get(5).text().trim();
            ipList.add(new IpBean(ip, port, type));
        }
    }

}

```
两个地址返回的内容格式不一样，所以我们要分开处理，getResponseFromJson() 返回是是json 所以直接处理就好了。
getResponseFromXiCi() 返回的是html 页面，所以就需要我们爬取信息啦。使用了Jsoup 类

## 定时获取
做好这些还需要最后一步，定时的爬取这两个地址的IP，因为这些内容是变化的。
所以创建一个定时任务定期的爬取代理IP并存入代理池中。
```

@Component
@Configuration
@EnableScheduling
@Slf4j
public class AutoSpider {

    @Value("${pages}")
    private int pages;

    @Value("${proxyUrl}")
    private String proxyUrl;

    @Autowired
    Spider spider;

    @Scheduled(cron = "0 0 6-23 * * ?")
    public void getIp() {
        List<IpBean> list= null;
        try {
            list = spider.crawl(proxyUrl,pages);
        } catch (Exception e) {
            log.error("{}",e);
        }
        for(IpBean ipBean:list){
            IpPool.add(ipBean);
        }
        log.info("代理数量："+IpPool.ipBeanList.size());
    }

}
```
上面这些，就可以自动定时的获取代理IP，并存入代理池中，我们访问页面的时候直接从代理池中取就好了。不用关心其他。

# 访问路径的设计
我们想要访问的页面url,我们怎么处理呢，刚开始的时候我直接写在application中的，但是这样不灵活感觉，每修改一次就需要重启。所以一样的还是做成了url池并将以文件的形式存放起来。并可以通过接口增删查，也可以直接编辑文件。
urlPool 
```
public class UrlPool {
    public static Set<String> urlPool = new HashSet<>();

    public static void add(String url){
        urlPool.add(url.trim());
    }

    public static void remove(String url){
        urlPool.remove(url.trim());
    }
}
```
## 定时更新url
下面这个方法就是从url.txt 文件中一行一行的读取url ,然后添加到urlPool 中。
```
public static void  getUrlFile(){
        log.info("路径："+ConstantPool.BASEPATH);
        File file = new File(ConstantPool.BASEPATH+ConstantPool.FILENAME);
        if(!file.exists()){
            return;
        }
        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(file));
            String url="";
            while((url = br.readLine())!=null){//使用readLine方法，一次读一行
                log.info(url);
                UrlPool.add(url.trim());
            }
        } catch (Exception e) {
            log.error("{}",e);
        } finally {   //关闭流
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                log.error("{}",e);
            }
        }
    }
```
然后我们创建一个定时任务，定期的执行，将URL存到urlPool 中，利用Set 达到去重的效果。
```
@Component
@Configuration
@EnableScheduling
@Slf4j
public class AutoReadUrl {

    @Scheduled(cron = "0 */30 6-23 * * ?")
    private void configureTasks() {
        FileUtils.getUrlFile();
    }
}
```

## 通过接口增删查url

首先我们写一个向文件末尾增加url。如下就是将源文件读取出来，然后设置
```
fos = new FileOutputStream(file, true);
```
表示支持追加内容。
public static boolean addContentToFile(String urls){
        String[] urlArr=urls.split(ConstantPool.SEPARATORCOMMA);
        File file = new File(ConstantPool.BASEPATH+ConstantPool.FILENAME);
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            if (!file.exists()) {
                boolean hasFile = file.createNewFile();
                if(hasFile){
                    log.info("file not exists, create new file");
                }
                fos = new FileOutputStream(file);
            } else {
                fos = new FileOutputStream(file, true);
            }
            osw = new OutputStreamWriter(fos, "utf-8");

            for(int i=0;i<urlArr.length;i++){
                osw.write(urlArr[i]); //写入内容
                osw.write("\r\n");  //换行
            }
        } catch (Exception e) {
            log.error("{}",e);
            return false;
        } finally {   //关闭流
            try {
                if (osw != null) {
                    osw.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                log.error("{}",e);
                return false;
            }
        }
        return true;
    }

然后写一个增删查的接口
```
@RestController
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping("/url")
public class UrlController {
    @RequestMapping("/add")
    public Set<String> addUrl(@RequestParam(value ="urls")String urls){
        if(FileUtils.addContentToFile(urls)){
            log.info("添加成功："+urls);
        }
        FileUtils.getUrlFile();
        return UrlPool.urlPool;
    }

    @RequestMapping("/list")
    public Set<String> getUrls(){
        FileUtils.getUrlFile();
        return UrlPool.urlPool;
    }

    @RequestMapping("/del")
    public Set<String> delUrls(@RequestParam(value ="urls")String urls){
        FileUtils.delUrlFile();
        Iterator<String> iterator = UrlPool.urlPool.iterator();
        while(iterator.hasNext()){
            String url=iterator.next().trim();
            if(url.equals(urls.trim())){
                iterator.remove();
            }else {
                FileUtils.addContentToFile(url);
            }
        }
        FileUtils.getUrlFile();
        return UrlPool.urlPool;
    }
}
```
其中  ```@CrossOrigin(origins = "*")```表示这个接口支持跨域请求。

这样我们可以通过接口增加删除url .并定期的将url.txt中的url 更新到urlPool 中使用。

# 爬取
通过上面这些，我们的代理池和url池中都有数据啦。
我们这里就以爬取博客为例
我们创建一个线程。
```
@Slf4j
public class VistThread extends Thread{

    private  List<IpBean> proxyList;
    private  String url;

    public VistThread(List<IpBean> proxyList, String url){
        this.proxyList=proxyList;
        this.url=url;
    }

    @Override
    public void run() {
        vistUrlByProxy(proxyList,url);
    }

    /**
     * 单个url,通过代理访问
     * @param list 代理列表
     * @param url  访问的url
     */
    private void vistUrlByProxy(List<IpBean> list, String url){
        if(list==null || list.isEmpty()){
            IpBean ipBean=null;
            vistUrlByProxy(ipBean,url);
        }
        Iterator<IpBean> it = list.iterator();
        while(it.hasNext()){
            IpBean ipBean = it.next();
            if(!vistUrlByProxy(ipBean,url)){
                ipBean=null;
                vistUrlByProxy(ipBean,url);
                it.remove();
            }
        }
    }

    /**
     * 单个url,通过代理访问
     * @param ipBean 代理
     * @param url  访问的url
     */
    private boolean vistUrlByProxy(IpBean ipBean,String url){
        try {
            BlogBean blog=getBlogInfo(url,ipBean);
            if(ipBean==null){
                log.info("真机ip");
            }else{
                log.info("IP:"+ipBean.getIp()+":"+ipBean.getPort());
            }
            log.info("阅读量:"+blog.getReadCount()+blog.getTitleArticle()+"("+blog.getArticleType()+")"+" 访问成功:"+url);
            return true;
        } catch (Exception e) {
            log.error("{}",e);
            log.info("访问失败");
            return false;
        }
    }

    /**
     * 获取文章的标题，类型，阅读数量
     * @param url 访问文章的链接
     * @param ipBean 代理
     * @return
     * @throws Exception
     */
    public BlogBean getBlogInfo(String url, IpBean ipBean)  throws Exception {
        String html=HttpclientUtils.getResponseContent(url,ipBean);
        Document document = Jsoup.parse(html);
        Elements titleArticle=document.getElementsByClass("title-article");
        Elements articleType=document.getElementsByClass("article-type");
        Elements readCount=document.getElementsByClass("read-count");
        BlogBean blog=new BlogBean(titleArticle.text(),articleType.text(),readCount.text());
        return blog;
    }
}
```
getBlogInfo() 方法就可以爬取到博客的基本信息啦。

# 番外
上面贴的代码不是很完整。不过主要的思路就是这样的啦。

完整代码上传到了github:

https://github.com/QuellanAn/SpringCloud/tree/master/views
