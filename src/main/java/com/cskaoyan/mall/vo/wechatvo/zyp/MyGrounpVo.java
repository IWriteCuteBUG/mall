package com.cskaoyan.mall.vo.wechatvo.zyp;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.bean.OrderGoods;
import org.apache.tomcat.util.digester.Rules;

import java.math.BigDecimal;
import java.util.List;

public class MyGrounpVo {
    private String orderStatusText;
    private String creator;
    private Groupon groupon;
    private Integer orderId;
    private String orderSn;
    private BigDecimal actualPrice;

    private Integer joinerCount;

    private List<OrderGoods> goodsList;
    private GrouponRules rules;
    private Integer id;
    private Boolean isCreator;
    private HandleOption handleOption;

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public String getCreator() {
        return creator;
    }


    public void setCreator(Boolean creator) {
        isCreator = creator;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }


    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }


    public Integer getJoinerCount() {
        return joinerCount;
    }

    public void setJoinerCount(Integer joinerCount) {
        this.joinerCount = joinerCount;

    }

    public List<OrderGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Boolean getIsCreator() {
        return isCreator;
    }

    public void setIsCreator(Boolean isCreator) {
        this.isCreator = isCreator;
    }





}
