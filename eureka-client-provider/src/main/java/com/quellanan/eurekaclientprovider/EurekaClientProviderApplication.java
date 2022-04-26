package com.quellanan.eurekaclientprovider;

import com.quellanan.eurekaclientprovider.controller.docmanager.DocManageRest;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
//@EnableDiscoveryClient
public class EurekaClientProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProviderApplication.class, args);
    }


    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public DocManageRest docManageRest(){
        return new DocManageRest("TST");
    }
}
