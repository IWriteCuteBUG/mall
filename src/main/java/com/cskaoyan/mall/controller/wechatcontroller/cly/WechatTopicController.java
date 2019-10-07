package com.cskaoyan.mall.controller.wechatcontroller.cly;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Topic;
import com.cskaoyan.mall.service.wechatservice.cly.TopicService;
import com.cskaoyan.mall.utils.wechatutils.cly.ReturnUtilCly;
import com.cskaoyan.mall.vo.wechatvo.cly.ForTopicDetail;
import com.cskaoyan.mall.vo.wechatvo.cly.ForTopicList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx/topic")
public class WechatTopicController {
    @Autowired
    TopicService topicService;

    @RequestMapping("detail")
    public BaseRespVo queryTopicDetail(int id){
        ForTopicDetail forTopicDetail = topicService.queryTopicDetail(id);
        return ReturnUtilCly.back(forTopicDetail, "成功", 0);
    }

   /* @RequestMapping("related")*/

    @RequestMapping("list")
    public BaseRespVo queryTopicList(int page, int size){
        ForTopicList forTopicList = topicService.queryTopicList(page, size);
        return ReturnUtilCly.back(forTopicList, "成功", 0);
    }
}
