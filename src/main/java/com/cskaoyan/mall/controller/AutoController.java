package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.InfoVo;
import com.cskaoyan.mall.service.ConfigerService;
import com.cskaoyan.mall.vo.tvo.ConfigerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class AutoController {


    @Autowired
    ConfigerService configerService;

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
    @RequestMapping(value = "/admin/config/mall", method = {RequestMethod.GET})
    public BaseRespVo queryMallConfig(){
        ConfigerVo configerVo = configerService.queryMallConfig();
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData(configerVo);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }


    @RequestMapping(value = "admin/config/mall", method = {RequestMethod.POST})
    public BaseRespVo updateMallConfig(@RequestBody ConfigerVo configerVo){
        boolean flag = configerService.updateMallConfig(configerVo);
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setData(null);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }
}
