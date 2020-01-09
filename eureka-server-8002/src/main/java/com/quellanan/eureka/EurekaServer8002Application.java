package com.quellanan.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer8002Application  {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer8002Application.class, args);
    }

}
