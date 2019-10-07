package com.cskaoyan.mall.vo.wechatvo.ljw;

import java.math.BigDecimal;

public class CartTotal {
    //选中商品的数目
    private  BigDecimal checkedGoodsAmount;
    //选中商品的价格
    private  int checkedGoodsCount;
    //整个购物车的价格
    private BigDecimal goodsAmount;
    //整个购物车的商品数目
    private  int goodsCount;

    public BigDecimal getCheckedGoodsAmount() {
        return checkedGoodsAmount;
    }

    public void setCheckedGoodsAmount(BigDecimal checkedGoodsAmount) {
        this.checkedGoodsAmount = checkedGoodsAmount;
    }

    public int getCheckedGoodsCount() {
        return checkedGoodsCount;
    }

    public void setCheckedGoodsCount(int checkedGoodsCount) {
        this.checkedGoodsCount = checkedGoodsCount;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }
}
