package com.cskaoyan.mall.service.wechatservice.sjb;

import com.cskaoyan.mall.bean.Goods;

import java.util.List;

public interface GoodsServiceSJB {
    List<Goods> queryGoodsByPage(String keyword, int page, int size, String sort, String order, int categoryId);

    Goods getGoodsById(Integer goodsId);
}
