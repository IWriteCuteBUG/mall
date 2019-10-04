package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.BaseRespVo;

public interface RoleService {
    BaseRespVo rolListInfo(int page, int limit, String name);
}
