package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Role;

public interface UpdateService {
    BaseRespVo UpdateInfo(Role role);
}
