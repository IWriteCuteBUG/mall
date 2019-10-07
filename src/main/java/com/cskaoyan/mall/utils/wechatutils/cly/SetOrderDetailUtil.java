package com.cskaoyan.mall.utils.wechatutils.cly;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.vo.wechatvo.cly.WxClyHandleOption;
import com.cskaoyan.mall.vo.wechatvo.cly.WxClyOrderInfo;

public class SetOrderDetailUtil {

    public static void setOrderInfo(Order order, WxClyOrderInfo orderInfo, WxClyHandleOption handleOption) {
        Short orderStatus = order.getOrderStatus();
        switch (orderStatus){
            case 101:
                orderInfo.setOrderStatusText("未付款");
                handleOption.setCancel(true);
                handleOption.setPay(true);
                break;
            case 102:
                orderInfo.setOrderStatusText("用户取消");
                break;
            case 103:
                orderInfo.setOrderStatusText("系统取消");
                break;
            case 201:
                orderInfo.setOrderStatusText("已付款");
                handleOption.setRefund(true);
                break;
            case 202:
                orderInfo.setOrderStatusText("申请退款");
                break;
            case 203:
                orderInfo.setOrderStatusText("已退款");
                handleOption.setDelete(true);
                break;
            case 301:
                orderInfo.setOrderStatusText("已发货");
                handleOption.setConfirm(true);
                handleOption.setRefund(true);
                break;
            case 401:
                orderInfo.setOrderStatusText("用户收货");
                handleOption.setComment(true);
                handleOption.setDelete(true);
                handleOption.setRebuy(true);
                handleOption.setRefund(true);
                break;
            case 402:
                orderInfo.setOrderStatusText("系统收货");
                break;
            default:
                break;
        }
        orderInfo.setActualPrice(order.getActualPrice());
        orderInfo.setAddress(order.getAddress());
        orderInfo.setAddTime(order.getAddTime());
        orderInfo.setConsignee(order.getConsignee());
        orderInfo.setCouponPrice(order.getCouponPrice());
        orderInfo.setFreightPrice(order.getFreightPrice());
        orderInfo.setMobile(order.getMobile());
        orderInfo.setGoodsPrice(order.getGoodsPrice());
        orderInfo.setId(order.getId());
        orderInfo.setOrderSn(order.getOrderSn());
    }
}
