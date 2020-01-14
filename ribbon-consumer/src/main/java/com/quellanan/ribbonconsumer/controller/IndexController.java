package com.quellanan.ribbonconsumer.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
public class IndexController {

    private static final String applicationName = "ribbon-provider";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/index")
    public String getHello(){
        String url = "http://"+ applicationName +"/hello";
        return  restTemplate.getForObject(url,String.class);
    }

    @RequestMapping("index2")
    public String getHello2(){
        String url = "http://"+ applicationName +"/hello2?name={1}";
        return  restTemplate.getForObject(url,String.class,"quellanan");
    }

    @RequestMapping("index3")
    public String getHello3(){
        //多个参数拼接
        String url = "http://"+ applicationName +"/hello3?name={1}&age={2}";
        return  restTemplate.getForObject(url,String.class,"quellanan","18");
    }

    @RequestMapping("index4")
    public String getHello4(){
        //多参数组装
        Map<String,String> parms=new HashMap<>();
        parms.put("name","quellanan");
        parms.put("age","18");
        String url = "http://"+ applicationName +"/hello3?name={name}&age={age}";
        return  restTemplate.getForObject(url,String.class,parms);
    }

    @RequestMapping("index5")
    public String getHello5(){
        //getForEntity方式
        Map<String,String> parms=new HashMap<>();
        parms.put("name","quellanan");
        parms.put("age","18");
        String url = "http://"+ applicationName +"/hello3?name={name}&age={age}";
        return  restTemplate.getForEntity(url,String.class,parms).getBody();
    }


    @RequestMapping("index6")
    public String getHello6(){
        //postForEntity
        JSONObject params=new JSONObject();
        params.put("name","quellanan");
        params.put("age","18");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(params.toJSONString(), headers);
        String url = "http://"+ applicationName +"/hello4";
        return  restTemplate.postForEntity(url,request,String.class).getBody();
    }

    @RequestMapping("index7")
    public String getHello7(){
        //postForObject
        JSONObject params=new JSONObject();
        params.put("name","quellanan");
        params.put("age","18");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity request = new HttpEntity(params.toJSONString(), headers);
        String url = "http://"+ applicationName +"/hello4";
        return  restTemplate.postForObject(url,params,String.class);
    }
}
