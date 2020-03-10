package xyz.quellanan.views.autotask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xyz.quellanan.views.bean.IpBean;
import xyz.quellanan.views.pool.IpPool;
import xyz.quellanan.views.pool.UrlPool;
import xyz.quellanan.views.vist.VistThread;

import java.util.List;

/**
 * @ClassName AutoVist
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/10 10:47
 * @Version 1.0
 */

@Component
@Configuration
@EnableScheduling
@Slf4j
public class AutoVist {

    @Scheduled(cron = "0 */3 6-23 * * ?")
    public void getIp() {
        if(UrlPool.urlPool.isEmpty()){
            return;
        }
        for(String url:UrlPool.urlPool){
            Thread thread=new VistThread(IpPool.ipBeanList,url);
            thread.run();
        }
    }
}
