package com.cskaoyan.mall.service;

import com.cskaoyan.mall.vo.tvo.GrouponsVo;

public interface GrouponsService {
    GrouponsVo getGrouponActive(int page, int limit, String sort, String order);
}
