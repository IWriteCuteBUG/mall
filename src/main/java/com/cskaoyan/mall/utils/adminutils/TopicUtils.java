package com.cskaoyan.mall.utils.adminutils;

import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.exception.ExtensionCouponDiscountException;
import com.cskaoyan.mall.vo.adminvo.extensionvo.TopicNotKnow;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.math.BigDecimal;

public class TopicUtils {

    public static Topic topic(TopicNotKnow topicNotKnow) throws ExtensionCouponDiscountException {

        Topic topic = new Topic();
        try {
            String price = topicNotKnow.getPrice();
            BigDecimal bigDecimal = new BigDecimal(price);
            topic.setPrice(bigDecimal);
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("商品低价参数输入有误");
        }
        int i = topic.getPrice().compareTo(BigDecimal.ZERO);
        if (i == -1) {
            throw new ExtensionCouponDiscountException("商品低价必须大于等于0");
        }
        BigDecimal bigDecimal = null;
        try {
            String readCount = topicNotKnow.getReadCount();
            bigDecimal = new BigDecimal(readCount);
        } catch (Exception e) {
            throw new ExtensionCouponDiscountException("阅读量参数输入有误");
        }
        int i1 = bigDecimal.compareTo(BigDecimal.ZERO);
        if (i1 == -1) {
            throw new ExtensionCouponDiscountException("阅读量必须大于等于0");
        }
        topic.setSortOrder(topic.getSortOrder());
        topic.setId(topicNotKnow.getId());
        topic.setTitle(topicNotKnow.getTitle());
        topic.setSubtitle(topicNotKnow.getSubtitle());
        topic.setReadCount(topicNotKnow.getReadCount());
        topic.setPicUrl(topicNotKnow.getPicUrl());
        topic.setGoods(topicNotKnow.getGoods());
        topic.setAddTime(topic.getAddTime());
        topic.setUpdateTime(topicNotKnow.getUpdateTime());
        topic.setDeleted(topicNotKnow.getDeleted());
        topic.setContent(topicNotKnow.getContent());
        return topic;
    }
}
