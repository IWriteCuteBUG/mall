package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.System;
import com.cskaoyan.mall.bean.SystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemMapper {
    long countByExample(SystemExample example);

    int deleteByExample(SystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(System record);

    int insertSelective(System record);

    List<System> selectByExample(SystemExample example);

    System selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") System record, @Param("example") SystemExample example);

    int updateByExample(@Param("record") System record, @Param("example") SystemExample example);

    int updateByPrimaryKeySelective(System record);

    int updateByPrimaryKey(System record);

    String queryMallConfigOfNameById(@Param("id") int id);

    String queryMallConfigOfQQById(@Param("id") int id);

    String queryMallConfigOfAdressById(@Param("id") int id);

    String queryMallConfigOfPhoneById(@Param("id") int id);

    void updateMallConfigOfQQ(@Param("qq") String litemall_mall_qq);

    void updateMallConfigOfName(@Param("name") String litemall_mall_name);

    void updateMallConfigOfPhone(@Param("phone") String litemall_mall_phone);

    void updateMallConfigOfAdress(@Param("adress") String litemall_mall_address);
}
