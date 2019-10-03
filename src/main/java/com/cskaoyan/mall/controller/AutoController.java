package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.AdminService;
import com.cskaoyan.mall.vo.tvo.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping("admin")
public class AutoController {

    @Autowired
    AdminService adminService;

    @RequestMapping("auth/login")
    public BaseRespVo login(@RequestBody LoginVo loginVo) {
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);
        Serializable id = subject.getSession().getId();
        return BaseRespVo.ok(id);
    }

    @RequestMapping("auth/info")
    public BaseRespVo info(String token) {
        BaseRespVo baseRespVo = adminService.queryInfo(token);
        return baseRespVo;
    }
    @RequestMapping("auth/logout")
    public BaseRespVo logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        BaseRespVo baseRespVo = BaseRespVo.baseRespErr(0, "成功");
        return baseRespVo;
    }
    @RequestMapping("profile/password")
    public BaseRespVo updatePassword(@RequestBody PasswordVo passwordVo){
        BaseRespVo baseRespVo = adminService.updatePassword(passwordVo);
        return baseRespVo;
    }
}
