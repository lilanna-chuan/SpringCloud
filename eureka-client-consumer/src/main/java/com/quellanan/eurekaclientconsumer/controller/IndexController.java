package com.quellanan.eurekaclientconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName IndexController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/9 16:03
 * @Version 1.0
 */

@RestController
public class IndexController {

    private static final String applicationName = "eureka-client-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/index")
    public String getHello(){
        String url = "http://"+ applicationName +"/hello";
        return  restTemplate.getForObject(url,String.class);
    }
}
