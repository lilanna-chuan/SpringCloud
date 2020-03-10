package xyz.quellanan.views.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import xyz.quellanan.views.util.FileUtils;

/**
 * @ClassName LoadUrlToPoolConfig
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/10 10:52
 * @Version 1.0
 */

@Slf4j
@Component
public class LoadUrlToPoolConfig implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) {
        FileUtils.getUrlFile();
    }
}
