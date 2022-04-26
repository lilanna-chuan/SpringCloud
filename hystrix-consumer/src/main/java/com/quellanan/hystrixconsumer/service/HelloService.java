package com.quellanan.hystrixconsumer.service;

import com.quellanan.hystrixconsumer.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @ClassName HelloService
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/14 19:10
 * @Version 1.0
 */

@FeignClient(name = "ribbon-provider-doc",fallback = HelloServiceFallback.class)
public interface HelloService {

    @RequestMapping("/hello")
    public String hello();

    @RequestMapping("/hello2")
    public String hello2(@RequestParam(value = "name") String name);

    @RequestMapping("/hello3")
    public String hello3(@RequestParam(value = "name") String name, @RequestParam(value = "age") String age);

    @RequestMapping("/hello4")
    public String hello4(@RequestBody Map<String, Object> parms);

}
