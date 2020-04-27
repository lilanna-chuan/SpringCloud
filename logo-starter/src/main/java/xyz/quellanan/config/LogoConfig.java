package xyz.quellanan.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.quellanan.annotation.SelfLogo;
import xyz.quellanan.model.Logo;
import xyz.quellanan.properties.LogoProperties;

import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;

/**
 * @ClassName LogoConfig
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/24 13:56
 * @Version 1.0
 */

@Configuration
@EnableConfigurationProperties(LogoProperties.class)
@ConditionalOnClass(Logo.class)
public class LogoConfig {

    @Autowired
    private LogoProperties logoProperties;

    @Bean
    Logo logo(){
        Logo logo=new Logo();
        logo.setName(logoProperties.getName()==null?LogoProperties.NAME:logoProperties.getName());
        logo.setUrl(logoProperties.getUrl()==null?LogoProperties.URL:logoProperties.getUrl());
        logo.setContent(logoProperties.getContent()==null?LogoProperties.CONTENT:logoProperties.getContent());
        logo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()));
        System.out.println(logo.getName());
        return logo;
    }
}
