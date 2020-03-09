package xyz.quellanan.views.spider;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import xyz.quellanan.views.bean.IpBean;
import xyz.quellanan.views.util.ConstantPool;
import xyz.quellanan.views.util.HttpUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Spider
 * @Description 从页面爬取IP
 * @Author zhulinfeng
 * @Date 2019/7/12 19:42
 * @Version 1.0
 */
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
    public List<IpBean> crawl(String url,int pages){
        this.pages = pages;
        return crawl(url);
    }

    /**
     * 不带页数的爬取，爬取URL返回的页面数据。
     * @param url
     * @return
     */
    public List<IpBean> crawl(String url){
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
    private void crawlNoPage(String url){
        getResponseFromJson(HttpUtils.getResponseConnection(url));
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
            html = HttpUtils.getResponseContent(url + index,null);
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
