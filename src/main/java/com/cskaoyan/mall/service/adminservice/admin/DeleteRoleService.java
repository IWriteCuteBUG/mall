package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Role;

public interface DeleteRoleService {
    BaseRespVo deleteRole(Role role);
}