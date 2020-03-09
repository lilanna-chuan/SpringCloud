package com.quellanan.kafkaproducer.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @ClassName KafkaProducerController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/2/25 15:56
 * @Version 1.0
 */

@RestController
public class KafkaProducerController {


    @Resource
    private KafkaTemplate<String,String> KafkaTemplate;


    @RequestMapping("/send")
    public String sendMsg(@RequestParam(value = "topic")String topic,@RequestParam(value = "msg")String msg){
        KafkaTemplate.send(topic,msg);
        return "success";
    }

}
