package com.cskaoyan.mall.vo.wechatvo.dhd;

import com.cskaoyan.mall.bean.Category;

import java.util.List;

public class CategoryListVo {
    List<Category> categoryList;
    Category currentCategory;
    List<Category> currentSubCategory;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
    }

    public List<Category> getCurrentSubCategory() {
        return currentSubCategory;
    }

    public void setCurrentSubCategory(List<Category> currentSubCategory) {
        this.currentSubCategory = currentSubCategory;
    }

    @Override
    public String toString() {
        return "CategoryListVo{" +
                "categoryList=" + categoryList +
                ", currentCategory=" + currentCategory +
                ", currentSubCategory=" + currentSubCategory +
                '}';
    }
}
