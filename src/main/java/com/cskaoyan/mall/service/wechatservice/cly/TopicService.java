package com.cskaoyan.mall.service.wechatservice.cly;

import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.vo.wechatvo.cly.ForTopicDetail;
import com.cskaoyan.mall.vo.wechatvo.cly.ForTopicList;

import java.util.List;

public interface TopicService {
    ForTopicDetail queryTopicDetail(int id);

    ForTopicList queryTopicList(int page, int size);

    List<Topic> queryRelatedTopics(int id);
}
