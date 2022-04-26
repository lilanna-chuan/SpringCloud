package com.quellanan.ribbonprovider9004.controller.docmanager;



import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;


public class DocManageRest {
	
	/**
	 * 应用ID
	 */
	public  String appid;
	/**
	 */
	public  String secret;
	public  String cpk;
	
	
	public  String dirid;
	
	public  String workcode;
	
	public  String ipport;
	
	/**
	 * 许可证注册接口
	 */
	public  String registUrl;
	
	/**
	 * 申请token接口
	 */
	public  String applytokenUrl;
	
	/**
	 * 文档server地址
	 */
	public  String trackerServer;
	
	/**
	 * savedocfile地址
	 */
	public  String saveUrl;
	
	/**
	 * deletedocfile地址
	 */
	public  String deleteUrl;
	/**
	 * getLinkUrl地址
	 */
	public  String getLinkUrl;
	
	
	/**
	 * 文档token
	 */
	public  String token;
	/**
	 * 文档token无效时间(具体时间)
	 */
	public  Long tokenValidTime;
	/**
	 * 文档token无效时间(秒)
	 */
	public  Integer validTime = 600;
	
	public  String encryptUserid;


	public DocManageRest(String env){
		initConfig(env);

	}
	
	public  void initConfig(String env){
		//接口主地址，需要文档系统提供
		ipport = ConfigurationUtil.getSysConfigSingleValue(env, "doc", "ipport");
		//获取token地址，需要文档系统提供
		applytokenUrl = ipport+ConfigurationUtil.getSysConfigSingleValue(env, "doc", "applytokenUrl");
		//保存文件地址，需要文档系统提供
		saveUrl = ipport+ConfigurationUtil.getSysConfigSingleValue(env, "doc", "saveUrl");
		//预览或下载文件地址，需要文档系统提供
	    getLinkUrl = ipport+ConfigurationUtil.getSysConfigSingleValue(env, "doc", "getLinkUrl");

		//appid，需要文档系统提供
		appid = ConfigurationUtil.getSysConfigSingleValue(env, "doc", "appid");
		//cpk，需要文档系统提供
		cpk = ConfigurationUtil.getSysConfigSingleValue(env, "doc", "cpk");
		//secret，需要文档系统提供
		secret= ConfigurationUtil.getSysConfigSingleValue(env, "doc", "secret");
		//目录id，需要文档系统提供
		dirid= ConfigurationUtil.getSysConfigSingleValue(env, "doc", "dirid");
		//账号，需要文档系统提供
		workcode= ConfigurationUtil.getSysConfigSingleValue(env, "doc", "workcode");
		//trackerServer ，需要文档系统提供
		trackerServer = ConfigurationUtil.getSysConfigSingleValue(env, "doc", "trackerServer");
	}
	
	/**
     * 解析返回JSON
     *
     * @param result
     * @param parseName
     * @return
     */
    public  String parseJson(String result, String parseName) {
        String str = "";
        JSONObject jsonObject = JSONObject.parseObject(result);
        if (jsonObject.containsKey(parseName)) {
            str = jsonObject.getString(parseName);
        }
        return str;
    }
    
	public  String getToken() {
		if(token!=null&&!"".equals(token)&&System.currentTimeMillis()<tokenValidTime){
			return token;
		}


        // 获取Token
		String spk=cpk;
		RSA rsa = new RSA(null, spk);
        String encryptSecret = rsa.encryptBase64(secret, CharsetUtil.CHARSET_UTF_8, KeyType.PublicKey);
		System.out.println("applytokenUrl:" +applytokenUrl);
		String result = HttpRequest.post(applytokenUrl).contentType("application/json;charset=UTF-8").header("appid", appid)
                .header("secret", encryptSecret).header("time", ""+validTime).execute().body();
        System.out.println("获取Token:" + result);
        token = parseJson(result, "token");
        tokenValidTime = System.currentTimeMillis()+ validTime*1000-2000;
        
        System.out.printf("获取token成功- 当前时间:%s 失效时间:%s \n",LocalDateTime.now(),LocalDateTime.ofInstant(Instant.ofEpochMilli(tokenValidTime), ZoneId.systemDefault()));
        // 返回验证信息
        encryptUserid = rsa.encryptBase64("1", CharsetUtil.CHARSET_UTF_8, KeyType.PublicKey);
        
        return token;
    }

	


	
	

	
	/**
	 * 文件删除 DeleteDoc 服务
	 * @param docids
	 * @return
	 */
	public  Map<String, String> deleteDoc(String docids){
		Map<String, String> rMap = new HashMap<String,String>();
		
        JSONObject requestJson = new JSONObject();
        requestJson.put("workcode", workcode);
        requestJson.put("billid", "1");
        requestJson.put("docids", docids);
        String ttoken = getToken();
        String result = HttpRequest.post(deleteUrl).contentType("application/json;charset=UTF-8")
                .header("appid", appid).header("token", ttoken)
                .header("userid", encryptUserid).body(requestJson.toJSONString()).execute().body();
        JSONObject job = (JSONObject)JSONObject.parse(result);
        if("0".equals(job.getString("errcode"))){
        	rMap.put("situation", job.getString("errcode"));
        	rMap.put("errmsg",job.getString("errmsg"));
        }else{
        	rMap.put("situation", "-1");
        	rMap.put("errmsg",job.getString("errmsg"));
        }
		return rMap;
	}
	
	/**
	 * 文件下载downloadFile 读取服务
	 * @param docId
	 * @return
	 */
	//("文件下载downloadFile 读取服务")
	public  String downloadFile(String docId, String filename, HttpServletResponse response, String tp){
		 String type = tp;
	        // 获取全局
      
		JSONArray docidsArr = new JSONArray();
        JSONObject tokenObject = new JSONObject();
        docidsArr.add(docId);
        tokenObject.put("docids", docidsArr);
        tokenObject.put("appid", appid);
        tokenObject.put("workcode", workcode);
        // 0、在线查看链接 1、下载链接
        tokenObject.put("type", type);
        String ttoken = getToken();
        
        System.out.printf("获取linkUrl参数:%s \n",tokenObject.toJSONString());
        System.out.printf("获取linkUrl的header: appid:%s token:%s userid:%s \n",appid,ttoken,encryptUserid);
        
        
        String result = HttpRequest.post(getLinkUrl).contentType("application/json;charset=UTF-8")
                .header("appid", appid).header("token", ttoken)
                .header("userid", encryptUserid).body(tokenObject.toJSONString()).execute().body();
       
        System.out.printf("获取linkUrl结果:%s \n",result);
        
        JSONArray jsonArray = JSONObject.parseObject(result).getJSONArray("data");
		System.out.printf("获取jsonArray结果:%s \n",jsonArray);
        if(jsonArray!=null&&jsonArray.size()>0){
        	String fileIOurl = jsonArray.getJSONObject(0).getString("fileIOurl");

			}

        return result;

	}
	
	
	public  void fileOutput(String fileUrl, OutputStream os) {
        InputStream fis = null;
        try {
        	fis = HttpRequest.get(fileUrl).execute().bodyStream();
            //fis = new URL(fileUrl).openStream();
            byte[] b = new byte[1024];
            int length;
            while ((length = fis.read(b)) > 0)
            {
                os.write(b, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        	try {
				fis.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        	try {
				os.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
        }
    }
	
	/**
     * 转换和解析JSONArray
     * @return
     */
	public  String parseJSONArray(String result, String type) {
		String rs=null;
        // type 0、在线查看链接 1、普通下载链接 11 文件流下载
		JSONArray jsonArray =(JSONArray) new JSONObject((JSONObject) JSON.parse(result)).get("data");
		System.out.printf("获取jsonArray解析结果:%s \n",jsonArray);
		if(jsonArray!=null&&jsonArray.size()>0){
			if( "0".equals(type)){
				rs = jsonArray.getJSONObject(0).getString("docurl");
			}else if( "1".equals(type)){
				rs = jsonArray.getJSONObject(0).getString("docdownurl");
			}
			else if( "11".equals(type)){
				rs = jsonArray.getJSONObject(0).getString("fileIOurl");
				System.out.printf("11解析结果:%s \n",rs);
			}else if( "2".equals(type)){
				rs = jsonArray.getJSONObject(0).getString("docurl");
			}else if( "3".equals(type)){
				rs = jsonArray+"";
			}

		}else{
			rs="结果解析失败result："+result;
		}

		return rs;
    }
	
	
	
	

	

	public static Map[] dataForma(Map[] docMap,String planmId,String ctype,String creator){
		Map[] insertMap = new Map[docMap.length];
		int i = 0;
		for (Map map : docMap) {
			if(!"0".equals(map.get("situation").toString())){//排除上传失败的文件
				continue;
			}
			insertMap[i] = map;
			//insertMap[i].xx = xx;//添加其他属性
			insertMap[i].put("ctype", ctype);
			insertMap[i].put("masterId", planmId);
			insertMap[i].put("creator", creator);
			i++;
		}
		return insertMap;
	}
	
	
	
	public static void main(String[] args) {

		DocManageRest dmrt=new DocManageRest("TST");
		String s=dmrt.downloadFile("39865","测试文件",null,"0");

		String fio=dmrt.parseJSONArray(s,"0");




		
	}
}
