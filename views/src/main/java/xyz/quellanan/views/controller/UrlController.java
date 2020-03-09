package xyz.quellanan.views.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.quellanan.views.pool.IpPool;
import xyz.quellanan.views.util.ConstantPool;
import xyz.quellanan.views.util.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @ClassName UrlController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/9 11:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/url")
@Slf4j
public class UrlController {


    @RequestMapping("/add")
    public String addUrl(@RequestParam(value ="urls")String urls){
        if(FileUtils.addContentToFile(urls)){
            return "success";
        }
        return "error";
    }


}
