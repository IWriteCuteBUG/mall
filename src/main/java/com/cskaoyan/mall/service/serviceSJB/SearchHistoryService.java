package com.cskaoyan.mall.service.serviceSJB;

import com.cskaoyan.mall.vo.voSJB.SearchHistoryListAndTotalVo;

public interface SearchHistoryService {
    SearchHistoryListAndTotalVo querySearchHistorysByPage(int page, int limit, String userId, String keyword, String sort, String order);

    int queryTotalNum();
}
