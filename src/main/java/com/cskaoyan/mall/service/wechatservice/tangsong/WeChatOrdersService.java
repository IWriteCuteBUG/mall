package com.cskaoyan.mall.service.wechatservice.tangsong;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.SubmitOrders;

public interface WeChatOrdersService {
    BaseRespVo queryOrdersList(int showType,int page,int size);

    BaseRespVo submitOrder(SubmitOrders submitOrders);
}
