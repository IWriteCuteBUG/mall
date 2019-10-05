package com.cskaoyan.mall.controller.wechatcontroller.tongsong;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.wechatservice.tangsong.WeChatBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeChatBrandController {

    @Autowired
    WeChatBrandService weChatBrandService;

    @RequestMapping("/wx/brand/list")
    public BaseRespVo queryBrandList(int page,int size){
        return weChatBrandService.queryBrandList(page, size);
    }
}
