package com.cskaoyan.mall.service;

import com.cskaoyan.mall.vo.tvo.GrouponsVo;

public interface GrouponsService {
    GrouponsVo getGrouponActive(String sort, String order);
}
