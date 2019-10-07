package com.cskaoyan.mall.service.wechatservice.zyp;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.vo.wechatvo.zyp.WeChatRegisterVo;

import java.util.List;

public interface WxAuthService {

    Integer queryIdByUsername(String username);

    List<Order>queryOrdersByUserIdAndOrderStatus(Integer userId , Integer status);

    BaseRespVo insertUser(WeChatRegisterVo registerVo);

    BaseRespVo regCaptcha(String mobile,int code);

    BaseRespVo reset(WeChatRegisterVo weChatRegisterVo);

}
