package xyz.quellanan.views.util;

import lombok.extern.slf4j.Slf4j;
import xyz.quellanan.views.bean.IpBean;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @ClassName HttpUtils
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/7/9 16:13
 * @Version 1.0
 */
@Slf4j
public class HttpUtils {


    /**
     * 获取返回的html
     * @param url 访问的链接
     * @param ipBean 代理
     * @return
     * @throws Exception
     */
    public static String getResponseContent(String url, IpBean ipBean) throws Exception {
        HttpURLConnection connection=getHttpURLConnection(url,ipBean);
        Thread.sleep(100);
        connection.connect();
        int code = connection.getResponseCode();
        StringBuilder stringBuilder = new StringBuilder();
        if (code == 200) {
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            inputStream.close();
        }
        return stringBuilder.toString();
    }


    /**
     * 如果有代理，这是代理的请求连接conn。HttpURLConnection
     * @param url
     * @param ipBean
     * @return
     * @throws Exception
     */
    public static HttpURLConnection getHttpURLConnection(String url,IpBean ipBean) throws Exception {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        if (ipBean != null) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipBean.getIp(), ipBean.getPort()));
            connection = (HttpURLConnection) new URL(url).openConnection(proxy);
        }
        connection.setUseCaches(false);
        connection.setReadTimeout(8000);

        connection.setConnectTimeout(8000);
        connection.setRequestProperty("Connection","keep-alive");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.75 Safari/537.36");
        return connection;

    }



    /**
     * 如果有代理，这是代理的请求连接conn
     * @param url 请求的地址
     * @param ipBean 代理的bean
     * @return  请求的coon
     * @throws Exception
     */
    public static HttpsURLConnection getHttpsURLConnection(String url,IpBean ipBean) throws Exception {
        HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();
        if (ipBean != null) {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipBean.getIp(), ipBean.getPort()));
            connection = (HttpsURLConnection) new URL(url).openConnection(proxy);
            setProxyHttps(connection,ipBean);
        }
        connection.setUseCaches(false);
        connection.setReadTimeout(8000);
        connection.setConnectTimeout(8000);
        connection.setRequestProperty("Connection","keep-alive");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.75 Safari/537.36");
        return connection;

    }

    /**
     * 如果是HTTPS 请求，需要增加SSL, HttpsURLConnection需要增加校验信息
     * @param connection 连接实例
     * @param ipBean 代理bean
     * @return
     * @throws Exception
     */
    public static HttpsURLConnection setProxyHttps(HttpsURLConnection connection,IpBean ipBean)throws Exception {
        if (ConstantPool.HTTPS.equals(ipBean.getType())) {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());
            connection.setSSLSocketFactory(sslContext.getSocketFactory());
            connection.setHostnameVerifier(new TrustAnyHostnameVerifier());
        }
        return connection;
    }

    /**
     * 设置请求，返回conn
     * @param url
     * @return
     */
    public static HttpURLConnection getResponseConnection(String url){
        HttpURLConnection conn = null;
        try {
            URL realUrl = new URL(url);
            conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setUseCaches(false);
            conn.setReadTimeout(8000);
            conn.setConnectTimeout(8000);
            conn.setInstanceFollowRedirects(false);
            conn.setRequestProperty("Connection","keep-alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.75 Safari/537.36");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 包含重定向路径
     * @param url
     */
    public static String  getResponseContentIs302(String url){
        String html=null;
        try {
            URL serverUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) serverUrl.openConnection();
            conn.setRequestMethod("GET");
            // 必须设置false，否则会自动redirect到Location的地址
            conn.setInstanceFollowRedirects(false);
            conn.addRequestProperty("Accept-Charset", "UTF-8;");
            conn.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0");
            conn.connect();
            String location = conn.getHeaderField("Location");
            if(location!=null&&!location.equals("")){
                serverUrl = new URL(location);
                conn = (HttpURLConnection) serverUrl.openConnection();
                conn.setRequestMethod("GET");
                conn.addRequestProperty("Accept-Charset", "UTF-8;");
                conn.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0");
                conn.connect();
                //System.out.println("跳转地址:" + location);
            }
            int code=conn.getResponseCode();
            System.out.println(code);
            if (code == 200) {
                InputStream is = conn.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = in.readLine()) != null){
                    buffer.append(line);
                }
                html = buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return html;
    }

    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}
