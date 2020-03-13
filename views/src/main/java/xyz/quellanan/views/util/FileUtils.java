package xyz.quellanan.views.util;

import lombok.extern.slf4j.Slf4j;
import xyz.quellanan.views.pool.UrlPool;

import java.io.*;

/**
 * @ClassName FileUtils
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2020/3/9 17:17
 * @Version 1.0
 */

@Slf4j
public class FileUtils {


    public static boolean addContentToFile(String urls){
        String[] urlArr=urls.split(ConstantPool.SEPARATORCOMMA);
        File file = new File(ConstantPool.BASEPATH+ConstantPool.FILENAME);
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            if (!file.exists()) {
                boolean hasFile = file.createNewFile();
                if(hasFile){
                    log.info("file not exists, create new file");
                }
                fos = new FileOutputStream(file);
            } else {
                fos = new FileOutputStream(file, true);
            }
            osw = new OutputStreamWriter(fos, "utf-8");

            for(int i=0;i<urlArr.length;i++){
                osw.write(urlArr[i]); //写入内容
                osw.write("\r\n");  //换行
            }
        } catch (Exception e) {
            log.error("{}",e);
            return false;
        } finally {   //关闭流
            try {
                if (osw != null) {
                    osw.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                log.error("{}",e);
                return false;
            }
        }
        return true;
    }

    public static void delUrlFile(){
        File file = new File(ConstantPool.BASEPATH+ConstantPool.FILENAME);
        if(!file.exists()){
            return;
        }
        file.delete();
    }

    public static void  getUrlFile(){
        log.info("路径："+ConstantPool.BASEPATH);
        File file = new File(ConstantPool.BASEPATH+ConstantPool.FILENAME);
        if(!file.exists()){
            return;
        }
        BufferedReader br=null;
        try {
            br = new BufferedReader(new FileReader(file));
            String url="";
            while((url = br.readLine())!=null){//使用readLine方法，一次读一行
                log.info(url);
                UrlPool.add(url.trim());
            }
        } catch (Exception e) {
            log.error("{}",e);
        } finally {   //关闭流
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                log.error("{}",e);
            }
        }
    }
}
