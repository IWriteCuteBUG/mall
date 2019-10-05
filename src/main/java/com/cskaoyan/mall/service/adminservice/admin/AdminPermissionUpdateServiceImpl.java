package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.PermissionMapper;
import com.cskaoyan.mall.vo.adminvo.dhd.util.PermissionsUpdateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPermissionUpdateServiceImpl implements  AdminPermissionUpdateService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public BaseRespVo updateRolePermission(PermissionsUpdateBean permissionsUpdateBean) {
        permissionMapper.deletePermission(permissionsUpdateBean.getRoleId());
        String[] permissions = permissionsUpdateBean.getPermissions();
        for (String permission : permissions) {
            permissionMapper.insertPermission(permissionsUpdateBean.getRoleId(),permission);
        }
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }
}
