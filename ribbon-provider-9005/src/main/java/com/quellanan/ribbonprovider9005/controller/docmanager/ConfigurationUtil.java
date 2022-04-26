package com.quellanan.ribbonprovider9005.controller.docmanager;

public class ConfigurationUtil {
    public static String getSysConfigSingleValue(String planConfig, String doc, String ipport) {

        String res="";

        switch (ipport){
            case "ipport":
                res="https://172.43.15.253:8088";
                break;
            case "applytokenUrl":
                res="/api/ec/dev/auth/applytoken";
                break;
            case "registUrl":
                res="/api/ec/dev/auth/regist";
                break;
            case "deleteUrl":
                res="/api/dcs/deletedoc";
                break;
            case "saveUrl":
                res="/api/dcs/savedocfile";
                break;
            case "getLinkUrl":
                res="/api/dcs/getDocLink";
                break;
        }

        if(res.equals("")&&planConfig.equals("TST")){
            switch (ipport){
                case "appid":
                    res="6b9ec0d4-886d-477c-9159-6e72a5a495ce";
                    break;
                case "secret":
                    res="aa479fce-3cdc-4b89-90d5-bab91639b3ed";
                    break;

                case "cpk":
                    res="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAghrU9bca6OAH3090eA6muG0z4nKRUM6EO1sJEPm3m73c" +
                            "Ccd3+IG+swUiMvwBr0IMR0z48R8s6spsFQQi0MLI+jtAZWxK6HiAuIgeXIjKyTXN2IaUfLtYa2yJ4AXXOeWr" +
                            "nXvOr+VC+jYDV3/cgr0As3emHrQ1tJRVtfRRCTO7MXU5yNKD1QnbOSWx5KFi5CXueWyjhZ9CRZ5BWb453EYO" +
                            "yivP64csYWL2UxF5u5bUlCYpUFCvvMJEzOP8ziAvhOHKDjt/OusmZLsiheIuesuWxCKwYDvgnLNO4/sZqbU5" +
                            "tXNxs/Z40IyqvP/eJtVAJngrertEyLa7yk70IGMBV5dPWwIDAQAB";
                    ;
                    break;
                case "dirid":
                    res="4044";//文件目录，需要文档系统提供
                    break;
                case "workcode":
                    res="itgk";
                    break;
                case "trackerServer":
                    res="172.42.1.10:22122";
                    break;
            }
        }
        return res;
    }

}
