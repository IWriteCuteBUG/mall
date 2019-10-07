package com.cskaoyan.mall.service.wechatservice.tangsong.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.service.wechatservice.tangsong.WeChatOrdersService;
import com.cskaoyan.mall.utils.wechatutils.tangsong.OptionUtils;
import com.cskaoyan.mall.vo.wechatvo.tongsong.OrderVo;
import com.cskaoyan.mall.vo.wechatvo.tongsong.OrderVoForReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class WeChatOrdersServiceImpl implements WeChatOrdersService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public BaseRespVo queryOrdersList(int showType,int page,int size) {
        List<OrderVo> orderVoList = null;
        if (showType == 0) {
            //根据订单状态查询出来所有的订单，然后再根据订单编号查询所有的
            orderVoList = orderMapper.queryOrdersList();
        }else if (showType == 1) {
            orderVoList = orderMapper.queryOrdersList1();
        }else if (showType == 2) {
            orderVoList = orderMapper.queryOrdersList2();
        }else if (showType == 3) {
            orderVoList = orderMapper.queryOrdersList3();
        }else if (showType == 4) {
            orderVoList = orderMapper.queryOrdersList4();
        }
        for (OrderVo orderVo : orderVoList) {
            int status = orderVo.getStatus();
            OptionUtils optionUtils = new OptionUtils(status);
            orderVo.setHandleOption(optionUtils);
            if (status == 301) {
                orderVo.setOrderStatusText("已发货");
            }else if (status == 203) {
                orderVo.setOrderStatusText("已退款");
            }else if (status == 402) {
                orderVo.setOrderStatusText("已退款");
            }else if (status == 102) {
                orderVo.setOrderStatusText("已取消(用户)");
            }else if (status == 101) {
                orderVo.setOrderStatusText("未付款");
            }else if (status == 202) {
                orderVo.setOrderStatusText("申请退款");
            }else if (status == 401) {
                orderVo.setOrderStatusText("收货(用户)");
            }else if (status == 103) {
                orderVo.setOrderStatusText("系统取消");
            }else if (status == 201) {
                orderVo.setOrderStatusText("已付款");
            }

        }
        OrderVoForReturn data = new OrderVoForReturn();
        data.setData(orderVoList);
        data.setCount(orderVoList.size());
        data.setTotalPages(orderVoList.size()/size);
        /*HashMap<String, Object> map = new HashMap<>();
        map.put("data",orderVoForReturn);*/
        return BaseRespVo.ok(data);
    }
}
