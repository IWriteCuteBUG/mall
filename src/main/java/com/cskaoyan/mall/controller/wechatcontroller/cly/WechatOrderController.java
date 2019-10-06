package com.cskaoyan.mall.controller.wechatcontroller.cly;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.wechatservice.cly.ClyOrderService;
import com.cskaoyan.mall.utils.wechatutils.cly.ReturnUtilCly;
import com.cskaoyan.mall.vo.wechatvo.cly.ForOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx/order")
public class WechatOrderController {
    @Autowired
    ClyOrderService clyOrderService;

    @RequestMapping("detail")
    public BaseRespVo queryOrderDetail(int orderId){
        ForOrderDetail forOrderDetail = clyOrderService.queryOrderDetail(orderId);
        return ReturnUtilCly.back(forOrderDetail,"成功",0);
    }

    @RequestMapping("cancel")
    public BaseRespVo cancelOrder(int orderId){
        clyOrderService.cancelOrder(orderId);
        return ReturnUtilCly.back(null, "成功", 0);
    }
}
