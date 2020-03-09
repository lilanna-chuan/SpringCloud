package xyz.quellanan.views.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName IpBean
 * @Description IpBean
 * @Author zhulinfeng
 * @Date 2019/7/9 14:01
 * @Version 1.0
 */
@Setter
@Getter
public class IpBean {
    private String ip;
    private int port;
    private String type;

    public IpBean(IpBean bean){
        ip = bean.getIp();
        port = bean.getPort();
        type = bean.getType();
    }

    public IpBean(String ip, int port, String type) {
        this.ip = ip;
        this.port = port;
        this.type = type;
    }

}
