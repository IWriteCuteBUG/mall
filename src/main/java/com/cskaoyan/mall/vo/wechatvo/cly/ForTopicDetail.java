package com.cskaoyan.mall.vo.wechatvo.cly;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.Topic;

import java.util.List;

public class ForTopicDetail {
    private List<Goods> goods;
    private Topic topic;

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
