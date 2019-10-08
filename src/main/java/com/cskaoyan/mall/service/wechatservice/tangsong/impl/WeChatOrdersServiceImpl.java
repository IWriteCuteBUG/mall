package com.cskaoyan.mall.service.wechatservice.tangsong.impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.service.wechatservice.tangsong.WeChatOrdersService;
import com.cskaoyan.mall.utils.wechatutils.ljw.AssignUtils;
import com.cskaoyan.mall.utils.wechatutils.tangsong.OptionUtils;
import com.cskaoyan.mall.vo.wechatvo.tongsong.OrderVo;
import com.cskaoyan.mall.vo.wechatvo.tongsong.OrderVoForReturn;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class WeChatOrdersServiceImpl implements WeChatOrdersService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GrouponMapper grouponMapper;

    @Autowired
    OrderGoodsMapper orderGoodsMapper;

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
        if (orderVoList.size() == 0) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("data",new ArrayList<>());
            map.put("count",0);
            map.put("totalPages",0);
            return BaseRespVo.ok(map);
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
                orderVo.setOrderStatusText("收货(系统)");
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

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    @Override
    public BaseRespVo submitOrder(SubmitOrders submitOrders) {
        //先取得地址id
        int addressId = submitOrders.getAddressId();
        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andIdEqualTo(addressId);
        List<Address> addresses = addressMapper.selectByExample(addressExample);
        //獲取到地址
        String address = addresses.get(0).getAddress();
        //获取优惠券减免
        //先判斷是否有優惠券
        int couponId = submitOrders.getCouponId();
        BigDecimal discount;
        if (couponId != 0) {
            CouponExample couponExample = new CouponExample();
            couponExample.createCriteria().andIdEqualTo(submitOrders.getCouponId());
            List<Coupon> coupons = couponMapper.selectByExample(couponExample);
            discount = coupons.get(0).getDiscount();
        }else {
            discount = BigDecimal.valueOf(0);
        }

        //获取团购减免

        int grouponRulesId = submitOrders.getGrouponRulesId();

        BigDecimal grouponDescount;
        if (grouponRulesId != 0) {
            GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
            grouponRulesExample.createCriteria().andIdEqualTo(submitOrders.getGrouponRulesId());
            List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);
            grouponDescount = grouponRules.get(0).getDiscount();
        }else {
            grouponDescount = BigDecimal.valueOf(0);
        }

        //生成訂單編號
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String dateString = format.format(date);
        String orderId = dateString.substring(4);



        //         以下为赵宇鹏的代码
//        int userId1 = 1;
        Integer userId1 = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
//        int grouponRulesId = 0;
//        int grouponLinkId = 0;

        if (grouponRulesId != 0) {

            /*GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
            grouponRulesExample.createCriteria().andIdEqualTo(grouponRulesId);
            List<GrouponRules> grouponRules = grouponRulesMapper.selectByExample(grouponRulesExample);*/
//            查询团购规则的信息
            GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(grouponRulesId);

//            查询当前团购的数量
            GrouponExample grouponExample = new GrouponExample();
//            grouponExample.createCriteria().andRulesIdEqualTo(grouponRulesId).andGrouponIdEqualTo(grouponLinkId);

//            不使用grouponLinkId
            grouponExample.createCriteria().andRulesIdEqualTo(grouponRulesId);
            List<Groupon> groupons = grouponMapper.selectByExample(grouponExample);

//            在团购规则中取出团购人数需要几人
            Integer discountMember = grouponRules.getDiscountMember();
//            当前团购的数量
            int size = groupons.size();
//            当前团购数量小于团购人数时，加入他人的团购
            Groupon groupon = new Groupon();
            groupon.setOrderId(Integer.valueOf(orderId));//需要修改
            Integer rulesId = grouponRules.getId();
            groupon.setRulesId(rulesId);
            groupon.setUserId(userId1);
            Date date1 = new Date();
            groupon.setAddTime(date1);
            groupon.setPayed(true);
            groupon.setDeleted(false);
//            是否能整除,不需要整除
//            int i = size / discountMember;
//            取余
            int i1 = size % discountMember;
            Integer grouponId = grouponMapper.queryMaxGrouponIdByRuleId(rulesId);
            if (grouponId == null) {
                grouponId = 1;
            }
            if (i1 != 0) {
//                获取当前要参加的他人创建的团购的信息
                Groupon groupon1 = groupons.get(0);

//                设置团购规则下的团购id
//                Integer grouponId = groupon1.getGrouponId();
                groupon.setGrouponId(grouponId);

//               设置当前团购规则下的创建人Id
                Integer userId2 = groupon1.getUserId();
                groupon.setCreatorUserId(userId2);

//                进行数据库的插入操作
                grouponMapper.insertSelective(groupon);
            }
//            当当前团购为0或团购已满时，作为创建者加入团购
            if (i1 == 0) {
                groupon.setGrouponId(grouponId + 1);
                groupon.setCreatorUserId(userId1);
                grouponMapper.insertSelective(groupon);
            }

        }

//        以上为赵宇鹏的代码






        //判斷
        int cartId = submitOrders.getCartId();
        if (cartId != 0) {
            //从购物车取到商品数量
            CartExample cartExample = new CartExample();
            cartExample.createCriteria().andIdEqualTo(submitOrders.getCartId());
            List<Cart> carts = cartMapper.selectByExample(cartExample);
            Cart cart = carts.get(0);
            int number = cart.getNumber();
            String specifications = cart.getSpecifications();
//            String specifications = "[\"标准\"]";
            Integer goodsId = cart.getGoodsId();
            //减去库存
            GoodsProduct goodsProduct = new GoodsProduct();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String addTime = format1.format(new Date());
            Date parse = null;
            try {
                parse = format1.parse(addTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            goodsProduct.setAddTime(parse);
            goodsProduct.setDeleted(false);
            goodsProduct.setNumber(number);
            goodsProduct.setUpdateTime(parse);
            GoodsProductExample goodsProductExample = new GoodsProductExample();
            goodsProductExample.createCriteria().andGoodsIdEqualTo(goodsId).andSpecificationsEqualTo(specifications);
            List<GoodsProduct> productList1 = goodsProductMapper.selectByExample(goodsProductExample);
            GoodsProduct goodsProduct2 = productList1.get(0);
            Integer number1 = goodsProduct2.getNumber();
            goodsProduct.setNumber(number1 - number);
            goodsProductMapper.updateByExampleSelective(goodsProduct,goodsProductExample);
            //提交订单
            Order order = new Order();
            order.setOrderSn(orderId);
            order.setAddress(address);
            order.setAddTime(parse);
            order.setUpdateTime(parse);
            order.setMessage(submitOrders.getMessage());
            order.setGrouponPrice(grouponDescount);
            order.setCouponPrice(discount);
            order.setOrderStatus((short) 101);
            Integer userId = cart.getUserId();
            UserExample userExample = new UserExample();
            userExample.createCriteria().andIdEqualTo(userId);
            List<User> users = userMapper.selectByExample(userExample);
            User user = users.get(0);
            order.setUserId(userId);
            order.setConsignee(user.getUsername());
            order.setMobile(user.getMobile());
            //查詢商品信息

            BigDecimal price = cart.getPrice();
            BigDecimal actualPrice = price.subtract(discount).subtract(grouponDescount);
            order.setActualPrice(actualPrice);
            GoodsExample goodsExample = new GoodsExample();
            goodsExample.createCriteria().andIdEqualTo(goodsId);
            List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
            //查询商品信息
            Goods goods = goodsList.get(0);
            order.setGoodsPrice(goods.getCounterPrice());
            order.setFreightPrice(BigDecimal.valueOf(0));
            order.setIntegralPrice(BigDecimal.valueOf(0));
            BigDecimal orderPrice = cart.getPrice().add(grouponDescount).add(discount);
            order.setOrderPrice(orderPrice);
            orderMapper.insert(order);
            //插入GoodsAndORDER表
            OrderGoods orderGoods = new OrderGoods();
            orderGoods.setAddTime(parse);
            orderGoods.setComment(0);
            int i = Integer.parseInt(orderId);
            orderGoods.setOrderId(i);
            orderGoods.setGoodsName(goods.getName());
            orderGoods.setGoodsId(goodsId);
            String s = String.valueOf(goodsId);
            orderGoods.setGoodsSn(s);
            orderGoods.setNumber(cart.getNumber());
            GoodsProductExample goodsProductExample1 = new GoodsProductExample();
            goodsProductExample1.createCriteria().andSpecificationsEqualTo(specifications).andGoodsIdEqualTo(goodsId);
            List<GoodsProduct> productList = goodsProductMapper.selectByExample(goodsProductExample1);
            GoodsProduct goodsProduct1 = productList.get(0);
            Integer id = goodsProduct1.getId();
            orderGoods.setProductId(id);
            String[] strings = new String[]{specifications};
            orderGoods.setSpecifications(strings);
            orderGoods.setPrice(cart.getPrice());
            orderGoods.setPicUrl(cart.getPicUrl());
            orderGoods.setAddTime(parse);
            orderGoods.setUpdateTime(parse);
            int insert = orderGoodsMapper.insert(orderGoods);
            //删除购物车
            cartMapper.deleteByPrimaryKey(submitOrders.getCartId());
            HashMap<String, Object> map = new HashMap<>();
            map.put("orderId",orderId);
            BaseRespVo ok = BaseRespVo.ok(map);
            return ok;
        } else {
            //設置訂單編號
            CartExample cartExample = new CartExample();
            cartExample.createCriteria().andCheckedEqualTo(true);
            List<Cart> carts = cartMapper.selectByExample(cartExample);
            for (Cart cart : carts) {
                int number = cart.getNumber();
                String specifications = cart.getSpecifications();
                Integer goodsId = cart.getGoodsId();
                //减去库存
                GoodsProduct goodsProduct = new GoodsProduct();
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String addTime = format1.format(new Date());
                Date parse = null;
                try {
                    parse = format1.parse(addTime);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                goodsProduct.setAddTime(parse);
                goodsProduct.setDeleted(false);
                goodsProduct.setNumber(number);
                goodsProduct.setUpdateTime(parse);
                GoodsProductExample goodsProductExample = new GoodsProductExample();
                goodsProductExample.createCriteria().andGoodsIdEqualTo(goodsId).andSpecificationsEqualTo(specifications);
                List<GoodsProduct> productList1 = goodsProductMapper.selectByExample(goodsProductExample);
                GoodsProduct goodsProduct2 = productList1.get(0);
                Integer number1 = goodsProduct2.getNumber();
                goodsProduct.setNumber(number1 - number);
                goodsProductMapper.updateByExampleSelective(goodsProduct,goodsProductExample);
                goodsProductMapper.updateByExampleSelective(goodsProduct,goodsProductExample);
                //提交订单
                Order order = new Order();
                order.setOrderSn(orderId);
                order.setAddress(address);
                order.setAddTime(parse);
                order.setUpdateTime(parse);
                order.setMessage(submitOrders.getMessage());
                order.setGrouponPrice(grouponDescount);
                order.setCouponPrice(discount);
                order.setOrderStatus((short) 101);
                Integer userId = cart.getUserId();
                UserExample userExample = new UserExample();
                userExample.createCriteria().andIdEqualTo(userId);
                List<User> users = userMapper.selectByExample(userExample);
                User user = users.get(0);
                order.setUserId(userId);
                order.setConsignee(user.getUsername());
                order.setMobile(user.getMobile());
                //查詢商品信息

                BigDecimal price = cart.getPrice();
                BigDecimal actualPrice = price.subtract(discount).subtract(grouponDescount);
                order.setActualPrice(actualPrice);
                GoodsExample goodsExample = new GoodsExample();
                goodsExample.createCriteria().andIdEqualTo(goodsId);
                List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
                //查询商品信息
                Goods goods = goodsList.get(0);
                order.setGoodsPrice(goods.getCounterPrice());
                order.setFreightPrice(BigDecimal.valueOf(0));
                order.setIntegralPrice(BigDecimal.valueOf(0));
                BigDecimal orderPrice = cart.getPrice().add(grouponDescount).add(discount);
                order.setOrderPrice(orderPrice);
                orderMapper.insert(order);
                //插入GoodsAndORDER表

                /*GoodsProduct goodsProduct1 = new GoodsProduct();
                int number1 = cart.getNumber();
                goodsProduct1.setNumber(number1);
                goodsProduct1.setUpdateTime(parse);
                goodsProduct1.setAddTime(parse);
                goodsProduct1.setPrice(actualPrice);
                goodsProduct1.setUrl(cart.getPicUrl());
                String[] strings = new String[]{specifications};
                goodsProduct1.setSpecifications(strings);
                goodsProduct1.setDeleted(false);
                goodsProduct1.setGoodsId(goodsId);
                goodsProductMapper.insert(goodsProduct1);*/
                OrderGoods orderGoods = new OrderGoods();
                orderGoods.setAddTime(parse);
                orderGoods.setComment(0);
                int i = Integer.parseInt(orderId);
                orderGoods.setOrderId(i);
                orderGoods.setGoodsName(goods.getName());
                orderGoods.setGoodsId(goodsId);
                String s = String.valueOf(goodsId);
                orderGoods.setGoodsSn(s);
                orderGoods.setNumber(cart.getNumber());
                GoodsProductExample goodsProductExample1 = new GoodsProductExample();
                goodsProductExample1.createCriteria().andSpecificationsEqualTo(specifications).andGoodsIdEqualTo(goodsId);
                List<GoodsProduct> productList = goodsProductMapper.selectByExample(goodsProductExample1);
                GoodsProduct goodsProduct1 = productList.get(0);
                Integer id = goodsProduct1.getId();
                orderGoods.setProductId(id);
                String[] strings = new String[]{specifications};
                orderGoods.setSpecifications(strings);
                orderGoods.setPrice(cart.getPrice());
                orderGoods.setPicUrl(cart.getPicUrl());
                orderGoods.setAddTime(parse);
                orderGoods.setUpdateTime(parse);
                int insert = orderGoodsMapper.insert(orderGoods);
                //删除购物车
                cartMapper.deleteByPrimaryKey(submitOrders.getCartId());

            }
            BaseRespVo ok = BaseRespVo.ok(orderId);
            return ok;
        }
    }

    @Override
    public BaseRespVo confirmOrder(int orderId) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andIdEqualTo(orderId);
        Order order = new Order();
        order.setOrderStatus((short) 401);
        orderMapper.updateByExampleSelective(order,orderExample);
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrmsg("成功");
        objectBaseRespVo.setData("success");
        objectBaseRespVo.setErrno(0);
        return objectBaseRespVo;
    }
}
