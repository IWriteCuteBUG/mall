package com.cskaoyan.mall.controller.admincontroller.controllerZYP;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.exception.ExtensionCouponDiscountException;
import com.cskaoyan.mall.service.adminservice.ExtensionGrouponService;
import com.cskaoyan.mall.vo.adminvo.extensionvo.FromRequestKey;
import com.cskaoyan.mall.vo.adminvo.extensionvo.GrouponRulesNotKnow;
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
    public BaseRespVo grouponList(FromRequestKey fromRequestKey) {
        BaseRespVo baseRespVo = extensionGrouponService.queryGrouponListByGoodsId(fromRequestKey);
        return baseRespVo;
    }

    @RequestMapping("create")
    public BaseRespVo grouponCreate(@RequestBody GrouponRulesNotKnow grouponRulesNotKnow) throws ExtensionCouponDiscountException {
        BaseRespVo baseRespVo = extensionGrouponService.queryGrouponCreate(grouponRulesNotKnow);
        return baseRespVo;
    }

    @RequestMapping("delete")
    public BaseRespVo grouponDelete(@RequestBody GrouponRules grouponRules) {
        BaseRespVo baseRespVo = extensionGrouponService.queryGrouponDelete(grouponRules);
        return baseRespVo;
    }

    @RequestMapping("update")
    public BaseRespVo grouponUpdate(@RequestBody GrouponRulesNotKnow grouponRulesNotKnow) throws ExtensionCouponDiscountException {
        BaseRespVo baseRespVo = extensionGrouponService.queryGrouponUpdate(grouponRulesNotKnow);
        return baseRespVo;
    }

}
