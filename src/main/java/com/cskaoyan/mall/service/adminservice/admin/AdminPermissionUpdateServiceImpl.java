package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.PermissionMapper;
import com.cskaoyan.mall.vo.adminvo.dhd.util.PermissionsUpdateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AdminPermissionUpdateServiceImpl implements  AdminPermissionUpdateService {
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public Object updateRolePermission(PermissionsUpdateBean permissionsUpdateBean) {
        if (permissionsUpdateBean.getRoleId()==1){
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("errmsg","当前角色超级权限不能变更");
            stringStringHashMap.put("errno","641");
            return stringStringHashMap;
        }
        permissionMapper.deletePermission(permissionsUpdateBean.getRoleId());
        String[] permissions = permissionsUpdateBean.getPermissions();
        for (String permission : permissions) {
            permissionMapper.insertPermission(permissionsUpdateBean.getRoleId(),permission);
        }
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }
}
