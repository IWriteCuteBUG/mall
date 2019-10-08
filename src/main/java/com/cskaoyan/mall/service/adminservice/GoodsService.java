package com.cskaoyan.mall.service.adminservice;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.exception.InsertException;
import com.cskaoyan.mall.vo.adminvo.goodsmanagervo.*;

import java.util.List;

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

    BaseRespVo queryGoodsDetailInfo(int id);

    BaseRespVo queryGoodsListByCategoryId(int categoryId, int page, int size);

    BaseRespVo queryRelatedGoodsListByGoodsId(int goodsId);

    BaseRespVo queryGoodsListByBrandId(int brandId, int page, int size);

    List<Goods> queryGoodsByPage(String keyword, int page, int size, String sort, String order, int categoryId);
}
