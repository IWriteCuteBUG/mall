package com.cskaoyan.mall.service.wechatservice.ljw;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Cart;
import com.cskaoyan.mall.vo.adminvo.voLJW.wxvoLJW.CheckedCarts;
import com.cskaoyan.mall.vo.wechatvo.ljw.CheckOut;
import com.cskaoyan.mall.vo.wechatvo.ljw.ProductIds;


public interface CartService {

    BaseRespVo cartIndex(int userid);

    BaseRespVo checkedCarts(CheckedCarts checkedCarts,int userid);


    BaseRespVo addCart(Cart cart,int userid);
   //需要修改
    BaseRespVo deleteCart(ProductIds productIds,int userid);

    BaseRespVo updateCart(Cart cart);


    BaseRespVo  fastadd(Cart cart,int userId);



    BaseRespVo checkOut(int cartId, int addressId, int couponId, int grouponRulesId,int userid);

    BaseRespVo addressList(int userid);
}
