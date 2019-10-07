package com.cskaoyan.mall;


import com.alibaba.fastjson.JSON;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.GoodsExample;
import com.cskaoyan.mall.mapper.GoodsMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)

public class Test {


    @Autowired
    GoodsMapper goodsMapper;
    @org.junit.Test
    public  void test1 (){

            GoodsExample goodsExample=new GoodsExample();
            GoodsExample.Criteria criteria=goodsExample.createCriteria();
            criteria.andIdIsNotNull();
            List<Goods> goodsList=goodsMapper.selectByExample(goodsExample);

            List<Goods> newgoodsList=new LinkedList<>();
            for (Goods goods:goodsList){
//          stringBuilder.append(  JSON.toJSONString(goods)+",");
                System.out.println( JSON.toJSONString(goods));
                newgoodsList.add(JSON.parseObject(   JSON.toJSONString(goods),Goods.class)) ;
            }
            System.out.println(1111);
            System.out.println(newgoodsList.size());
    }
}
