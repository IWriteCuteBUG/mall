package com.cskaoyan.mall.vo.wechatvo.cly;

import com.cskaoyan.mall.bean.OrderGoods;

import java.util.List;


public class ForOrderDetail {
    List<OrderGoods> orderGoods;
    WxClyOrderInfo orderInfo;

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public WxClyOrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(WxClyOrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }
}
