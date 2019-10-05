package com.cskaoyan.mall.service.adminservice;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.exception.InsertException;
import com.cskaoyan.mall.vo.adminvo.goodsmanagervo.*;

public interface GoodsService {
    BaseRespVo<GoodsListVo<Goods>> queryGoodsList(ForQueryGoods forQueryGoods);

    BaseRespVo<CatAndBrand> queryCatAndBrand();

    BaseRespVo<CommentListVo<Comment>> queryCommentList(ForQueryComments forQueryComments);

    int deleteComment(Integer id);

    BaseRespVo<GoodsDetail> queryGoodsDetail(int id);

    void addGoods(GoodsDetail goodsDetail) throws InsertException;

    void updateGoods(GoodsDetail goodsDetail);

    void deleteGood(Integer id);

    BaseRespVo queryAllGoodsInfo();
}
