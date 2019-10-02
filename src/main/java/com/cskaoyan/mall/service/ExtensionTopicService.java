package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.vo.extensionvo.FromCoupon;
import com.cskaoyan.mall.vo.extensionvo.FromRequestKey;

public interface ExtensionTopicService {
    BaseRespVo queryCoupon(FromRequestKey fromRequestKey, String title, String subtitle);

    BaseRespVo topicCreate(Topic topic);

    BaseRespVo topicUpdate(Topic topic);

    BaseRespVo topicDelete(Topic topic);
}
