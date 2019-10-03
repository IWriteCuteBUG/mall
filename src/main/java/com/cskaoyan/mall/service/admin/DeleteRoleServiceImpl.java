package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteRoleServiceImpl implements DeleteRoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public BaseRespVo deleteRole(Role role) {
        BaseRespVo ok = new BaseRespVo<>();
        if (false){}
            else{int i = roleMapper.deleteByPrimaryKey(role.getId());
            ok = BaseRespVo.ok(null);
        }
        return ok;
    }
}
