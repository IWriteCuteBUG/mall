package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.vo.extensionvo.FromRequestKey;

public interface ExtensionGrouponService {

    BaseRespVo queryGrouponListByGoodsId(FromRequestKey fromRequestKey, Integer goodsId);

    BaseRespVo queryGrouponCreate(GrouponRules grouponRules);

    BaseRespVo queryGrouponDelete(GrouponRules grouponRules);

    BaseRespVo queryGrouponUpdate(GrouponRules grouponRules);
}
