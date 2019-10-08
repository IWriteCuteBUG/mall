package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Groupon;
import com.cskaoyan.mall.bean.GrouponExample;
import java.util.List;

import com.cskaoyan.mall.bean.Order;
import com.cskaoyan.mall.vo.wechatvo.zyp.GrouponGoodInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GrouponMapper {
    long countByExample(GrouponExample example);

    int deleteByExample(GrouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Groupon record);

    int insertSelective(Groupon record);

    List<Groupon> selectByExample(GrouponExample example);

    Groupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Groupon record, @Param("example") GrouponExample example);

    int updateByExample(@Param("record") Groupon record, @Param("example") GrouponExample example);

    int updateByPrimaryKeySelective(Groupon record);

    int updateByPrimaryKey(Groupon record);

    @Select("select count(id) from cskaoyan_mall_groupon where rules_id = #{ruleId}")
    int selectJoinerCountByRuleId(int ruleId);

    @Select("SELECT max(groupon_id) FROM `cskaoyan_mall_groupon` where rules_id = #{rulesId}")
    int queryMaxGrouponIdByRuleId(Integer rulesId);
}
