package com.cskaoyan.mall.controller.wechatcontroller.dhd;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.wechatservice.dhd.impl.OrderRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import java.util.HashMap;

@RestController
public class OrderRefundController {
    @Autowired
    OrderRefundService orderRefundService;
    @RequestMapping("/wx/order/refund")
    public Object orderRefund(@RequestBody HashMap map){
        Integer orderId =(Integer) map.get("orderId");
        Object object=orderRefundService.changeIdStatus(orderId);
       return object;
    }
}
