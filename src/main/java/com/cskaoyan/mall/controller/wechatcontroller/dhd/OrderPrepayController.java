package com.cskaoyan.mall.controller.wechatcontroller.dhd;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.wechatservice.dhd.impl.OrderPrepayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderPrepayController {
    @Autowired
    OrderPrepayService orderPrepayService;
    @RequestMapping("/wx/order/prepay")
    public HashMap<String, Object> OrderPrePayInfo(@RequestBody String orderId){
        HashMap<String, Object> stringObjectHashMap = orderPrepayService.changeOrder_Status(orderId);
        return stringObjectHashMap;
    }
}
