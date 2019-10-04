package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.service.ExtensionGrouponService;
import com.cskaoyan.mall.vo.extensionvo.FromRequestKey;
import com.cskaoyan.mall.vo.extensionvo.GrouponRulesErr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//团购活动
/*
* admin/groupon/listRecord
* */
@RestController
@RequestMapping("admin/groupon")
public class ExtensionGrouponController {
    @Autowired
    ExtensionGrouponService extensionGrouponService;

//    查询显示团购活动
    @RequestMapping("list")
    public BaseRespVo grouponList(FromRequestKey fromRequestKey,Integer goodsId) {
        BaseRespVo baseRespVo = extensionGrouponService.queryGrouponListByGoodsId(fromRequestKey,goodsId);
        return baseRespVo;
    }

    @RequestMapping("create")
    public BaseRespVo grouponCreate(@RequestBody GrouponRules grouponRules) {
        BaseRespVo baseRespVo = extensionGrouponService.queryGrouponCreate(grouponRules);
        return baseRespVo;
    }

    @RequestMapping("delete")
    public BaseRespVo grouponDelete(@RequestBody GrouponRules grouponRules) {
        BaseRespVo baseRespVo = extensionGrouponService.queryGrouponDelete(grouponRules);
        return baseRespVo;
    }

    @RequestMapping("update")
    public BaseRespVo grouponUpdate(@RequestBody GrouponRules grouponRules) {
        /*Object discountMember = grouponRules.getDiscountMember();
        Object discount = grouponRules.getDiscount();*/
//        if()
        /*if (discountMember == null) {
            return BaseRespVo.baseRespErr(402, "团购人数不能为空");
        }
        if (discountMember instanceof String) {
            return BaseRespVo.baseRespErr(402, "团购人数应该输入整数");
        }*/
        BaseRespVo baseRespVo = extensionGrouponService.queryGrouponUpdate(grouponRules);
        return baseRespVo;
    }

}
