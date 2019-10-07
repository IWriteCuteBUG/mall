package com.cskaoyan.mall.vo.wechatvo.cly;

import com.cskaoyan.mall.bean.Topic;

import java.util.List;

public class ForTopicList {
    Long count;
    List<Topic> data;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<Topic> getData() {
        return data;
    }

    public void setData(List<Topic> data) {
        this.data = data;
    }
}
