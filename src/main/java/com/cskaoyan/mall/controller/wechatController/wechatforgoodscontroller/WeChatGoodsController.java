package com.cskaoyan.mall.controller.wechatController.wechatforgoodscontroller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class WeChatGoodsController {

    @Autowired
    CountService countService;

    @RequestMapping("goods/count")
    public BaseRespVo countGoods(){
        BaseRespVo baseRespVo =countService.countGoodsNumber();
        return baseRespVo;
    }

}
