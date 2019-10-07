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

    /**
     * 获取指定 ID 订单详情
     * @param orderId
     * @return
     */
    @RequestMapping("detail")
    public BaseRespVo queryOrderDetail(int orderId){
        ForOrderDetail forOrderDetail = clyOrderService.queryOrderDetail(orderId);
        return ReturnUtilCly.back(forOrderDetail,"成功",0);
    }

    /**
     * 取消指定 ID 订单
     * 注意修改相关商品库存
     * @param orderId
     * @return
     */
    @RequestMapping("cancel")
    public BaseRespVo cancelOrder(int orderId){
        clyOrderService.cancelOrder(orderId);
        return ReturnUtilCly.back(null, "成功", 0);
    }
}
