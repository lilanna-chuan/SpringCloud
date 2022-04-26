package com.quellanan.ribbonprovider9004.controller.docmanager;

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
        if(planConfig.equals("PRO")&&"ipport".equals(ipport)){
            res="https://jkcdoc.jinke.com:18088";
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

        if(res.equals("")&&planConfig.equals("PRO")){
            switch (ipport){
                case "appid":
                    res="2fb97d02-7a5d-4f6c-9efd-ab14c069e57b";
                    break;
                case "secret":
                    res="ea120bd7-e9b7-4a8a-ba9f-4488dae7d227";
                    break;

                case "cpk":
                    res="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkRjFPyNupi4MMIfCf02c9sf8WOMkEDvjYyehND6S9U9TFugOzNkqthAab1QkaW7+THjuf4PRrsWEZDyp0R9wlhJQdYt2yB3TFEbiR60ZeYsa7/WVY+QRbfW+q+U3cbZMgi+79sGs8fz6D7MKx9yuMRa3BZuU0jjCf77kE6F6Ch1/6o4CAx07WfeOJ9Z4XR9ZqFtQRse6+j4k1CnpXHoWoY+Ex4UO6mbtDATCu/uP6SfvxK33YsuEL+xjYKWCTWl3su5jgGj+Q9rkK06XdtDlyyNKKPMnY78TBsaJpSREa+Ii14Yfu31ikvb/Uuau3zHVpMkvTabbEFkJryPmFavA/QIDAQAB";
                    ;

                    break;
                case "dirid":
                    res="4044";//文件目录，需要文档系统提供
                    break;
                case "workcode":
                    res="htsys";
                    break;
                case "trackerServer":
                    res="172.43.23.60:22122";
                    break;
            }
        }
        return res;
    }

}
