package com.cskaoyan.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于测试，项目开了就删了吧
 */
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        return "hello ourProject";
    }

}
