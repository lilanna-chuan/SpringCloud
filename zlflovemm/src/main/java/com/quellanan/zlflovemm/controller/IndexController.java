package com.quellanan.zlflovemm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IndexController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/6 15:15
 * @Version 1.0
 */

@RestController
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "hello zlflovemm";
    }
}
