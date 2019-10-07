package com.cskaoyan.mall.service.wechatservice.sjb.impl;

import com.cskaoyan.mall.bean.Feedback;
import com.cskaoyan.mall.mapper.FeedbackMapper;
import com.cskaoyan.mall.service.wechatservice.sjb.FeedbackServiceSJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceSJBImpl implements FeedbackServiceSJB {
    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public int insertFeedback(Feedback feedback) {

        return feedbackMapper.insertFeedbackWithoutId(feedback);
    }
}
