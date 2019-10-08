package com.cskaoyan.mall.utils.wechatutils.zyp;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.vo.wechatvo.zyp.HandleOption;

public class HandleOptionUtils {

    public static HandleOption getHandleOption(Groupon groupon) {
        HandleOption handleOption = new HandleOption();

//        订单是否完成
        handleOption.setCancel(false);
//
        handleOption.setDelete(groupon.getDeleted());
        handleOption.setPay(groupon.getPayed());
        handleOption.setComment(false);
        handleOption.setConfirm(false);
        handleOption.setRefund(false);
        handleOption.setRebuy(false);
        return handleOption;
    }

    public static HandleOption getHandleOption(Order order) {
        HandleOption handleOption = new HandleOption();

//        订单是否完成
        handleOption.setCancel(false);
//
        handleOption.setDelete(order.getDeleted());
        if(order.getPayTime() == null){
            handleOption.setPay(false);
        } else if (order.getPayTime() != null) {
            handleOption.setPay(true);
        }
        handleOption.setComment(false);
        handleOption.setConfirm(false);
        handleOption.setRefund(false);
        handleOption.setRebuy(false);
        return handleOption;
    }
}
