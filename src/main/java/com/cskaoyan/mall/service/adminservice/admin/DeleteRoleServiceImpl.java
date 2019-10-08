package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.AdminExample;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.mapper.AdminMapper;
import com.cskaoyan.mall.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DeleteRoleServiceImpl implements DeleteRoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Object deleteRole(Role role) {
        BaseRespVo ok = new BaseRespVo<>();
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andIdIsNotNull();
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        for (Admin admin : admins) {
            Integer[] roleIds = admin.getRoleIds();
            for (Integer roleId : roleIds) {
               if (roleId.equals(role.getId())){
                   HashMap<String, Object> objectObjectHashMap = new HashMap<>();
                   objectObjectHashMap.put("errmsg","当前角色存在管理员，不能删除");
                   objectObjectHashMap.put("errno",642);
                   return objectObjectHashMap;
               }
            }
        }

        int i = roleMapper.deleteByPrimaryKey(role.getId());
        ok = BaseRespVo.ok(null);

        return ok;
    }
}
