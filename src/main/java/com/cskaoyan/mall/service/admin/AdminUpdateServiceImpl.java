package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUpdateServiceImpl implements  AdminUpdateService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public BaseRespVo updateAdmin(Admin admin) {
         adminMapper.updateByPrimaryKey(admin);
        BaseRespVo ok = BaseRespVo.ok(admin);
        return ok;
    }
}
