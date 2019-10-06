package com.cskaoyan.mall.vo.wechatvo.tongsong;

public class GoodsVoWeChat {
    private int groupon_price;
    private GoodsVoWeChats goods;
    private int groupon_member;

    public int getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(int groupon_price) {
        this.groupon_price = groupon_price;
    }

    public GoodsVoWeChats getGoods() {
        return goods;
    }

    public void setGoods(GoodsVoWeChats goods) {
        this.goods = goods;
    }

    public int getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(int groupon_member) {
        this.groupon_member = groupon_member;
    }
}
