package com.cskaoyan.mall.service.adminservice.impl;

import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.exception.ExtensionCouponDiscountException;
import com.cskaoyan.mall.vo.adminvo.extensionvo.GrouponRulesNotKnow;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.math.BigDecimal;

public class GrouponRulesUtils {

    public static GrouponRules grouponRulesIstrue(GrouponRulesNotKnow grouponRulesNotKnow) throws ExtensionCouponDiscountException {
        GrouponRules grouponRules = new GrouponRules();
        try {
            String goodsId = grouponRulesNotKnow.getGoodsId();
            grouponRules.setGoodsId(Integer.valueOf(goodsId));
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("请小可爱输入正确格式的商品ID");
        }

        try {
            String discount = grouponRulesNotKnow.getDiscount();
            BigDecimal bigDecimal = new BigDecimal(discount);
            grouponRules.setDiscount(bigDecimal);
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("团购折扣参数输入有误");
        }

        try {
            String discountMember = grouponRulesNotKnow.getDiscountMember();
            grouponRules.setDiscountMember(Integer.valueOf(discountMember));
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("团购人数要求参数输入有误");
        }

        grouponRules.setId(grouponRulesNotKnow.getId());
        grouponRules.setGoodsName(grouponRulesNotKnow.getGoodsName());
        grouponRules.setPicUrl(grouponRulesNotKnow.getPicUrl());
        grouponRules.setAddTime(grouponRulesNotKnow.getAddTime());
        grouponRules.setUpdateTime(grouponRulesNotKnow.getUpdateTime());
        grouponRules.setExpireTime(grouponRulesNotKnow.getExpireTime());
        grouponRules.setDeleted(grouponRulesNotKnow.getDeleted());
        return grouponRules;
    }
}
