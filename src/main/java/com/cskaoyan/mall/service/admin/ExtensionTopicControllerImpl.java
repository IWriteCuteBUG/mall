package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.bean.TopicExample;
import com.cskaoyan.mall.mapper.TopicMapper;
import com.cskaoyan.mall.service.ExtensionTopicService;
import com.cskaoyan.mall.vo.extensionvo.FromCoupon;
import com.cskaoyan.mall.vo.extensionvo.FromRequestKey;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtensionTopicControllerImpl implements ExtensionTopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public BaseRespVo queryCoupon(FromRequestKey fromRequestKey, String title, String subtitle) {
        PageHelper.startPage(fromRequestKey.getPage(), fromRequestKey.getLimit());
        TopicExample topicExample = new TopicExample();
        TopicExample.Criteria criteria = topicExample.createCriteria();
        if (title != null) {
            criteria = criteria.andTitleEqualTo(title);
        }

        if (subtitle != null) {
            criteria = criteria.andSubtitleLike("%" + subtitle + "%");
        }
        List<Topic> topics = topicMapper.selectByExample(topicExample);
        PageInfo<Topic> topicPageInfo = new PageInfo<>(topics);
        int total = (int) topicPageInfo.getTotal();
        return BaseRespVo.baseRespListOk(total,topics);
    }

    @Override
    public BaseRespVo topicCreate(Topic topic) {
        int i = topicMapper.insertSelective(topic);
        return BaseRespVo.baseRespOk(topic);
    }

    @Override
    public BaseRespVo topicUpdate(Topic topic) {
        int update = topicMapper.updateByPrimaryKey(topic);
        return BaseRespVo.baseRespOk(topic);
    }

    @Override
    public BaseRespVo topicDelete(Topic topic) {
        int i = topicMapper.deleteByPrimaryKey(topic.getId());
        return BaseRespVo.baseRespOk("");
    }
}
