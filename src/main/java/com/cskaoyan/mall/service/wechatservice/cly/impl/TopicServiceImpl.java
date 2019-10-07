package com.cskaoyan.mall.service.wechatservice.cly.impl;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.bean.TopicExample;
import com.cskaoyan.mall.mapper.TopicMapper;
import com.cskaoyan.mall.service.wechatservice.cly.TopicService;
import com.cskaoyan.mall.utils.wechatutils.cly.String2BeanListUtil;
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
        String[] goods = topic.getGoods();
        List<Goods> goodsList = String2BeanListUtil.getBeanList(goods, new Goods());
        ForTopicDetail forTopicDetail = new ForTopicDetail();
        forTopicDetail.setTopic(topic);
        forTopicDetail.setGoods(goodsList);
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

    @Override
    public List<Topic> queryRelatedTopics(int id) {
        List<Topic> topics = topicMapper.selectRelatedTopics(id);
        return topics;
    }
}
