package com.quellanan.ribbonprovider9005.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName HelloController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/14 10:57
 * @Version 1.0
 */

@RestController
@Slf4j
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String hello(){
        log.info(port);
        return "hello "+port;
    }

    @RequestMapping("/hello2")
    public String hello2(@RequestParam("name") String name){
        log.info(name);
        return "hello "+name+port;
    }

    @RequestMapping("/hello3")
    public String hello3(@RequestParam("name") String name,@RequestParam("age") String age){
        log.info(name+age);
        return "hello "+name+age+port;
    }

    @RequestMapping("/hello4")
    public String hello4(@RequestBody Map<String, Object> parms){
        return "hello "+parms.get("name")+parms.get("age")+port;
    }
}