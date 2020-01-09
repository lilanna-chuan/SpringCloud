package com.quellanan.zlflovemm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConsumerController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/8 19:47
 * @Version 1.0
 */

@RestController
public class ConsumerController {
    private static final String applicationName = "spring-cloud-eureka-client";


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/gethello")
    public String getHello(){
        String url = "http://"+ applicationName +"/zlflovemm/hello";
        return  restTemplate.getForObject(url,String.class);
    }
}
