package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Comment;
import com.cskaoyan.mall.bean.Goods;
import com.cskaoyan.mall.exception.InsertException;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.util.fffUtils.ReturnUtils;
import com.cskaoyan.mall.vo.goodsmanagervo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
     * @return goodsListVoBaseRespVo
     */
    @RequestMapping("admin/goods/list")
    public BaseRespVo<GoodsListVo<Goods>> queryGoodsList( ForQueryGoods forQueryGoods){
        BaseRespVo<GoodsListVo<Goods>> goodsListVoBaseRespVo = goodsService.queryGoodsList(forQueryGoods);
        return goodsListVoBaseRespVo;
    }

    /**
     * 分页按条件查询商品评论
     * @return
     */
    @RequestMapping("admin/comment/list")
    public BaseRespVo<CommentListVo<Comment>> queryCommentList(@Valid ForQueryComments forQueryComments,
                                                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            BaseRespVo<CommentListVo<Comment>> baseRespVo = new BaseRespVo<>();
            baseRespVo.setErrmsg(defaultMessage);
            baseRespVo.setErrno(402);
            return baseRespVo;
        }
        BaseRespVo<CommentListVo<Comment>> commentListVoBaseRespVo = goodsService.queryCommentList(forQueryComments);
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
     * @param goods
     * @return
     */
    @RequestMapping("admin/goods/delete")
    public BaseRespVo deleteGood(@RequestBody Goods goods){
        goodsService.deleteGood(goods.getId());
        return ReturnUtils.ok(null, "成功");
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
     *编辑商品信息前
     * 获得商品当前信息
     * @param id
     * @return
     */
    @RequestMapping("admin/goods/detail")
    public BaseRespVo<GoodsDetail> queryGoodsDetail(int id){
        BaseRespVo<GoodsDetail> baseRespVo = goodsService.queryGoodsDetail(id);
        return baseRespVo;
    }
}
