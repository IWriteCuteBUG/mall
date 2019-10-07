package com.cskaoyan.mall.utils.wechatutils.ljw;

import java.util.HashMap;

public class OrdStaUtils {

    private short order_status;
    private String strSatus;
    static HashMap intStatus = new HashMap();
    static HashMap strMap = new HashMap();

    static {

        intStatus.put(1, 101);
        intStatus.put(2, 201);
        intStatus.put(3, 301);
        intStatus.put(4, 401);


        strMap.put(101, "未付款");
        strMap.put(201, "待发货");
        strMap.put(301, "待收货");
        strMap.put(401, "已收货");

    }

    public static short getOrder_status(int showType) {

        return (short) intStatus.get(showType);
    }

    public static String getStrSatus(int order_status) {
        return (String) strMap.get(order_status);
    }
}
