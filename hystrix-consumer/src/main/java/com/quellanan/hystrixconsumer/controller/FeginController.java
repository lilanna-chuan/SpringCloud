package com.quellanan.hystrixconsumer.controller;

import com.quellanan.hystrixconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FeginController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/14 19:00
 * @Version 1.0
 */

@RestController
public class FeginController {

    @Autowired
    public HelloService helloService;


    @RequestMapping("/fegin")
    public String getHello(){
        return  helloService.hello()+"hystrix-consumer";
    }

    @RequestMapping("/fegin2")
    public String getHello2(){
        String name="quellanan";
        return  helloService.hello2(name)+"hystrix-consumer";
    }


    @RequestMapping("/fegin3")
    public String getHello3(){
        String name="quellanan";
        String age="18";
        return  helloService.hello3(name,age)+"hystrix-consumer";
    }

    @RequestMapping("/fegin4")
    public String getHello4(){
        Map<String, Object> parms=new HashMap<>();
        parms.put("name","quellanan");
        parms.put("age","18");
        return  helloService.hello4(parms)+"hystrix-consumer";
    }
}
