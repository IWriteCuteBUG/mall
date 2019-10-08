package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.GrouponRules;
import com.cskaoyan.mall.bean.GrouponRulesExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GrouponRulesMapper {
    long countByExample(GrouponRulesExample example);

    int deleteByExample(GrouponRulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GrouponRules record);

    int insertSelective(GrouponRules record);

    List<GrouponRules> selectByExample(GrouponRulesExample example);

    GrouponRules selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GrouponRules record, @Param("example") GrouponRulesExample example);

    int updateByExample(@Param("record") GrouponRules record, @Param("example") GrouponRulesExample example);

    int updateByPrimaryKeySelective(GrouponRules record);

    int updateByPrimaryKey(GrouponRules record);


    @Select("select discount from cskaoyan_mall_groupon_rules where id=#{grouponRulesId}")
    BigDecimal getDiscountById(int grouponRulesId);
}
