package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderPrepayServiceImpl implements OrderPrepayService{
    @Autowired
    OrderMapper  orderMapper;
    @Override
    public HashMap<String, Object> changeOrder_Status(Integer orderId) {
        orderMapper.updateOrderStatus(orderId);
        HashMap<String, Object> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("errmsg","支付成功");
        stringStringHashMap.put("errno",0);
        return stringStringHashMap;

    }
}
