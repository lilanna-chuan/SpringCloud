package com.quellanan.ribbonprovider9004.controller.docmanager;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description DOTO
 * @Author wangwc
 * @Date 2020/1/9 15:36
 * @Version 1.0
 */

@RestController
@Slf4j
public class DocController {

    @Autowired
    private DocManageRest docManageRest;

    @RequestMapping("/doclink")
    public String doclink(@RequestParam(value = "docid", required = false) String docid,@RequestParam(value = "type", required = false) String type){
        log.info(docid);
        log.info(type);
        if(docid==null||type==null){
            return "请传参数";
        }
        String parseType=type;
        if("11".equals(type)){
            type="1";
        }
        return docManageRest.parseJSONArray(docManageRest.downloadFile(docid,"测试文件",null,type),parseType);
        //return "hello "+name+age+port;
    }
}
