package com.cskaoyan.mall.vo.wechatvo.tongsong;

import com.cskaoyan.mall.bean.Category;

import java.util.List;

public class CategoryVo {
    Category currentCategory;
    List<Category> brotherCategory;
    Category parentCategory;

    public Category getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Category currentCategory) {
        this.currentCategory = currentCategory;
    }

    public List<Category> getBrotherCategory() {
        return brotherCategory;
    }

    public void setBrotherCategory(List<Category> brotherCategory) {
        this.brotherCategory = brotherCategory;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }
}
