package com.quellanan.hystrixconsumer.service.fallback;

import com.quellanan.hystrixconsumer.service.DocService;
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
public class DocServiceFallback implements DocService {

    @Override
    public String doclink(@RequestParam(value = "docid") String docid, @RequestParam(value = "type") String type) {
        return "doc error";
    }

}
