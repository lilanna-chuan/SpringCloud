package cn.quellanan.mytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.quellanan.model.Logo;

/**
 * @ClassName HelloController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/4/24 14:53
 * @Version 1.0
 */
@RestController
public class HelloController {

    @Autowired
    Logo logo;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println(logo.toString());
        return logo.toString();
    }
}
