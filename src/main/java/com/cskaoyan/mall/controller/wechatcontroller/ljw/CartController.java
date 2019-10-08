package com.cskaoyan.mall.controller.wechatcontroller.ljw;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Cart;
import com.cskaoyan.mall.service.wechatservice.ljw.CartService;
import com.cskaoyan.mall.vo.adminvo.voLJW.wxvoLJW.CheckedCarts;
import com.cskaoyan.mall.vo.wechatvo.ljw.CheckOut;
import com.cskaoyan.mall.vo.wechatvo.ljw.ProductIds;
import org.apache.shiro.SecurityUtils;
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
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));
return cartService.cartIndex(userId);
    }

  //获取被check的购物车信息
    @RequestMapping("wx/cart/checked")
    public BaseRespVo checkedCarts(@RequestBody CheckedCarts checkedCarts){
        int userid=1;
    return    cartService.checkedCarts(checkedCarts,userid);
    }
    //添加商品至购物车
    @RequestMapping("wx/cart/add")
    public  BaseRespVo addCart(@RequestBody Cart cart){
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));

//        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        return  cartService.addCart(cart,userId);
    }
//    @RequestMapping("wx/address/list")
//    public  BaseRespVo addressList(){
//        int userid=1;
//        return  cartService.addressList(userid);
//    }

//立即购买快速添加进购物车
    @RequestMapping("wx/cart/fastadd")
    public  BaseRespVo fastadd(@RequestBody Cart cart){
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));

  return    cartService.fastadd(cart,userId);

    }

 //wx/cart/checkout
    @RequestMapping("wx/cart/checkout")
    public  BaseRespVo checkOut(int cartId,int addressId,int couponId,int grouponRulesId){
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));

        return  cartService.checkOut( cartId, addressId, couponId, grouponRulesId,userId);
    }


    //删除购物车
    @RequestMapping("wx/cart/delete")

    public  BaseRespVo deleteCart(@RequestBody ProductIds productIds){
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));

        return  cartService.deleteCart(productIds,userId);
    }

 @RequestMapping("wx/cart/update")
    public  BaseRespVo updateCart(@RequestBody Cart cart){

        return  cartService.updateCart(cart);
 }

}
