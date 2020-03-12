package xyz.quellanan.views.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import xyz.quellanan.views.bean.IpBean;

/**
 * @ClassName HttpclientUtils
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/10 20:08
 * @Version 1.0
 */
public class HttpclientUtils {
    public static void main(String[] args) {
        String url="https://blog.csdn.net/zgahlibin/article/details/83997404";
        IpBean ipBean=null;
        try {
            getResponseContent(url,ipBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getResponseContent(String url,IpBean ipBean)throws Exception {

        CloseableHttpClient httpClient=HttpClients.createDefault();
        HttpGet get=new HttpGet(url);
        get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 Safari/537.36");
        get.setHeader("Connection","keep-alive");
        get.setHeader(new BasicHeader("Cookie","uuid_tt_dd=10_30714036850-1541140649855-958091; smidV2=201811061028335f6b12e4ed7f452d4362aa1fe5a9dda900105c7620fb6bcd0; _ga=GA1.2.527336379.1541663172; ADHOC_MEMBERSHIP_CLIENT_ID1.0=ef298c3d-e0aa-d5e1-67c1-7065bd965bde; bdshare_firstime=1545121309838; CloudGuest=FfKJqS+7DoY6EXwjC/1xyuvR4CFcSyH46eRq/jNBzV2yAVKAxXSiiwTJItcZSyhpKbU6fNx9SUyowmUs2DOKGrvQM4DWSgAiefiPlgDXnoccqJshA/y+PmY3uZTso9gCWSmvWnWH6fn5emV5ElaRnq/97r0eK7TIq78TabF0DYBwDCs4rVBHb9aR7WoJyIjt; Hm_ct_e5ef47b9f471504959267fd614d579cd=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; dc_session_id=10_1563756308256.441717; Hm_lvt_3999cb4c6bca41993e741b74e1f08ef3=1565772567; Hm_ct_3999cb4c6bca41993e741b74e1f08ef3=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; Hm_lvt_ff12343814a6e98be3177c33c77571f5=1569822446; Hm_ct_ff12343814a6e98be3177c33c77571f5=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; Hm_ct_04f9ad533dd151adf2df4eed40b3878b=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; Hm_lvt_7a55576465fd255135675045604b87b1=1571018728; Hm_ct_7a55576465fd255135675045604b87b1=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; Hm_lvt_0f2361ad20bd3facbfd22fe1aa9d1982=1572399190; Hm_ct_0f2361ad20bd3facbfd22fe1aa9d1982=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; Hm_ct_146e5663e755281a5bbe1f3f1c477685=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; __yadk_uid=UMQIGi9HhwIVkEXxEveTVdvkoZzDBfmd; Hm_lvt_b771b9753a47e6a3f0cc5ebdb9e7eeaf=1574043960; Hm_ct_b771b9753a47e6a3f0cc5ebdb9e7eeaf=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; Hm_lvt_1c928fc16c6b64bb50283009a4ece2ff=1574944571; Hm_ct_1c928fc16c6b64bb50283009a4ece2ff=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; Hm_lvt_ca9fe27e7fac2f16d060a632664000b5=1574990491; Hm_ct_ca9fe27e7fac2f16d060a632664000b5=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; Hm_lvt_04f9ad533dd151adf2df4eed40b3878b=1575369174; Hm_lvt_397545f38b364af17f699ca43cac2398=1576197847; Hm_ct_397545f38b364af17f699ca43cac2398=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; UM_distinctid=16f11dcee4450e-0750ff40114ba9-2393f61-100200-16f11dcee458d1; Hm_lvt_8cfddb34ff818309d1644b2b4cad97d7=1577154275; Hm_ct_8cfddb34ff818309d1644b2b4cad97d7=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; Hm_lvt_8875c662941dbf07e39c556c8d97615f=1577188246; CNZZDATA1262138305=783873964-1578960225-https%253A%252F%252Fwww.csdn.net%252F%7C1578960225; Hm_lvt_146e5663e755281a5bbe1f3f1c477685=1578963230; Hm_lvt_760b8e9d3c1f7691361ec306101d237c=1579049680; Hm_ct_760b8e9d3c1f7691361ec306101d237c=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; UN=qq_27790011; Hm_ct_6bcd52f51e9b3dce32bec4a3997715ac=1788*1*PC_VC!5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; Hm_lvt_65c9e91fa3a639df46cc94cab0f3f53f=1579253943; Hm_ct_65c9e91fa3a639df46cc94cab0f3f53f=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; Hm_lvt_3d15b54c05cce175f30e9f8e2aeceb64=1582711548; Hm_ct_3d15b54c05cce175f30e9f8e2aeceb64=5744*1*qq_27790011!6525*1*10_30714036850-1541140649855-958091; __gads=ID=01fb8d5a83b84433:T=1583289529:S=ALNI_MbHJC8V8GIHCMFK6ecNcuTQeH3-9Q; Hm_lvt_e5ef47b9f471504959267fd614d579cd=1582806547,1583459606; TY_SESSION_ID=1c61be3a-2a35-461f-b55b-55643ea14f27; hasSub=true; announcement=%257B%2522isLogin%2522%253Atrue%252C%2522announcementUrl%2522%253A%2522https%253A%252F%252Fblog.csdn.net%252Fblogdevteam%252Farticle%252Fdetails%252F103603408%2522%252C%2522announcementCount%2522%253A0%252C%2522announcementExpire%2522%253A3600000%257D; SESSION=9243eeb3-1c3f-4b09-a659-174be33dd951; UserName=qq_27790011; UserNick=%E7%A8%8B%E5%BA%8F%E5%91%98%E7%88%B1%E9%85%B8%E5%A5%B6%28QuellanAn%29; AU=E67; p_uid=U100000; UserInfo=a9d5da230a6a4230a3da79eee17d14c3; UserToken=a9d5da230a6a4230a3da79eee17d14c3; BT=1583842666264; utm_source=distribute.pc_feed.none-task; c_ref=https%3A//www.baidu.com/link%3Furl%3DeQlwFGE5XM7b9qKGHhwNNqsCb8jCmb-aqcsoNuC1eULwh2SN0v4OllsTtdQsKbRLiEvQe4ll36rtdXf7YpczlOWgV5Y9oxeJlWPwfN58vvq%26wd%3D%26eqid%3D87a052cc00008672000000055e6786ab; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1583839975,1583840051,1583842542,1583842993; dc_tos=q6za6p; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1583844434"));
        CloseableHttpResponse response = httpClient.execute(get);
        if(ipBean!=null){
            HttpHost proxy = new HttpHost(ipBean.getIp(), ipBean.getPort());
            RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
            get.setConfig(config);
        }
        int statusCode = response.getStatusLine().getStatusCode();
        String responseContent="";
        if(statusCode==200){
            HttpEntity entity = response.getEntity();
            responseContent= EntityUtils.toString(entity,"utf-8");
        }
        //关闭httpClient
        response.close();
        httpClient.close();
        return responseContent;
    }

}
