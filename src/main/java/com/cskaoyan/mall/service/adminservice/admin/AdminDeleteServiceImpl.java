package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDeleteServiceImpl implements AdminDeleteService {
     @Autowired
    AdminMapper adminMapper;
    @Override
    public BaseRespVo deleteAdmin(Admin admin) {
        adminMapper.deleteByPrimaryKey(admin.getId());
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }
}
