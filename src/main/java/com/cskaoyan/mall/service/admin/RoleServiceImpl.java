package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.Vo.dhd.AllVo;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Role;
import com.cskaoyan.mall.bean.RoleExample;

import com.cskaoyan.mall.mapper.RoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public BaseRespVo rolListInfo(int page, int limit, String name) {
        AllVo AllVo = new AllVo();
        PageHelper.startPage(page,limit);
        RoleExample roleExample = new RoleExample();
        if (name!=null){
            roleExample.createCriteria().andNameIsNotNull().andNameLike(name+"%");
        }
        else{
            roleExample.createCriteria().andNameIsNotNull();
        }
        List<Role> roles = roleMapper.selectByExample(roleExample);
        AllVo.setItems(roles);
        PageInfo<Role> logPageInfo = new PageInfo<>(roles);
        long total = logPageInfo.getTotal();
        AllVo.setTotal((int)total);
        BaseRespVo ok = BaseRespVo.ok(AllVo);
        return ok;
    }
}
