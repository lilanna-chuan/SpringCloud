package xyz.quellanan.views.pool;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName UrlPool
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/9 10:12
 * @Version 1.0
 */
public class UrlPool {
    public static Set<String> urlPool = new HashSet<>();


    public static void add(String url){
        urlPool.add(url.trim());
    }

    public static void remove(String url){
        urlPool.remove(url.trim());
    }
}
