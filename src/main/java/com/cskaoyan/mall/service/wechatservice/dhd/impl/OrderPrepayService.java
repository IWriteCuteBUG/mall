package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;

import java.util.HashMap;

public interface OrderPrepayService {
    BaseRespVo changeOrder_Status(String orderId);
}
