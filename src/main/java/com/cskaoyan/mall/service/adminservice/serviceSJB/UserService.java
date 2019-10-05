package com.cskaoyan.mall.service.adminservice.serviceSJB;

import com.cskaoyan.mall.vo.adminvo.voSJB.UserListAndTotalVo;


public interface UserService {
    UserListAndTotalVo queryUsersByPage(int page, int limit, String username, String mobile, String sort, String order);

    int queryTotalNum();
}
