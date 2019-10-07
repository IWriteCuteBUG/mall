package com.cskaoyan.mall.service.wechatservice.ljw;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Cart;
import com.cskaoyan.mall.vo.adminvo.voLJW.wxvoLJW.CheckedCarts;
import com.cskaoyan.mall.vo.wechatvo.ljw.ProductIds;


public interface CartService {

    BaseRespVo cartIndex(int userid);

    BaseRespVo checkedCarts(CheckedCarts checkedCarts);


    BaseRespVo addCart(Cart cart);

    BaseRespVo deleteCart(ProductIds productIds);

    BaseRespVo updateCart(Cart cart);
}
