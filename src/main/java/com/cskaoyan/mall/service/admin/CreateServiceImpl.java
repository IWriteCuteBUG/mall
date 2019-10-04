package com.cskaoyan.mall.service.admin;


import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.mapper.RoleMapper;
import com.cskaoyan.mall.vo.dhd.util.CreateBean;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class CreateServiceImpl implements  CreateService{
    @Autowired
    RoleMapper roleMapper;
    @Override
    public BaseRespVo createinfo(CreateBean createBean) {
        Date date = new Date();
        Role role = new Role();
        role.setDesc(createBean.getDesc());
        role.setName(createBean.getName());
        role.setEnabled(true);
        role.setDeleted(null);
        role.setAddTime(date);
        role.setUpdateTime(date);
        roleMapper.insert(role);
        BaseRespVo ok = BaseRespVo.ok(role);
        return ok;
    }
}
