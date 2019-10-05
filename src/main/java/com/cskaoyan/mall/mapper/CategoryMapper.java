package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Category;
import com.cskaoyan.mall.bean.CategoryExample;
import java.util.List;


import com.cskaoyan.mall.vo.adminvo.goodsmanagervo.ForCatList;

import com.cskaoyan.mall.vo.adminvo.voLJW.Lable;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CategoryMapper {
    @Select("select id as value ,name as label from cskaoyan_mall_category")
    List<Lable> selectLabel();

    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    List<Category> selectPaAndSonBy(CategoryExample example);

    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);


    List<ForCatList> queryCatList();

    Category selectIds(@Param("categoryId") Integer categoryId);


}
