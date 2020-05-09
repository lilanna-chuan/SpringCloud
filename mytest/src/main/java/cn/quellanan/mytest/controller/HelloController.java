package cn.quellanan.mytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.quellanan.model.Logo;

import java.util.Map;

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

    @RequestMapping("/")
    public String hello(){
        System.out.println(logo.toString());
        return logo.toString();
    }


    @RequestMapping(value = "/play",method = {RequestMethod.GET,RequestMethod.POST})
    public String play(@RequestParam(value = "s1",required = false) String s1, @RequestParam(value = "s2") String s2){
        System.out.println(s1);
        System.out.println(s2);
        return "ddddd";
    }

    @RequestMapping(value = "/play2",method = RequestMethod.POST)
    public String play2( @RequestBody Map<String,Object> parms){
        System.out.println(parms.get("s1"));
        System.out.println(parms.get("s2"));
        return "ddddd";
    }

    @RequestMapping(value = "/play3",method = RequestMethod.POST)
    public String play3( @RequestBody String s1,String s2){
        System.out.println(s1);
        System.out.println(s2);
        return "ddddd";
    }


    @RequestMapping(value = "/play4",method = RequestMethod.POST)
    public String play4(String s1,String s2){
        System.out.println(s1);
        System.out.println(s2);
        return "ddddd";
    }

    @RequestMapping(value = "/play5/{s1}",method = RequestMethod.POST)
    public String play5(@PathVariable String s1,String s2){
        System.out.println(s1);
        System.out.println(s2);
        return "ddddd";
    }
}
