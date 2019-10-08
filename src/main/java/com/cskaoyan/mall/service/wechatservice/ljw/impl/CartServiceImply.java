package com.cskaoyan.mall.service.wechatservice.ljw.impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.service.wechatservice.ljw.CartService;
import com.cskaoyan.mall.utils.wechatutils.ljw.AssignUtils;
import com.cskaoyan.mall.vo.adminvo.voLJW.wxvoLJW.CheckedCarts;
import com.cskaoyan.mall.vo.wechatvo.ljw.CartTotal;
import com.cskaoyan.mall.vo.wechatvo.ljw.CheckOut;
import com.cskaoyan.mall.vo.wechatvo.ljw.CheckoutBean;
import com.cskaoyan.mall.vo.wechatvo.ljw.ProductIds;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cskaoyan.mall.util.utiLJW.ReturnUtils;

import java.lang.System;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
        CartTotal cartTotal = getCartTotal(carts);
        Map map = new HashMap();
        map.put("cartList", carts);
        map.put("cartTotal", cartTotal);
        return com.cskaoyan.mall.util.utiLJW.ReturnUtils.ok(map, "成功");
    }

    //根据check标签更新购物车信息
    @Override
    public BaseRespVo checkedCarts(CheckedCarts checkedCarts) {
        int userid = 1;
        BaseRespVo baseRespVo = cartIndex(1);
        Map map = (HashMap) baseRespVo.getData();
        //获取所有的购物车清单
        CartTotal cartTotal = (CartTotal) map.get("cartTotal");
        List<Cart> carts = (List<Cart>) map.get("cartList");
        //更新数据库购物车中的checked字段
     for (int  prductsid:checkedCarts.getProductIds()){
         for (Cart cart:carts){
             if (cart.getProductId()==prductsid){
             boolean checked=    checkedCarts.getIsChecked()==1;
             //更改bean的check字段
                 cart.setChecked(checked);
                 //更改数据库中的check字段
                 cartMapper.updateChecked(checked, cart.getId());
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
    public BaseRespVo addCart(Cart cart, int userid) {
        CartExample cartExample = new CartExample();
        CartExample.Criteria criteria = cartExample.createCriteria();
        criteria.andUserIdEqualTo(userid).andProductIdEqualTo(cart.getProductId());
        List<Cart> oldcarts = cartMapper.selectByExample(cartExample);

        if (oldcarts.size() != 0) {
            //相同用户id和productid的cart只会存在一个
            //取第一个
            Cart oldcart = oldcarts.get(0);
            oldcart.setNumber(Short.valueOf((String.valueOf(oldcart.getNumber() + 1))));
            //number+1 插入
            cartMapper.updateByPrimaryKeySelective(oldcart);
        }
        //如果数据库中没有则重新插入新数据
        else {
            cart.setUserId(userid);
            Goods goods = goodsMapper.selectByPrimaryKey(cart.getGoodsId());
            cart.setGoodsName(goods.getName());
            cart.setPrice(goods.getCounterPrice());
            cart.setGoodsSn(goods.getGoodsSn());
            cart.setAddTime(new Date());
            cart.setUpdateTime(new Date());
            cart.setPicUrl(goods.getPicUrl());
            cart.setChecked(true);
            cartMapper.insert(cart);

        }

        int count = cartMapper.selectCount();
        return com.cskaoyan.mall.util.utiLJW.ReturnUtils.ok(count, "添加成功");
    }

    //删除购物车
    @Override
    public BaseRespVo deleteCart(ProductIds productIds, int userid) {

        for (int productId : productIds.getProductIds()) {
            cartMapper.deleteByProductIdAndUserId(productId, userid);
        }

        return ReturnUtils.ok(cartIndex(userid), "成功");
    }

    //更新购物车
    @Override
    public BaseRespVo updateCart(Cart cart) {

        cartMapper.updateNumber(cart.getId(), cart.getNumber());


        return ReturnUtils.ok(null, "成功");
    }

    @Override
    public BaseRespVo fastadd(Cart cart) {
        int userid = 1;
        Goods goods = goodsMapper.selectByPrimaryKey(cart.getGoodsId());
        cart.setAddTime(new Date());
        //利用工具类进行同名字段的自动赋值,1赋值给2 ，返回2
        Cart newcart = (Cart) AssignUtils.assign(goods, cart);
        newcart.setGoodsName(goods.getName());
        newcart.setUserId(userid);
        newcart.setChecked(true);
        //设置价格
        newcart.setPrice(goods.getCounterPrice());
        cartMapper.insert(newcart);
        System.out.println("id是" + newcart.getId());
        return ReturnUtils.ok(newcart.getId(), "fanstadd成功");
    }


    @Autowired
    AddressMapper addressMapper;
    @Autowired
    GoodsProductMapper goodsProductMapper;
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public BaseRespVo checkOut(int cartId, int addressId, int couponId, int grouponRulesId, int userid) {
        CheckoutBean checkoutBean = new CheckoutBean();
        checkoutBean.setAddressId(addressId);
        checkoutBean.setCouponId(couponId);
        checkoutBean.setGrouponRulesId(grouponRulesId);


        //通过传入的AddressID对 地址进行赋值
        checkoutBean.setCheckedAddress(addressMapper.selectByPrimaryKey(1));


        //只对一个购物清单进行结算
        //先计算团购优惠价格和优惠券优惠价格

        BigDecimal grouponPrice = (grouponRulesId == 0) ? new BigDecimal(0) : grouponRulesMapper.getDiscountById(grouponRulesId);
        checkoutBean.setGrouponPrice(grouponPrice);


        double couponPrice = couponId == 0 ? 0 : couponMapper.selectDiscountById(couponId);
        checkoutBean.setCouponPrice(couponPrice);
        if (cartId != 0) {
            Cart cart = cartMapper.selectByPrimaryKey(cartId);
            //商品总价
            BigDecimal goodsTotalPrice = cart.getPrice().multiply(new BigDecimal(cart.getNumber()));
            checkoutBean.setGoodsTotalPrice(goodsTotalPrice);
            System.out.println(checkoutBean.getGoodsTotalPrice());

            //计算运费
            double freightPrice = checkoutBean.getActualPrice() > 88 ? 0 : 10;
            checkoutBean.setFreightPrice(freightPrice);
            //计算实付价格
            double actualPrice = goodsTotalPrice.doubleValue() - grouponPrice.doubleValue() - couponPrice + freightPrice;
            checkoutBean.setActualPrice(actualPrice);
            System.out.println(checkoutBean.getActualPrice());


            //设置order
//            Order order = new Order();
//            order.setOrderStatus(Short.valueOf("101"));
//            order.setUserId(userid);
//            order.setisGroupin(grouponRulesId == 0);
//            order.setCouponPrice(new BigDecimal(couponPrice));
//            order.setFreightPrice(new BigDecimal(freightPrice));
//            order.setGoodsPrice(goodsTotalPrice);
//            BigDecimal orderPrice = new BigDecimal(actualPrice + freightPrice);
//            order.setOrderPrice(orderPrice);
//            //默认不是会员没有积分减免 ActualPrice=orderPrice
//            order.setActualPrice(orderPrice);
//            order.setOrderSn(getOrderIdByTime());
//            User user = userMapper.selectByPrimaryKey(userid);
//            order.setConsignee(user.getUsername());
//            order.setMobile(user.getMobile());
//            order.setAddress(addressMapper.selectByPrimaryKey(1).getAddress());
//            order.setMessage("");
//            order.setIntegralPrice(new BigDecimal(0));
//            order.setGrouponPrice(grouponPrice);
//
//            orderMapper.insert(order);
//
//            int orderId = order.getId();
//            //设置ordegoods，插入OrderGoods表
//            OrderGoods orderGoods = (OrderGoods) AssignUtils.assign(cart, new OrderGoods());
//            orderGoods.setOrderId(orderId);
//            orderGoodsMapper.insert(orderGoods);
//            List<OrderGoods> orderGoodsList = new ArrayList<>();
//            orderGoodsList.add(orderGoods);
//            去库存
//            goodsProductMapper.updateNumber(orderGoods.getNumber(),orderGoods.getProductId());
//            checkoutBean.setCheckedGoodsList(orderGoodsList);


        }
        //对名下所有check的订单进行结算
        else {
            //先利用checkedCart查出需要结算的购物车清单
            CartExample cartExample = new CartExample();
            CartExample.Criteria criteria = cartExample.createCriteria();
            criteria.andCheckedEqualTo(true);
            List<Cart> cartList = cartMapper.selectByExample(cartExample);
            //计算商品总价
            BigDecimal goodsTotalPrice = getCartTotal(cartList).getCheckedGoodsAmount();
            checkoutBean.setGoodsTotalPrice(goodsTotalPrice);
            //对优惠价格进行赋值，上述已经进行计算
            checkoutBean.setGrouponPrice(grouponPrice);
            checkoutBean.setCouponPrice(couponPrice);
            //计算实际应付价格
            double actualPrice = goodsTotalPrice.doubleValue() - grouponPrice.doubleValue() - couponPrice;
            checkoutBean.setActualPrice(actualPrice);
            //计算运费
            double freightPrice = checkoutBean.getActualPrice() > 88 ? 0 : 10;
            checkoutBean.setFreightPrice(freightPrice);

//            //添加order
//            Order order = new Order();
//            order.setOrderStatus(Short.valueOf("101"));
//            order.setUserId(userid);
//            order.setisGroupin(grouponRulesId == 0);
//            order.setCouponPrice(new BigDecimal(couponPrice));
//            order.setFreightPrice(new BigDecimal(freightPrice));
//            order.setGoodsPrice(goodsTotalPrice);
//            BigDecimal orderPrice = new BigDecimal(actualPrice + freightPrice);
//            order.setOrderPrice(orderPrice);
//            order.setActualPrice(orderPrice);
//            order.setOrderSn(getOrderIdByTime());
//            User user = userMapper.selectByPrimaryKey(userid);
//            order.setConsignee(user.getUsername());
//            order.setMobile(user.getMobile());
//            order.setAddress(addressMapper.selectByPrimaryKey(addressId).getAddress());
//            order.setMessage("");
//            order.setIntegralPrice(new BigDecimal(0));
//            order.setGrouponPrice(grouponPrice);
//
//
//            orderMapper.insert(order);
//            int orderId = order.getId();
//            List<OrderGoods> orderGoodsList = new ArrayList<>();
//            for (Cart cart : cartList) {
//                OrderGoods orderGoods = (OrderGoods) AssignUtils.assign(cart, new OrderGoods());
//                orderGoods.setOrderId(orderId);
//                orderGoods.setAddTime(new Date());
//                orderGoodsMapper.insert(orderGoods);
//                orderGoodsList.add(orderGoods);
//                //去库存
//                goodsProductMapper.updateNumber(orderGoods.getNumber(),orderGoods.getProductId());

//            }
//            checkoutBean.setCheckedGoodsList(orderGoodsList);

        }
        System.out.println(checkoutBean);
        System.out.println(111);
        return ReturnUtils.ok(checkoutBean, "ok");
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
    private CartTotal getCartTotal(List<Cart> carts) {
        CartTotal cartTotal = new CartTotal();

        //总金额
        BigDecimal goodsAmount = new BigDecimal(0);
        //数目
        int goodsCount = 0;
        //勾选金额
        BigDecimal checkGoodsAmount = new BigDecimal(0);
        //勾选数目
        int checkgoodscount = 0;

        for (Cart cart : carts) {
            goodsCount = goodsCount + cart.getNumber();
////           加法 	bigDecimal1.add(bigDecimal2)
//           减法 	bigDecimal1.subtract(bigDecimal2)
//           乘法 	bigDecimal1.multiply(bigDecimal2)
//           除法 	bigDecimal1.divide(bigDecimal2)

            //如果购物清单是被check的则进行相加！
            goodsAmount = goodsAmount.add(new BigDecimal(cart.getNumber().toString()).multiply(cart.getPrice()));
            if (cart.getChecked() == true) {
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


    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
    }



}
