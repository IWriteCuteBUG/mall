package com.cskaoyan.mall.service.wechatservice.sjb.impl;

import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.bean.GoodsExample;
import com.cskaoyan.mall.mapper.GoodsMapper;
import com.cskaoyan.mall.service.wechatservice.sjb.GoodsServiceSJB;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceSJBImplSJB implements GoodsServiceSJB {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryGoodsByPage(String keyword, int page, int size, String sort, String order, int categoryId) {
        PageHelper.startPage(page, size);
        GoodsExample example = new GoodsExample();
        String sortOrder = sort + " " + order;
        example.setOrderByClause(sortOrder);
        List<Goods> goodsList = null;
        if(!(keyword == null || "".equals(keyword.trim()))){
            GoodsExample.Criteria criteria = example.createCriteria();
            criteria.andNameLike("%" + keyword + "%");
        }
        goodsList = goodsMapper.selectByExample(example);
        return goodsList;
    }

    @Override
    public Goods getGoodsById(Integer goodsId) {
        return goodsMapper.selectByPrimaryKey(goodsId);
    }
}
