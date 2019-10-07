package com.cskaoyan.mall.vo.wechatvo.sjb;

import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.bean.Goods;

import java.util.List;

public class GoodsListAndCategoryListVo {
    private List<Goods> goodsList;
    private int count;
    private List<Category> filterCategoryList;

    public GoodsListAndCategoryListVo() {
    }

    @Override
    public String toString() {
        return "GoodsListAndCategoryListVo{" +
                "goodsList=" + goodsList +
                ", count=" + count +
                ", filterCategoryList=" + filterCategoryList +
                '}';
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Category> getFilterCategoryList() {
        return filterCategoryList;
    }

    public void setFilterCategoryList(List<Category> filterCategoryList) {
        this.filterCategoryList = filterCategoryList;
    }

    public GoodsListAndCategoryListVo(List<Goods> goodsList, int count, List<Category> filterCategoryList) {
        this.goodsList = goodsList;
        this.count = count;
        this.filterCategoryList = filterCategoryList;
    }
}
