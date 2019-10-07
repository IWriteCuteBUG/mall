package com.cskaoyan.mall.service.wechatservice.ljw.impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.CartMapper;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.mapper.OrderGoodsMapper;
import com.cskaoyan.mall.mapper.OrderMapper;
import com.cskaoyan.mall.service.wechatservice.ljw.CartService;
import com.cskaoyan.mall.vo.adminvo.voLJW.wxvoLJW.CheckedCarts;
import com.cskaoyan.mall.vo.wechatvo.ljw.CartTotal;
import com.cskaoyan.mall.vo.wechatvo.ljw.ProductIds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cskaoyan.mall.util.utiLJW.ReturnUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImply implements CartService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Autowired
    CartMapper cartMapper;

    //获取购物车信息
    @Override
    public BaseRespVo cartIndex(int userid) {

        CartExample cartExample = new CartExample();
        CartExample.Criteria criteria = cartExample.createCriteria();
        criteria.andUserIdEqualTo(userid);
        List<Cart> carts = cartMapper.selectByExample(cartExample);
        CartTotal cartTotal =getCartTotal(carts);
        Map map=new HashMap();
        map.put("cartList",carts);
        map.put("cartTotal",cartTotal);
        return  com.cskaoyan.mall.util.utiLJW.ReturnUtils.ok(map,"成功");
    }
    //根据check标签更新购物车信息
    @Override
    public BaseRespVo checkedCarts(CheckedCarts checkedCarts) {
        int userid=1;
        BaseRespVo baseRespVo=cartIndex(1);
        Map map=(HashMap)baseRespVo.getData();
        //获取所有的购物车清单
        CartTotal cartTotal=(CartTotal) map.get("cartTotal");
        List<Cart> carts=( List<Cart>)map.get("cartList");
        //更新数据库购物车中的checked字段
     for (int  prductsid:checkedCarts.getProductIds()){
         for (Cart cart:carts){
             if (cart.getProductId()==prductsid){
             boolean checked=    checkedCarts.getIsChecked()==1;
             //更改bean的check字段
                 cart.setChecked(checked);
                 //更改数据库中的check字段
                 cartMapper.updateChecked(checked);
             }
         }
     }
     //获取新的cartTotal
       CartTotal newcartTotal=  getCartTotal(carts);
     //将新的cartTotal传进Date（map）
        map.put("cartTotal",newcartTotal);
          return  ReturnUtils.ok(map,"获取成功");
          }

          @Autowired
          GoodsMapper goodsMapper;
    //添加购物车
    @Override
    public BaseRespVo addCart(Cart cart) {
        int userid=1;
        cart.setUserId(userid);
     Goods goods=   goodsMapper.selectByPrimaryKey(cart.getGoodsId());
     cart.setGoodsName(goods.getName());
     cart.setPrice(goods.getCounterPrice());
     cart.setGoodsSn(goods.getGoodsSn());
     cart.setAddTime(new Date());
     cart.setUpdateTime(new Date());
     cart.setPicUrl(goods.getPicUrl());
     cartMapper.insert(cart);
    int count= cartMapper.selectCount();
        return com.cskaoyan.mall.util.utiLJW.ReturnUtils.ok(count,"添加成功");
    }

    //删除购物车
    @Override
    public BaseRespVo deleteCart(ProductIds productIds) {
        int userid=1;
       for (int productId:productIds.getProductIds()){
           cartMapper.deleteByProductIdAndUserId(productId,userid);
       }

        return ReturnUtils.ok( cartIndex(userid),"成功");
    }
  //更新购物车
    @Override
    public BaseRespVo updateCart(Cart cart) {

    cartMapper.updateNumber(cart.getId(),cart.getNumber());


        return ReturnUtils.ok(null,"成功");
    }


//
//        OrderExample orderExample=new OrderExample();
//        OrderExample.Criteria criteria=orderExample.createCriteria();
//        criteria.andOrderStatusEqualTo(Short.valueOf("101"));
//      List<Order> orderList= orderMapper.selectByExample(orderExample);
//      for (Order order:orderList){
//          Cart cart=new Cart();
//          cart.setUserId(order.getId());
//          cart.setUserId(order.getUserId());
//          //通过订单id查询订单商品连接表
//          OrderGoodsExample orderGoodsExample=new OrderGoodsExample();
//          OrderGoodsExample.Criteria criteria1=orderGoodsExample.createCriteria();
//          criteria1.andOrderIdEqualTo(order.getId());
//        List<OrderGoods> orderGoods =orderGoodsMapper.selectByExample(orderGoodsExample);


 //计算CartTotal
   private CartTotal  getCartTotal(List<Cart> carts){
       CartTotal cartTotal = new CartTotal();

       //总金额
       BigDecimal goodsAmount = new BigDecimal(0);
       //数目
       int goodsCount = 0;
       //勾选金额
       BigDecimal checkGoodsAmount=new BigDecimal(0);
       //勾选数目
       int checkgoodscount=0;

       for (Cart cart : carts) {
           goodsCount = goodsCount + cart.getNumber();
////           加法 	bigDecimal1.add(bigDecimal2)
//           减法 	bigDecimal1.subtract(bigDecimal2)
//           乘法 	bigDecimal1.multiply(bigDecimal2)
//           除法 	bigDecimal1.divide(bigDecimal2)

           //如果购物清单是被check的则进行相加！
           goodsAmount = goodsAmount.add(new BigDecimal(cart.getNumber().toString()).multiply(cart.getPrice()));
           if (cart.getChecked()==true){
               checkGoodsAmount = checkGoodsAmount.add(new BigDecimal(cart.getNumber().toString()).multiply(cart.getPrice()));
               checkgoodscount = checkgoodscount + cart.getNumber();
           }

       }
       cartTotal.setCheckedGoodsCount(checkgoodscount);
       cartTotal.setCheckedGoodsAmount(checkGoodsAmount);
       cartTotal.setGoodsAmount(goodsAmount);
       cartTotal.setGoodsCount(goodsCount);
       return cartTotal;
   }


}
