package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.InfoVo;
import com.cskaoyan.mall.vo.voSJB.DashBoardDataVo;
import com.cskaoyan.mall.vo.voSJB.DashBoardVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AutoController {
    @RequestMapping("admin/auth/login")
    public BaseRespVo login() {
        BaseRespVo ok = BaseRespVo.ok("400dbdb5-f736-4895-8341-d16bd9ed4fcf");
        return ok;
    }

    @RequestMapping("admin/auth/info")
    public BaseRespVo info(String token) {
        InfoVo infoVo = new InfoVo();
        infoVo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        infoVo.setName("admin123");
        ArrayList<String> Perms = new ArrayList<>();
        Perms.add("*");
        infoVo.setPerms(Perms);
        ArrayList<String> roles = new ArrayList<>();
        roles.add("超级管理员");
        infoVo.setRoles(roles);
        BaseRespVo info = BaseRespVo.info(infoVo);
        return info;
    }

    @RequestMapping("admin/dashboard")
    public DashBoardVo dashboard() {
        DashBoardVo dashBoardVo = new DashBoardVo();
        DashBoardDataVo dashBoardDataVo = new DashBoardDataVo();
        dashBoardDataVo.setOrderTotal(100);
        dashBoardDataVo.setProductTotal(200);
        dashBoardDataVo.setUserTotal(300);
        dashBoardVo.setDataVo(dashBoardDataVo);
        dashBoardVo.setErrno(0);
        dashBoardVo.setErrmsg("no error");
        return dashBoardVo;
    }
}
