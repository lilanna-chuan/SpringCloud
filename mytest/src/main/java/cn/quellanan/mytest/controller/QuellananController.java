package cn.quellanan.mytest.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName QuellananController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/5/8 15:10
 * @Version 1.0
 */

@RestController
public class QuellananController {


    @RequestMapping(value = "/hello",method = {RequestMethod.GET,RequestMethod.POST})
    public String play(@RequestParam(value = "name",required = false) String name,@RequestParam(value = "sex")String sex, HttpServletRequest request){
        Map<String, String[]> map=request.getParameterMap();
        for(Map.Entry<String, String[]> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+Arrays.toString(entry.getValue()));
        }
        return name+",你好! \n你的性别是:"+sex;
    }

    @RequestMapping(value = "/hello1",method = {RequestMethod.GET,RequestMethod.POST})
    public String play1(@RequestBody Map<String,Object> parms, HttpServletRequest request){
        Map<String, String[]> map=request.getParameterMap();
        for(Map.Entry<String, String[]> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+Arrays.toString(entry.getValue()));
        }
        return parms.get("name")+",你好! \n你的性别是:"+parms.get("sex");
    }


    @RequestMapping(value = "/hello2",method = {RequestMethod.POST})
    public String play2(@RequestBody List<Map<String,Object>> parms){
        StringBuilder stringBuilder=new StringBuilder();
        for(Map<String,Object> map:parms){
            stringBuilder.append(map.get("name")+",你好! \n你的性别是:"+map.get("sex")+"\n");
        }

        return stringBuilder.toString();
    }

    @RequestMapping(value = "/hello3",method = {RequestMethod.GET,RequestMethod.POST})
    public String play3(@RequestBody List<User> users){
        StringBuilder stringBuilder=new StringBuilder();
        for(User user:users){
            stringBuilder.append(user.getName()+",你好! \n你的性别是:"+user.getSex()+"\n");
        }
        return stringBuilder.toString();
    }

    @RequestMapping(value = "/hello4/{name}/{sex}",method = {RequestMethod.GET,RequestMethod.POST})
    public String play4(@PathVariable String name,@PathVariable String sex) {
        return name+",你好! \n你的性别是:"+sex;
    }

    @RequestMapping(value = "/hello5",method = {RequestMethod.GET,RequestMethod.POST})
    public String play5(String name,String sex, HttpServletRequest request){
        Map<String, String[]> map=request.getParameterMap();
        for(Map.Entry<String, String[]> entry:map.entrySet()){
            System.out.println(entry.getKey()+":"+Arrays.toString(entry.getValue()));
        }
        return name+",你好! \n你的性别是:"+sex;
    }
    @RequestMapping(value = "/hello6",method = {RequestMethod.GET,RequestMethod.POST})
    public String play6( User user){
        return user.getName()+",你好! \n你的性别是:"+user.getSex();
    }




}
