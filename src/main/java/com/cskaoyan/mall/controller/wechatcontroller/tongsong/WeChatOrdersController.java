package com.cskaoyan.mall.controller.wechatcontroller.tongsong;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.SubmitOrders;
import com.cskaoyan.mall.service.wechatservice.tangsong.WeChatOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/wx")
public class WeChatOrdersController {

    @Autowired
    WeChatOrdersService weChatOrdersService;

    @RequestMapping("order/list")
    public BaseRespVo queryOrdersList(int showType,int page,int size){
        return weChatOrdersService.queryOrdersList(showType,page,size);
    }

    @RequestMapping("order/submit")
    public BaseRespVo submitOrder(@RequestBody SubmitOrders submitOrders){
        BaseRespVo baseRespVo = weChatOrdersService.submitOrder(submitOrders);
        return baseRespVo;
    }
    @RequestMapping("order/confirm")
    public BaseRespVo confirmOrder(@RequestBody HashMap hashMap){
        Integer orderId = (Integer) hashMap.get("orderId");
        BaseRespVo baseRespVo = weChatOrdersService.confirmOrder(orderId);
        return baseRespVo;
    }
}
