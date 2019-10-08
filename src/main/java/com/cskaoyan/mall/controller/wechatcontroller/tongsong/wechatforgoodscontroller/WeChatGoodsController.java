package com.cskaoyan.mall.controller.wechatcontroller.tongsong.wechatforgoodscontroller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.GoodsCategoryAndBrand;
import com.cskaoyan.mall.service.adminservice.CountService;
import com.cskaoyan.mall.service.adminservice.GoodsService;
import com.cskaoyan.mall.service.wechatservice.tangsong.WechatCateGoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class WeChatGoodsController {

    @Autowired
    CountService countService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    WechatCateGoryService wechatCateGoryService;

    @RequestMapping("goods/count")
    public BaseRespVo countGoods(){
        BaseRespVo baseRespVo =countService.countGoodsNumber();
        return baseRespVo;
    }


    @RequestMapping("goods/category")
    public BaseRespVo queryGoodsCategory(int id){
        BaseRespVo baseRespVo =wechatCateGoryService.queryGoodsCategory(id);
        return baseRespVo;
    }

    @RequestMapping("goods/detail")
    public BaseRespVo queryGoodsDetailInfo(int id){
        BaseRespVo baseRespVo =goodsService.queryGoodsDetailInfo(id);
        return baseRespVo;
    }

    @RequestMapping("goods/list")
    public BaseRespVo queryGoodsListByCategoryId(GoodsCategoryAndBrand goodsCategoryAndBrand){
        int brandId = goodsCategoryAndBrand.getBrandId();
        int categoryId = goodsCategoryAndBrand.getCategoryId();
        int keyword = goodsCategoryAndBrand.getKeyword();
        BaseRespVo baseRespVo = null;
        int page = goodsCategoryAndBrand.getPage();
        int size = goodsCategoryAndBrand.getSize();
        if (brandId != 0){
            baseRespVo = goodsService.queryGoodsListByBrandId(brandId,page,size);

        } else if (categoryId != 0) {
            baseRespVo =goodsService.queryGoodsListByCategoryId(categoryId,page,size);
        } else if (keyword != 0) {

        }
        return baseRespVo;
    }

    @RequestMapping("goods/related")
    public BaseRespVo queryRelatedGoodsListByGoodsId(int id){
        BaseRespVo baseRespVo =goodsService.queryRelatedGoodsListByGoodsId(id);
        return baseRespVo;
    }

}
