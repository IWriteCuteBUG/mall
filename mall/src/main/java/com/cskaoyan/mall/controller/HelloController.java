package com.cskaoyan.mall.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("hello12")
    public String hello() {
        return "hello LiJiaWei666111111";
    }
}
