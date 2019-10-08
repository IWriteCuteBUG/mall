package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.bean.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<String> queryDateOfUserLogin();

    int countUsersOfDay(@Param("logindate") String logindate);

    int queryUserTotal();

    @Select("select password from cskaoyan_mall_user where username = #{username}")
    String queryPasswordByUserName(String username);

    @Select("select id from cskaoyan_mall_user where username = #{username}")
    String queryIdByUsername(String username);


    @Select("select count(id) from cskaoyan_mall_user where mobile = #{mobile}")
    int queryIdCountByMobile(String mobile);

    int updateByMobile(String password, String mobile);

    @Select("select  username from  cskaoyan_mall_user where id=#{userid}")
    String queryNameById(int userid);
    @Select("select  mobile from  cskaoyan_mall_user where id=#{userid}")
    String queryMobileById(int userid);

}
