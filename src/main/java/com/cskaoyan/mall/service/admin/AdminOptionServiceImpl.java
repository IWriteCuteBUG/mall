package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.Vo.dhd.util.Options;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.bean.RoleExample;
import com.cskaoyan.mall.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminOptionServiceImpl implements AdminOptionService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public BaseRespVo selectLableList() {
        RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andIdIsNotNull();
        List<Role> roles = roleMapper.selectByExample(roleExample);
        List<Options> options = new ArrayList<>();

        for (Role role : roles) {
            Options options1 = new Options();
            String name = role.getName();
            options1.setValue(role.getId());
            options1.setLabel(name);
            options.add(options1);

        }
        BaseRespVo ok = BaseRespVo.ok(options);
        return ok;
    }
}
