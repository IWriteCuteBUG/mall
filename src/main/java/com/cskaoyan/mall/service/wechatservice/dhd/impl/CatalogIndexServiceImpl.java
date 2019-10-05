package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.bean.CategoryExample;
import com.cskaoyan.mall.mapper.CategoryMapper;
import com.cskaoyan.mall.vo.wechatvo.dhd.CategoryListVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CatalogIndexServiceImpl implements CatalogIndexService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public BaseRespVo selectCatalogIndex() {
        CategoryListVo categoryListVo = new CategoryListVo();
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andLevelEqualTo("L1");
        List<Category> l1 = categoryMapper.selectByExample(categoryExample);
        categoryListVo.setCategoryList(l1);
        Category category = l1.get(0);
        categoryListVo.setCurrentCategory(category);
        CategoryExample categoryExample1 = new CategoryExample();
        categoryExample1.createCriteria().andPidEqualTo(category.getId());
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        categoryListVo.setCurrentSubCategory(categories);
        BaseRespVo ok = BaseRespVo.ok(categoryListVo);
        return ok;
    }
    @Autowired
    CategoryMapper categoryMapper2;
    @Override
    public BaseRespVo selectCurrentlogIndex(int id) {
        CategoryListVo categoryListVo = new CategoryListVo();
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andPidEqualTo(id);
        List<Category> categories = categoryMapper2.selectByExample( categoryExample);
        categoryListVo.setCurrentSubCategory(categories);
        Category category = categoryMapper2.selectIds(id);
        categoryListVo.setCurrentCategory(category);
        BaseRespVo ok = BaseRespVo.ok(categoryListVo);
        return ok;
    }
}
