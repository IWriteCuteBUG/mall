package com.cskaoyan.mall.vo.wechatvo.zyp;

import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.bean.OrderGoods;
import org.apache.tomcat.util.digester.Rules;

import java.util.List;

public class GrouponDetailVo {
    private Creator creator;
    private Groupon groupon;
    private Joiners joiners;
    private GrouponGoodInfo orderInfo;
    private List<OrderGoods> orderGoods;
    private GrouponRules rules;
    private Integer linkGrouponId;

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public Joiners getJoiners() {
        return joiners;
    }

    public void setJoiners(Joiners joiners) {
        this.joiners = joiners;
    }

    public GrouponGoodInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(GrouponGoodInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }

    public Integer getLinkGrouponId() {
        return linkGrouponId;
    }

    public void setLinkGrouponId(Integer linkGrouponId) {
        this.linkGrouponId = linkGrouponId;
    }
}
