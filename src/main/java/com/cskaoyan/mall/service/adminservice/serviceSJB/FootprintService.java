package com.cskaoyan.mall.service.adminservice.serviceSJB;

import com.cskaoyan.mall.vo.adminvo.voSJB.FootprintListAndTotalVo;

public interface FootprintService {
    FootprintListAndTotalVo queryFootprintsByPage(int page, int limit, String userId, String goodsId, String sort, String order);

    int queryTotalNum();
}
