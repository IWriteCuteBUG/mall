package com.cskaoyan.mall.controller.wechatcontroller.ljw;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Cart;
import com.cskaoyan.mall.service.wechatservice.ljw.CartService;
import com.cskaoyan.mall.vo.adminvo.voLJW.wxvoLJW.CheckedCarts;
import com.cskaoyan.mall.vo.wechatvo.ljw.ProductIds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
@Autowired
CartService cartService;
    //获取购物车详情
    @RequestMapping("wx/cart/index")
    public BaseRespVo cartIndex(){
int userid=1;
return cartService.cartIndex(userid);
    }

  //获取被check的购物车信息
    @RequestMapping("wx/cart/checked")
    public BaseRespVo checkedCarts(@RequestBody CheckedCarts checkedCarts){
    return    cartService.checkedCarts(checkedCarts);
    }
    //添加商品至购物车
    @RequestMapping("wx/cart/add")
    public  BaseRespVo addCart(@RequestBody Cart cart){

        return  cartService.addCart(cart);
    }




    //删除购物车
    @RequestMapping("wx/cart/delete")

    public  BaseRespVo deleteCart(@RequestBody ProductIds productIds){
        return  cartService.deleteCart(productIds);
    }

 @RequestMapping("wx/cart/update")
    public  BaseRespVo updateCart(@RequestBody Cart cart){

        return  cartService.updateCart(cart);
 }

}
