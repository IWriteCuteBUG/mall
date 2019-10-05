package com.cskaoyan.mall.service.adminservice.serviceSJB;

import com.cskaoyan.mall.vo.adminvo.voSJB.FeedbackListAndTotalVo;

public interface FeedbackService {
    FeedbackListAndTotalVo queryFeedbacksByPage(int page, int limit, String username, String sort, String order, String id);

    int queryTotalNum();
}
