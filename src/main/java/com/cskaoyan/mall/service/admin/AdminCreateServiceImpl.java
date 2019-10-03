package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.AdminExample;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminCreateServiceImpl implements  AdminCreateService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public BaseRespVo createAdmin(Admin admin) {
        Date date = new Date();
        admin.setAddTime(date);
        admin.setUpdateTime(date);
        adminMapper.insert(admin);
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(admin.getUsername());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        BaseRespVo ok = BaseRespVo.ok(admins.get(0));
        return ok;
    }
}
