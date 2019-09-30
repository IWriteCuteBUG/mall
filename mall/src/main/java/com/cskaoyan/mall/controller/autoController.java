package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class autoController {
    @RequestMapping("admin/auth/login")
    public BaseRespVo login() {
        BaseRespVo ok = BaseRespVo.ok("");
        return ok;
    }
}
