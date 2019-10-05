package com.cskaoyan.mall.controller.wechatController.tongsong;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.adminservice.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeChatHomeController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/wx/home/index")
    public BaseRespVo weChatIndex(){
        BaseRespVo baseRespVo = goodsService.queryAllGoodsInfo();
        return baseRespVo;
    }
}
