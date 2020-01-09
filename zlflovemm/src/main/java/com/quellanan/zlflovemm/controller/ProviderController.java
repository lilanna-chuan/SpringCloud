package com.quellanan.zlflovemm.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProviderController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/8 19:42
 * @Version 1.0
 */

@FeignClient("spring-cloud-eureka-client")
@RestController
public class ProviderController {

    @RequestMapping("/hello")
    public String hello(){
        return  "hello quellanan";
    }
}
