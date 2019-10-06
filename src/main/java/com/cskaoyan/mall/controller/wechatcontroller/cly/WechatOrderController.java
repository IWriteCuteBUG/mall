package com.cskaoyan.mall.controller.wechatcontroller.cly;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.wechatservice.cly.ClyOrderService;
import com.cskaoyan.mall.utils.wechatutils.cly.ReturnUtilCly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx/order")
public class WechatOrderController {
    @Autowired
    ClyOrderService clyOrderService;

    @RequestMapping("detail")
    public BaseRespVo queryOrderDetail(int id){
        clyOrderService.queryOrderDetail(id);
        return ReturnUtilCly.back(null,"",0);
    }
}
