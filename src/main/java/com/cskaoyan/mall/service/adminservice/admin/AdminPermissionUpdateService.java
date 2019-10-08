package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.vo.adminvo.dhd.util.PermissionsUpdateBean;


public interface AdminPermissionUpdateService {
    Object updateRolePermission(PermissionsUpdateBean permissionsUpdateBean);
}
