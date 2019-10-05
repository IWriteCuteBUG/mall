package com.cskaoyan.mall.service.adminservice;

import com.cskaoyan.mall.vo.adminvo.tvo.GrouponsVo;

public interface GrouponsService {
    GrouponsVo getGrouponActive(int page, int limit, String sort, String order, int goodsId);
}
