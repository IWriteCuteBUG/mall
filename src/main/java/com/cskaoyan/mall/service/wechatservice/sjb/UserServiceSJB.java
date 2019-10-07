package com.cskaoyan.mall.service.wechatservice.sjb;

import com.cskaoyan.mall.bean.User;

public interface UserServiceSJB {
    String getUsernameByUserId(int userId);

    User getUserById(Integer userId);
}
