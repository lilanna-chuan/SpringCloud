package com.quellanan.ribbonprovider9005;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonProvider9005Application {

    public static void main(String[] args) {
        SpringApplication.run(RibbonProvider9005Application.class, args);
    }

}
