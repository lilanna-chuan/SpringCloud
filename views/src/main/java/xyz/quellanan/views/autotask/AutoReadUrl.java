package xyz.quellanan.views.autotask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import xyz.quellanan.views.pool.UrlPool;
import xyz.quellanan.views.util.ConstantPool;
import xyz.quellanan.views.util.FileUtils;

import java.io.*;

/**
 * @ClassName AutoReadUrl
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/9 12:36
 * @Version 1.0
 */

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
