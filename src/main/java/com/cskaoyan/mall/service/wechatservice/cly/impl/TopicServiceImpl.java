package com.cskaoyan.mall.service.wechatservice.cly.impl;

import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.mapper.TopicMapper;
import com.cskaoyan.mall.service.wechatservice.cly.TopicService;
import com.cskaoyan.mall.vo.wechatvo.cly.ForTopicDetail;
import com.cskaoyan.mall.vo.wechatvo.cly.ForTopicList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public ForTopicList queryTopicList(int page, int size) {
        PageHelper.startPage(page, size);
        List<Topic> topics = topicMapper.queryTopicList();
        PageInfo<Topic> topicPageInfo = new PageInfo<>(topics);
        long total = topicPageInfo.getTotal();
        ForTopicList forTopicList = new ForTopicList();
        forTopicList.setData(topics);
        forTopicList.setCount(total);
        return forTopicList;
    }
}
