package xyz.quellanan.views.vist;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import xyz.quellanan.views.pool.IpPool;
import xyz.quellanan.views.pool.UrlPool;
import xyz.quellanan.views.util.FileUtils;


/**
 * @ClassName Vist
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/7 19:14
 * @Version 1.0
 */
@Slf4j
@Component
public class Vist implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (true){
            if(UrlPool.urlPool.isEmpty()){
                Thread.sleep(1000*60*2);
            }
            for(String url:UrlPool.urlPool){
                Thread thread=new VistThread(IpPool.ipBeanList,url);
                thread.run();
            }
        }
    }
}
