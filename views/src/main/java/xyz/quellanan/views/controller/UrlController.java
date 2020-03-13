package xyz.quellanan.views.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.quellanan.views.pool.IpPool;
import xyz.quellanan.views.pool.UrlPool;
import xyz.quellanan.views.util.ConstantPool;
import xyz.quellanan.views.util.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @ClassName UrlController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/9 11:06
 * @Version 1.0
 */
@RestController
@CrossOrigin(origins = "*")
@Slf4j
@RequestMapping("/url")
public class UrlController {


    @RequestMapping("/add")
    public Set<String> addUrl(@RequestParam(value ="urls")String urls){
        if(FileUtils.addContentToFile(urls)){
            log.info("添加成功："+urls);
        }
        FileUtils.getUrlFile();
        return UrlPool.urlPool;
    }

    @RequestMapping("/list")
    public Set<String> getUrls(){
        FileUtils.getUrlFile();
        return UrlPool.urlPool;
    }

    @RequestMapping("/del")
    public Set<String> delUrls(@RequestParam(value ="urls")String urls){
        FileUtils.delUrlFile();
        Iterator<String> iterator = UrlPool.urlPool.iterator();
        while(iterator.hasNext()){
            String url=iterator.next().trim();
            if(url.equals(urls.trim())){
                iterator.remove();
            }else {
                FileUtils.addContentToFile(url);
            }
        }
        FileUtils.getUrlFile();
        return UrlPool.urlPool;
    }


}
