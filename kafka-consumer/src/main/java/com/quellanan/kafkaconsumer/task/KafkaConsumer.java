package com.quellanan.kafkaconsumer.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName KafkaConsumer
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/2/25 16:36
 * @Version 1.0
 */

@Component
@Slf4j
public class KafkaConsumer {



    @KafkaListener(groupId = "test-group",topics = "test3")
    public void listen(String msg){
        log.info("接收消息："+msg);
    }

}
