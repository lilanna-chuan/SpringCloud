package xyz.quellanan.views.autotask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xyz.quellanan.views.bean.IpBean;
import xyz.quellanan.views.pool.IpPool;
import xyz.quellanan.views.spider.Spider;

import java.util.List;

/**
 * @ClassName AutoSpider
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/7/15 15:42
 * @Version 1.0
 */

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
