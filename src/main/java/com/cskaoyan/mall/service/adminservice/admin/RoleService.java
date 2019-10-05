package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.bean.BaseRespVo;

public interface RoleService {
    BaseRespVo rolListInfo(int page, int limit, String name);
}
