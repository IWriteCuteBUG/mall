package com.cskaoyan.mall.controller.controllerSJB;

import com.cskaoyan.mall.service.serviceSJB.FeedbackService;
import com.cskaoyan.mall.vo.voSJB.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    @RequestMapping("list")
    public FeedbackListVo list(int page, int limit, String username, String sort, String order, String id){
        FeedbackListAndTotalVo vo = feedbackService.queryFeedbacksByPage(page, limit, username, sort, order, id);
        return new FeedbackListVo(0, new DataForFeedbackListVo(vo.getTotal(), vo.getFeedbackList()), "no error");
    }
}
