package xyz.quellanan.views.pool;

import xyz.quellanan.views.bean.IpBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IpPool
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/7/12 19:14
 * @Version 1.0
 */
public class IpPool {

    public static List<IpBean> ipBeanList = new ArrayList<>();

    /**
     * 支持并发操作
     *
     * @param bean
     */
    public static synchronized void add(IpBean bean) {
        if(ipBeanList.size()>1000){
            return;
        }
        ipBeanList.add(bean);
    }

    public static synchronized void remove(IpBean bean) {
        ipBeanList.remove(bean);
    }
}
