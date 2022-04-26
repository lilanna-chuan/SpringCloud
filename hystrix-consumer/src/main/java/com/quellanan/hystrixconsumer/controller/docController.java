package com.quellanan.hystrixconsumer.controller;

import com.quellanan.hystrixconsumer.service.DocService;
import com.quellanan.hystrixconsumer.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName IndexController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/1/9 16:03
 * @Version 1.0
 */

@RestController
@Slf4j
public class docController {

    @Autowired
    public DocService docService;

    @RequestMapping("/hdoclink")
    public String getDocLink(@RequestParam(value = "docid", required = false) String docid,@RequestParam(value = "type", required = false) String type){
       //String url = "http://"+ applicationName +"/doclink?dicid={1}&type={2}";

        log.info("/hdoclink");
        return  docService.doclink(docid,type)+"";

    }
  /*  @RequestMapping(value=("/pdoclink"),method = RequestMethod.POST)
    public String getPdocLink(@RequestParam(value = "docid", required = false) String docid,@RequestParam(value = "type", required = false) String type){

        log.info("/pdoclink");
        return  docService.doclink(docid,type)+"";

    }*/

}
