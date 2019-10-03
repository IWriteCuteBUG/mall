package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.bean.RoleExample;
import com.cskaoyan.mall.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateServiceImpl implements  UpdateService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public BaseRespVo UpdateInfo(Role role) {

        int i = roleMapper.updateByPrimaryKey(role);
        BaseRespVo ok = BaseRespVo.ok(null);
        return  ok;
    }
}
