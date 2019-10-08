package com.cskaoyan.mall.controller.wechatcontroller.tongsong.wechatforgoodscontroller;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.service.adminservice.CountService;
import com.cskaoyan.mall.service.adminservice.GoodsService;
import com.cskaoyan.mall.service.adminservice.serviceSJB.FootprintService;
import com.cskaoyan.mall.service.wechatservice.sjb.CategoryServiceSJB;
import com.cskaoyan.mall.service.wechatservice.sjb.FootprintServiceSJB;
import com.cskaoyan.mall.service.wechatservice.sjb.GoodsServiceSJB;
import com.cskaoyan.mall.service.wechatservice.sjb.SearchHistoryServiceSJB;
import com.cskaoyan.mall.service.wechatservice.tangsong.WechatCateGoryService;
import com.cskaoyan.mall.vo.wechatvo.sjb.GoodsListAndCategoryListVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/wx")
public class WeChatGoodsController {

    @Autowired
    CountService countService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    WechatCateGoryService wechatCateGoryService;

    @Autowired
    CategoryServiceSJB categoryService;

    @Autowired
    FootprintServiceSJB footprintService;

//    @Autowired
//    GoodsServiceSJB goodsService;

    @Autowired
    SearchHistoryServiceSJB searchHistoryService;

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
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));
        BaseRespVo baseRespVo =goodsService.queryGoodsDetailInfo(id);
        Footprint footprint = new Footprint();
        footprint.setUserId(userId);
        footprint.setGoodsId(id);
        footprint.setAddTime(new Date());
        footprint.setUpdateTime(new Date());
        footprint.setDeleted(false);
        int count = footprintService.addFootprintWithoutId(footprint);
        return baseRespVo;
    }

    @RequestMapping("goods/list")
    public BaseRespVo queryGoodsListByCategoryId(GoodsCategoryAndBrand goodsCategoryAndBrand){
        int brandId = goodsCategoryAndBrand.getBrandId();
        int categoryId = goodsCategoryAndBrand.getCategoryId();
        String keyword = goodsCategoryAndBrand.getKeyword();
        BaseRespVo baseRespVo = null;
        int page = goodsCategoryAndBrand.getPage();
        int size = goodsCategoryAndBrand.getSize();
        if (brandId != 0){
            baseRespVo = goodsService.queryGoodsListByBrandId(brandId,page,size);

        } else if (categoryId != 0) {
            baseRespVo =goodsService.queryGoodsListByCategoryId(categoryId,page,size);
        } else if (keyword != null) {
            int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));
            List<Goods> goodsList = goodsService.queryGoodsByPage(keyword, goodsCategoryAndBrand.getPage(), goodsCategoryAndBrand.getSize(), goodsCategoryAndBrand.getSort(), goodsCategoryAndBrand.getOrder(), goodsCategoryAndBrand.getCategoryId());
            List<Category> categoryList = new ArrayList<>();
            for (Goods goods : goodsList) {
                Category category = categoryService.queryCategoryById(goods.getCategoryId());
                if(!categoryList.contains(category)) {
                    categoryList.add(category);
                }
            }
            SearchHistory searchHistory = new SearchHistory();
            searchHistory.setKeyword(keyword);
            searchHistory.setUserId(userId);
            searchHistory.setAddTime(new Date());
            searchHistory.setUpdateTime(new Date());
            searchHistory.setFrom("");
            int count = searchHistoryService.addSearchHistory(searchHistory);
            int size1 = goodsList.size();
            return BaseRespVo.baseRespOk(new GoodsListAndCategoryListVo(goodsList, size1, categoryList));
        }
        return baseRespVo;
    }

    @RequestMapping("goods/related")
    public BaseRespVo queryRelatedGoodsListByGoodsId(int id){
        BaseRespVo baseRespVo =goodsService.queryRelatedGoodsListByGoodsId(id);
        return baseRespVo;
    }

}
