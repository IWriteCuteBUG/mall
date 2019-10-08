package com.cskaoyan.mall.controller.wechatcontroller.dhd;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.wechatservice.dhd.impl.OrderIdDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class OrderIdDeleteController {
    @Autowired
    OrderIdDeleteService orderIdDeleteService;
    @RequestMapping("/wx/order/delete")
    public BaseRespVo orderIdDeleteInfo(@RequestBody HashMap map){
        Integer orderId =(Integer) map.get("orderId");
      BaseRespVo baseRespVo= orderIdDeleteService.deleteOrder(orderId);
      return  baseRespVo;
    }
}
