package xyz.quellanan.views.vist;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import xyz.quellanan.views.bean.BlogBean;
import xyz.quellanan.views.bean.IpBean;
import xyz.quellanan.views.pool.IpPool;
import xyz.quellanan.views.util.HttpUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName VistThread
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/9 12:50
 * @Version 1.0
 */
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
        vistUrlByProxy(new ArrayList<>(),url);
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
        String html=HttpUtils.getResponseContent(url,ipBean);
        Document document = Jsoup.parse(html);
        Elements titleArticle=document.getElementsByClass("title-article");
        Elements articleType=document.getElementsByClass("article-type");
        Elements readCount=document.getElementsByClass("read-count");
        int count=Integer.parseInt(readCount.text().substring(4));
        BlogBean blog=new BlogBean(titleArticle.text(),articleType.text(),count);
        return blog;
    }
}
