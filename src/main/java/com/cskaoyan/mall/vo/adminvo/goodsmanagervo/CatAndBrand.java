package com.cskaoyan.mall.vo.adminvo.goodsmanagervo;

import java.util.List;

public class CatAndBrand {
    List<ForCatList> categoryList;
    List<ForBrandList> brandList;

    public List<ForCatList> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<ForCatList> categoryList) {
        this.categoryList = categoryList;
    }

    public List<ForBrandList> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<ForBrandList> brandList) {
        this.brandList = brandList;
    }
}
