package xyz.quellanan.views.util;

import org.springframework.util.ClassUtils;

/**
 * @ClassName ConstantPool
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/7/9 14:02
 * @Version 1.0
 */
public class ConstantPool {

    public static final String HTTP = "HTTP";
    public static final String HTTPS = "HTTPS";
    public static final String MY_IP_API = "https://www.ipip.net/ip.html";
    public static final String SEPARATORSLASH ="/";
    public static final String SEPARATORCOMMA =",";
    public static final String PAGES ="pages";
    public static final String PROXYIPTYPE ="proxyIpType";
    public static final String VISTBASEURL ="vistBaseUrl";
    public static final String AUTHORID ="authorId";

    public static final String BASEPATH = ClassUtils.getDefaultClassLoader().getResource("").getPath();
    public static final String FILENAME = "urls.txt";




}
