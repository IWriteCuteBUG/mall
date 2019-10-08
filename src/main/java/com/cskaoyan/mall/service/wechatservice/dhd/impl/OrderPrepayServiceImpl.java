package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderPrepayServiceImpl implements OrderPrepayService{
    @Autowired
    OrderMapper  orderMapper;
    @Override
    public BaseRespVo changeOrder_Status(String orderId) {
        //Integer integer = Integer.valueOf(orderId);
        orderMapper.updateOrderStatus(orderId);
        /*HashMap<String, Object> map = new HashMap<>();
        map.put("")*/
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData("success");
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;

    }
}
