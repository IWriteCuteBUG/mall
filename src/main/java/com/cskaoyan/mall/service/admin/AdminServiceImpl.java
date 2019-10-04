package com.cskaoyan.mall.service.admin;

import com.cskaoyan.mall.Vo.dhd.AdminVo;
import com.cskaoyan.mall.Vo.dhd.AllVo;
import com.cskaoyan.mall.bean.Admin;
import com.cskaoyan.mall.bean.AdminExample;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.AdminMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    AdminMapper adminMapper;
    @Override
    public BaseRespVo adminListInfo(int page, int limit,String username) {

        AllVo objectAllVo = new AllVo<>();

        String orderby=" add_time desc";
        PageHelper.startPage(page,limit,orderby);
        List<Admin> admins = adminMapper.selectAdminListByUser(username);
        PageInfo<Admin> adminPageInfo = new PageInfo<>(admins);
        long total = adminPageInfo.getTotal();
        objectAllVo.setItems(admins);
        objectAllVo.setTotal((int)total);
        BaseRespVo ok = BaseRespVo.ok(objectAllVo);
        return ok;
    }
}
