package com.cskaoyan.mall.service.adminservice.serviceSJB;

import com.cskaoyan.mall.vo.adminvo.voSJB.AddressListAndTotalVo;

public interface AddressService {
    AddressListAndTotalVo queryAddressesByPage(int page, int limit, String name, String userId, String sort, String order);
    int queryTotalNum();
}
