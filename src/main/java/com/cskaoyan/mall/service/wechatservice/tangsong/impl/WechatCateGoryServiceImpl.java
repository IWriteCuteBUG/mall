package com.cskaoyan.mall.service.wechatservice.tangsong.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.bean.CategoryExample;
import com.cskaoyan.mall.mapper.CategoryMapper;
import com.cskaoyan.mall.service.wechatservice.tangsong.WechatCateGoryService;
import com.cskaoyan.mall.vo.wechatvo.tongsong.CategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WechatCateGoryServiceImpl implements WechatCateGoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public BaseRespVo queryGoodsCategory(int id) {
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andIdEqualTo(id);
        List<Category> currentCategory = categoryMapper.selectByExample(categoryExample);
        BaseRespVo<CategoryVo> categoryVoBaseRespVo = new BaseRespVo<>();
        CategoryVo categoryVo = new CategoryVo();
        for (Category category : currentCategory) {
            int pid = category.getPid();
            CategoryExample categoryExample1 = new CategoryExample();
            categoryExample1.createCriteria().andPidEqualTo(pid);
            List<Category> brotherCategory = categoryMapper.selectByExample(categoryExample1);
            CategoryExample categoryExample2 = new CategoryExample();
            categoryExample2.createCriteria().andIdEqualTo(pid);
            List<Category> categories = categoryMapper.selectByExample(categoryExample2);
            categoryVo.setCurrentCategory(category);
            if(categories.size() != 0){
                categoryVo.setParentCategory(categories.get(0));
                categoryVo.setBrotherCategory(brotherCategory);
            }
        }
        categoryVoBaseRespVo.setData(categoryVo);
        categoryVoBaseRespVo.setErrno(0);
        categoryVoBaseRespVo.setErrmsg("成功");
        return categoryVoBaseRespVo;
    }
}
