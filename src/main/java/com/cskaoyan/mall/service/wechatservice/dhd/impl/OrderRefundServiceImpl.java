package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.OrderMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class OrderRefundServiceImpl implements OrderRefundService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public Object changeIdStatus(int orderId) {
        orderMapper.updateOrderStatus2Refound(orderId);
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrmsg("成功");
        objectBaseRespVo.setData("success");
        objectBaseRespVo.setErrno(0);
        return objectBaseRespVo;
    }
}
