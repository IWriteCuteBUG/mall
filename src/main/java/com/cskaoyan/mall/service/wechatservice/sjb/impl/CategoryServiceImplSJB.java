package com.cskaoyan.mall.service.wechatservice.sjb.impl;

import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.mapper.CategoryMapper;
import com.cskaoyan.mall.service.wechatservice.sjb.CategoryServiceSJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImplSJB implements CategoryServiceSJB {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Category queryCategoryById(Integer categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }
}
