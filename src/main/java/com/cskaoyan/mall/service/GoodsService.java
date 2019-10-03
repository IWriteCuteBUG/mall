package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.exception.InsertException;
import com.cskaoyan.mall.vo.goodsmanagervo.CatAndBrand;
import com.cskaoyan.mall.vo.goodsmanagervo.CommentListVo;
import com.cskaoyan.mall.vo.goodsmanagervo.GoodsDetail;
import com.cskaoyan.mall.vo.goodsmanagervo.GoodsListVo;

public interface GoodsService {
    BaseRespVo<GoodsListVo<Goods>> queryGoodsList(int page, int limit, String sort, String order, String goodsSn, String name);

    BaseRespVo<CatAndBrand> queryCatAndBrand();

    int deleteGoods(Integer id);

    BaseRespVo<CommentListVo<Comment>> queryCommentList(int page, int limit, String sort, String order, Integer userId, Integer valueId);

    int deleteComment(Integer id);

    BaseRespVo<GoodsDetail> queryGoodsDetail(int id);

    void addGoods(GoodsDetail goodsDetail) throws InsertException;

    void updateGoods(GoodsDetail goodsDetail);
}
