package com.cskaoyan.mall.service.adminservice;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.exception.ExtensionCouponDiscountException;
import com.cskaoyan.mall.vo.adminvo.extensionvo.FromRequestKey;
import com.cskaoyan.mall.vo.adminvo.extensionvo.TopicNotKnow;

public interface ExtensionTopicService {
    BaseRespVo queryCoupon(FromRequestKey fromRequestKey, String title, String subtitle);

    BaseRespVo topicCreate(TopicNotKnow topicNotKnow) throws ExtensionCouponDiscountException;

    BaseRespVo topicUpdate(TopicNotKnow topicNotKnow) throws ExtensionCouponDiscountException;

    BaseRespVo topicDelete(Topic topic);
}
