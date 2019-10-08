package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderIdDeleteServiceImpl implements  OrderIdDeleteService{
    @Autowired
    OrderMapper orderMapper;
    @Override
    public BaseRespVo deleteOrder(Integer orderId) {
        orderMapper.deleteByPrimaryKey(orderId);
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData("success");
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }
}
