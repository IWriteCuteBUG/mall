package com.cskaoyan.mall.vo.adminvo.goodsmanagervo;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.GoodsAttribute;
import com.cskaoyan.mall.bean.GoodsProduct;
import com.cskaoyan.mall.bean.GoodsSpecification;

import java.util.List;

public class GoodsDetail {
    private List<Integer> categoryIds;
    private Goods goods;
    private List<GoodsAttribute> attributes;
    private List<GoodsSpecification> specifications;
    private List<GoodsProduct> products;

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<GoodsAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<GoodsAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<GoodsSpecification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<GoodsSpecification> specifications) {
        this.specifications = specifications;
    }

    public List<GoodsProduct> getProducts() {
        return products;
    }

    public void setProducts(List<GoodsProduct> products) {
        this.products = products;
    }
}
