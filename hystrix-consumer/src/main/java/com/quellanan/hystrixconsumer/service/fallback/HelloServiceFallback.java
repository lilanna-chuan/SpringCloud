package com.quellanan.hystrixconsumer.service.fallback;

import com.quellanan.hystrixconsumer.service.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @ClassName HelloServiceFallback
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/15 15:11
 * @Version 1.0
 */
@Component
public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "hello error";
    }

    @Override
    public String hello2(@RequestParam(value = "name") String name) {
        return "hello2 error";
    }

    @Override
    public String hello3(@RequestParam(value = "name") String name, @RequestParam(value = "age") String age) {
        return "hello3 error";
    }

    @Override
    public String hello4(@RequestBody Map<String, Object> parms) {
        return "hello4 error";
    }
}
