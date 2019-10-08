package com.cskaoyan.mall.service.adminservice;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.exception.ExtensionCouponDiscountException;
import com.cskaoyan.mall.vo.adminvo.extensionvo.FromRequestKey;
import com.cskaoyan.mall.vo.adminvo.extensionvo.GrouponRulesNotKnow;

public interface ExtensionGrouponService {

    BaseRespVo queryGrouponListByGoodsId(FromRequestKey fromRequestKey);

    BaseRespVo queryGrouponCreate(GrouponRulesNotKnow grouponRulesNotKnow) throws ExtensionCouponDiscountException;

    BaseRespVo queryGrouponDelete(GrouponRules grouponRules);

    BaseRespVo queryGrouponUpdate(GrouponRulesNotKnow grouponRulesNotKnow) throws ExtensionCouponDiscountException;
}
