package com.quellanan.ribbonprovider9004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RibbonProvider9004Application {

	public static void main(String[] args) {
		SpringApplication.run(RibbonProvider9004Application.class, args);
	}

}
