package com.cskaoyan.mall.service.wechatservice.cly;

import com.cskaoyan.mall.vo.wechatvo.cly.ForTopicDetail;
import com.cskaoyan.mall.vo.wechatvo.cly.ForTopicList;

public interface TopicService {
    ForTopicDetail queryTopicDetail(int id);

    ForTopicList queryTopicList(int page, int size);
}
