package com.cskaoyan.mall.service.wechatservice.zyp;

import com.cskaoyan.mall.bean.Order;

import java.util.List;

public interface WxAuthService {

    Integer queryIdByUsername(String username);

    List<Order>queryOrdersByUserIdAndOrderStatus(Integer userId , Integer status);
}
