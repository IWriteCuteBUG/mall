package com.cskaoyan.mall.service.wechatservice.cly;

import com.cskaoyan.mall.vo.wechatvo.cly.ForOrderDetail;

public interface ClyOrderService {
    ForOrderDetail queryOrderDetail(int orderId);

    void cancelOrder(int orderId);
}
