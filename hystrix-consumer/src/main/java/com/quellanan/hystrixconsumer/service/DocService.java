package com.quellanan.hystrixconsumer.service;

import com.quellanan.hystrixconsumer.service.fallback.DocServiceFallback;
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

@FeignClient(name = "ribbon-provider",fallback = DocServiceFallback.class)
public interface DocService {


    @RequestMapping("/doclink")
    public String doclink(@RequestParam(value = "docid") String docid, @RequestParam(value = "type") String type);


}
