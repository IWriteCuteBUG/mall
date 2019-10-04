package com.cskaoyan.mall.vo.tvo;

import com.cskaoyan.mall.bean.Goodss;
import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.bean.GrouponRules;

public class GrouponsVoInfo {
    Groupon groupon;
    Goodss goods;
    GrouponRules rules;
    int[] subGroupons;

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public Goodss getGoods() {
        return goods;
    }

    public void setGoods(Goodss goods) {
        this.goods = goods;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }

    public int[] getSubGroupons() {
        return subGroupons;
    }

    public void setSubGroupons(int[] subGroupons) {
        this.subGroupons = subGroupons;
    }
}
