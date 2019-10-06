package com.cskaoyan.mall.service.wechatservice.cly;

import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.vo.wechatvo.cly.ForTopicDetail;

import java.util.List;

public interface TopicService {
    ForTopicDetail queryTopicDetail(int id);

    List<Topic> queryTopicList(int page, int size);
}
