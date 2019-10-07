package com.cskaoyan.mall.utils.wechatutils.tangsong;

import java.util.HashMap;
import java.util.Map;

public class OrdersStatusUtils {
    public HashMap map;


    public OrdersStatusUtils(){
        map = new HashMap<Integer,String>();
        map.put(301,"已发货");
        map.put(203,"已退款");
        map.put(402,"系统收货");
        map.put(102,"用户取消");
        map.put(101,"未付款");
        map.put(202,"申请退款");
        map.put(401,"用户收货");
        map.put(103,"系统取消");
        map.put(201,"已付款");
    }
    public Map getStatusMap(){
        return this.map;
    }
}
