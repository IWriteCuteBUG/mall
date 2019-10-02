package com.cskaoyan.mall.service.serviceSJB;

import com.cskaoyan.mall.vo.voSJB.CollectListAndTotalVo;

public interface CollectService {
    CollectListAndTotalVo queryCollectsByPage(int page, int limit, String userId, String valueId, String sort, String order);

    int queryTotalNum();
}
