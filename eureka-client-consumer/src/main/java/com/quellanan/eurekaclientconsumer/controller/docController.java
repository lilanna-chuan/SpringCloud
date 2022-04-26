package com.quellanan.eurekaclientconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName IndexController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/9 16:03
 * @Version 1.0
 */

@RestController
@Slf4j
public class docController {

    private static final String applicationName = "eureka-client-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/edoclink")
    public String getHello(@RequestParam(value = "docid", required = false) String docid,@RequestParam(value = "type", required = false) String type){
       //String url = "http://"+ applicationName +"/doclink?dicid={1}&type={2}";
        String url = "http://"+ applicationName +"/doclink?docid={1}&type={2}";
        log.info("/edoclink");

        return  restTemplate.getForObject(url,String.class,docid,type);

    }
}
