package com.cskaoyan.mall.mapper;

import com.cskaoyan.mall.bean.Cart;
import com.cskaoyan.mall.bean.CartExample;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CartMapper {
    long countByExample(CartExample example);

    int deleteByExample(CartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    List<Cart> selectByExample(CartExample example);

    Cart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    Integer selectUserId(@Param("cartId") int cartId);

    List<Cart> selectGoodsId(@Param("userId") Integer userId);

    @Update("update cskaoyan_mall_cart set checked =#{ischecked} where id=#{cartId}")
    void updateChecked(boolean isChecked, int cartId);

    @Select("select count(id) from  cskaoyan_mall_cart ")
    int selectCount();

    @Delete("delete from   cskaoyan_mall_cart where product_id=#{productId} and user_id=#{userid}")
    void deleteByProductIdAndUserId(int productId,int userId);

    @Update("update cskaoyan_mall_cart set number=#{number} where id=#{id}")
    void updateNumber(Integer id, int number);
}
