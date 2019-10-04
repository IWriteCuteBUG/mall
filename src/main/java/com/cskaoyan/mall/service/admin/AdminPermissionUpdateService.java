package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.vo.dhd.util.PermissionsUpdateBean;
import org.springframework.beans.factory.annotation.Autowired;


public interface AdminPermissionUpdateService {
    BaseRespVo updateRolePermission(PermissionsUpdateBean permissionsUpdateBean);
}
