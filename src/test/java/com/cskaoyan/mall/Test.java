package com.cskaoyan.mall;


import com.cskaoyan.mall.mapper.GoodsMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class Test {
    @Autowired
    GoodsMapper goodsMapper;
    @org.junit.Test

    public  void test1 (){
        System.out.println("11111111111111111111111111111111");
        System.out.println("--------------------"+goodsMapper.deleteByPrimaryKey(100000000));

    }
}
