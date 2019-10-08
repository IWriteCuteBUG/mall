package com.cskaoyan.mall.service.adminservice.impl;

import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.exception.ExtensionCouponDiscountException;
import com.cskaoyan.mall.vo.adminvo.extensionvo.GrouponRulesNotKnow;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.math.BigDecimal;
import java.util.Date;

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
        int i = grouponRules.getDiscount().compareTo(BigDecimal.ZERO);
        if (i == -1 || i == 0) {
            throw new ExtensionCouponDiscountException("团购折扣必须大于0");
        }
        try {
            String discountMember = grouponRulesNotKnow.getDiscountMember();
            grouponRules.setDiscountMember(Integer.valueOf(discountMember));
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("团购人数要求参数输入有误");
        }
        if (grouponRules.getDiscountMember() <= 1) {
            throw new ExtensionCouponDiscountException("团购人数最少2人");
        }
        Date date = new Date();
        if (date.after(grouponRulesNotKnow.getExpireTime())) {
            throw new ExtensionCouponDiscountException("团购过期时间必须在当前时间之后");
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
