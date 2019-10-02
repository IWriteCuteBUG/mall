package com.cskaoyan.mall.service.serviceSJB;

import com.cskaoyan.mall.vo.voSJB.FeedbackListAndTotalVo;

public interface FeedbackService {
    FeedbackListAndTotalVo queryFeedbacksByPage(int page, int limit, String username, String sort, String order, String id);

    int queryTotalNum();
}
