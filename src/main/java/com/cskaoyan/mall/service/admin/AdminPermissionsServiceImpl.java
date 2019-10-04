package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.AdminMapper;
import com.cskaoyan.mall.mapper.PermissionMapper;
import com.cskaoyan.mall.vo.dhd.PermissionsVo;
import com.cskaoyan.mall.vo.dhd.util.ApiBean;
import com.cskaoyan.mall.vo.dhd.util.SystemPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminPermissionsServiceImpl implements AdminPermissionsService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public BaseRespVo permissionList(int roleId) {
        String[] strings = permissionMapper.selectPermissionByRoleId(roleId);
        List<SystemPermission> systemPermissions = permissionMapper.selectAdminPermission_detailsParent();
        for (SystemPermission systemPermission : systemPermissions) {
            List<SystemPermission> systemPermissions1 = permissionMapper.selectAdminPermission_details(systemPermission.getPid());
            systemPermission.setChildren(systemPermissions1);
            for (SystemPermission permission : systemPermissions1) {
                List<SystemPermission> systemPermissions2 = permissionMapper.selectAdminPermission_details(permission.getPid());
                permission.setChildren(systemPermissions2);
            }
        }
        PermissionsVo permissionsVo = new PermissionsVo();
        permissionsVo.setAssignedPermissions(strings);
        permissionsVo.setSystemPermissions(systemPermissions);
        BaseRespVo ok = BaseRespVo.ok(permissionsVo);
        return  ok;
    }
}
