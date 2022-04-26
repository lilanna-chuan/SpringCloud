package com.quellanan.ribbonprovider9004;

import com.quellanan.ribbonprovider9004.controller.docmanager.DocManageRest;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
@EnableEurekaClient
public class RibbonProvider9004Application {

	public static void main(String[] args) {
		SpringApplication.run(RibbonProvider9004Application.class, args);
	}



	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public DocManageRest docManageRest(){
		return new DocManageRest("PRO");
	}
}
