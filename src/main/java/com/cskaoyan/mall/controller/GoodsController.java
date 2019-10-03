package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.exception.InsertException;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.util.fffUtils.ReturnUtils;
import com.cskaoyan.mall.vo.goodsmanagervo.CatAndBrand;
import com.cskaoyan.mall.vo.goodsmanagervo.CommentListVo;
import com.cskaoyan.mall.vo.goodsmanagervo.GoodsDetail;
import com.cskaoyan.mall.vo.goodsmanagervo.GoodsListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /**
     * 新增商品
     * @param goodsDetail
     * @return
     */
    @RequestMapping("admin/goods/create")
    public BaseRespVo addGoods(@RequestBody GoodsDetail goodsDetail){
        try {
           goodsService.addGoods(goodsDetail);
        } catch (InsertException e) {
            e.printStackTrace();
            return ReturnUtils.fail(null,e.getCustomMsg());
        }
        return ReturnUtils.ok(null, "成功");
    }

    /**
     * 更新商品信息
     * @param goodsDetail
     * @return
     */
    @RequestMapping("admin/goods/update")
    public BaseRespVo updateGoods(@RequestBody GoodsDetail goodsDetail){
        goodsService.updateGoods(goodsDetail);
        return ReturnUtils.ok(null, "成功");
    }

    /**
     * 分页按条件查询商品信息
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @return goodsListVoBaseRespVo
     */
    @RequestMapping("admin/goods/list")
    public BaseRespVo<GoodsListVo<Goods>> queryGoodsList(int page, int limit, String sort, String order, String goodsSn, String name){
        BaseRespVo<GoodsListVo<Goods>> goodsListVoBaseRespVo = goodsService.queryGoodsList(page, limit, sort, order, goodsSn, name);
        return goodsListVoBaseRespVo;
    }


    /**
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @param userId
     * @param valueId
     * @return
     */
    @RequestMapping("admin/comment/list")
    public BaseRespVo<CommentListVo<Comment>> queryCommentList(int page, int limit, String sort, String order, Integer userId, Integer valueId){
        BaseRespVo<CommentListVo<Comment>> commentListVoBaseRespVo = goodsService.queryCommentList(page, limit, sort, order, userId, valueId);
        return commentListVoBaseRespVo;
    }

    /**
     * 删除指定 ID 评论
     * @param comment
     * @return
     */
    @RequestMapping("admin/comment/delete")
    public BaseRespVo deleteComment(@RequestBody Comment comment){
        int count = goodsService.deleteComment(comment.getId());
        if(count == 1){
            return ReturnUtils.ok(null, "成功");
        }else {
            return ReturnUtils.fail(null, "删除失败，请确认数据库中是否存在该评论");
        }
    }


    /**
     * 删除指定 ID 商品
     * 用事务
     * 还是用逻辑判断
     * ？？？
     * @param goods
     * @return
     */
    @RequestMapping("admin/goods/delete")
    public BaseRespVo deleteGoods(@RequestBody Goods goods){
        int count = goodsService.deleteGoods(goods.getId());
        BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
        if(count == 1){
            baseRespVo.setErrmsg("成功");
            baseRespVo.setErrno(0);
            return baseRespVo;
        }else{
            baseRespVo.setErrmsg("删除失败，请确认数据库中是否存在该商品");
            baseRespVo.setErrno(5000);
            return baseRespVo;
        }
    }

    /**
     * 获取获取所有商品种类及其子类
     * 以及所有品牌信息
     * @return
     */
    @RequestMapping("admin/goods/catAndBrand")
    public BaseRespVo<CatAndBrand> queryCatAndBrand(){
        BaseRespVo<CatAndBrand> baseRespVo = goodsService.queryCatAndBrand();
        return baseRespVo;
    }

    /**
     *编辑商品信息前 获得商品当前信息
     * @param id
     * @return
     */
    @RequestMapping("admin/goods/detail")
    public BaseRespVo<GoodsDetail> queryGoodsDetail(int id){
        BaseRespVo<GoodsDetail> baseRespVo = goodsService.queryGoodsDetail(id);
        return baseRespVo;
    }
}
