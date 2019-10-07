package com.cskaoyan.mall.service.wechatservice.tangsong;

import com.cskaoyan.mall.bean.BaseRespVo;

public interface WeChatOrdersService {
    BaseRespVo queryOrdersList(int showType,int page,int size);
}
