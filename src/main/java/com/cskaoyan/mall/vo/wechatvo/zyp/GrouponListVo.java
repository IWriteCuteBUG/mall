package com.cskaoyan.mall.vo.wechatvo.zyp;

import java.math.BigDecimal;

public class GrouponListVo {
    private BigDecimal groupon_price;
    private GrouponListGoodVo goods;
    private Integer groupon_member;

    public BigDecimal getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(BigDecimal groupon_price) {
        this.groupon_price = groupon_price;
    }

    public GrouponListGoodVo getGoods() {
        return goods;
    }

    public void setGoods(GrouponListGoodVo goods) {
        this.goods = goods;
    }

    public Integer getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(Integer groupon_member) {
        this.groupon_member = groupon_member;
    }
}
