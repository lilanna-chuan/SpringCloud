package com.quellanan.eurekaclientprovider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/9 15:36
 * @Version 1.0
 */

@RestController
@Slf4j
public class HelloController {


    @RequestMapping("/hello")
    public String hello(){
        return "hello world ";
    }
}
