package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.bean.OrderExample;
import java.util.List;

import com.cskaoyan.mall.vo.wechatvo.tongsong.OrderVo;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<String> queryDateOfOrderCreate();

    int countOrderOrdersByDate(@Param("orders") String s);

    int countOrderCustomersByDate(@Param("customer") String s);

    int countOrderAmountByDate(@Param("amount") String s);

    int queryOrdersTotal();

    List<OrderVo> queryOrdersList();

    //未付款
    List<OrderVo> queryOrdersList1();

    //代发货
    List<OrderVo> queryOrdersList2();

    //已发货
    List<OrderVo> queryOrdersList3();

    //待评价
    List<OrderVo> queryOrdersList4();

    //提交订单
    int submitOrders(@Param("order") Order order);
}
