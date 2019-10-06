package com.cskaoyan.mall.service.wechatservice.cly.impl;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.mapper.TopicMapper;
import com.cskaoyan.mall.service.wechatservice.cly.TopicService;
import com.cskaoyan.mall.vo.wechatvo.cly.ForTopicDetail;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;

    @Override
    public ForTopicDetail queryTopicDetail(int id) {
        Topic topic = topicMapper.queryTopicDetail(id);
        //List<Goods> goods = topic.getGoods();
        ForTopicDetail forTopicDetail = new ForTopicDetail();
        forTopicDetail.setTopic(topic);
        forTopicDetail.setGoods(null);
        return forTopicDetail;
    }

    @Override
    public List<Topic> queryTopicList(int page, int size) {
        PageHelper.startPage(page, size);
        List<Topic> topics = topicMapper.queryTopicList();
        return topics;
    }
}
