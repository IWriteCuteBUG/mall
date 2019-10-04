package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.exception.InsertException;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.service.GoodsService;
import com.cskaoyan.mall.util.fffUtils.ReturnUtils;
import com.cskaoyan.mall.vo.goodsmanagervo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.System;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    GoodsAttributeMapper goodsAttributeMapper;

    @Autowired
    GoodsSpecificationMapper goodsSpecificationMapper;

    @Autowired
    GoodsProductMapper goodsProductMapper;

    @Autowired
    BrandMapper brandMapper;


    @Override
    public void addGoods(GoodsDetail goodsDetail) throws InsertException {
        //逻辑校验
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria goodsCriteria = goodsExample.createCriteria();
        goodsCriteria.andNameEqualTo(goodsDetail.getGoods().getName());
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        if(!(goods.isEmpty())){
            throw new InsertException("error","商品名已经存在");
        }
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andGoodsSnEqualTo(goodsDetail.getGoods().getGoodsSn());
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        if(!(goodsList.isEmpty())){
            throw new InsertException("error","商品编号已经存在");
        }
        Goods good =  goodsDetail.getGoods();
        if(good.getCategoryId() == null){
            throw new InsertException("error","请选择商品所属分类");
        }
        if(good.getBrandId() == null){
            throw new InsertException("error","请选择商品所属品牌商");
        }

        //给 addtime/updatetime/deleted 字段赋值
        Date date = new Date();
        good.setAddTime(date);
        good.setUpdateTime(date);
        good.setDeleted(false);
        //插入商品后，同时获取最近插入商品的 Id
        goodsMapper.insert(good);
        System.out.println(good.getId());
        Integer goodsId = goodsDetail.getGoods().getId();

        List<GoodsAttribute> attributes = goodsDetail.getAttributes();
        for (GoodsAttribute attribute : attributes) {
            attribute.setGoodsId(goodsId);
            attribute.setAddTime(date);
            attribute.setUpdateTime(date);
            attribute.setDeleted(false);
            goodsAttributeMapper.insert(attribute);
        }

        List<GoodsProduct> products = goodsDetail.getProducts();
        for (GoodsProduct product : products) {
            product.setGoodsId(goodsId);
            product.setId(null);
            product.setAddTime(date);
            product.setUpdateTime(date);
            product.setDeleted(false);
            goodsProductMapper.insert(product);
        }

        List<GoodsSpecification> specifications = goodsDetail.getSpecifications();
        for (GoodsSpecification specification : specifications) {
            specification.setGoodsId(goodsId);
            specification.setAddTime(date);
            specification.setDeleted(false);
            specification.setUpdateTime(date);
            goodsSpecificationMapper.insert(specification);
        }
    }

    @Override
    public BaseRespVo<GoodsDetail> queryGoodsDetail(int id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);

        List<Integer> categoryIds = new ArrayList<>();
        if(goods.getCategoryId() != null){
            Category category = categoryMapper.selectIds(goods.getCategoryId());
            categoryIds.add(category.getId());
            categoryIds.add(category.getPid());
        }

        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        GoodsAttributeExample.Criteria attributrCriteria = goodsAttributeExample.createCriteria();
        attributrCriteria.andGoodsIdEqualTo(goods.getId());
        List<GoodsAttribute> attributes = goodsAttributeMapper.selectByExample(goodsAttributeExample);

        GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
        GoodsSpecificationExample.Criteria specificationCriteria = goodsSpecificationExample.createCriteria();
        specificationCriteria.andGoodsIdEqualTo(goods.getId());
        List<GoodsSpecification> specifications = goodsSpecificationMapper.selectByExample(goodsSpecificationExample);

        GoodsProductExample goodsProductExample = new GoodsProductExample();
        GoodsProductExample.Criteria productCriteria = goodsProductExample.createCriteria();
        productCriteria.andGoodsIdEqualTo(goods.getId());
        List<GoodsProduct> goodsProducts = goodsProductMapper.selectByExample(goodsProductExample);

        GoodsDetail goodsDetail = new GoodsDetail();
        goodsDetail.setCategoryIds(categoryIds);
        goodsDetail.setGoods(goods);
        goodsDetail.setAttributes(attributes);
        goodsDetail.setProducts(goodsProducts);
        goodsDetail.setSpecifications(specifications);

        return ReturnUtils.ok(goodsDetail, "成功");
    }

    @Override
    public void updateGoods(GoodsDetail goodsDetail) {
        Date date = new Date();
        goodsDetail.getGoods().setUpdateTime(date);
        goodsMapper.updateByPrimaryKey(goodsDetail.getGoods());

        goodsSpecificationMapper.deleteByPrimaryKey(goodsDetail.getGoods().getId());
        List<GoodsSpecification> specifications = goodsDetail.getSpecifications();
        if(!(specifications.isEmpty())){
            for (GoodsSpecification specification : specifications) {
                specification.setUpdateTime(date);
                goodsSpecificationMapper.insertSelective(specification);
            }
        }

        goodsAttributeMapper.deleteByPrimaryKey(goodsDetail.getGoods().getId());
        List<GoodsAttribute> goodsAttributes = goodsDetail.getAttributes();
        if(!(goodsAttributes.isEmpty())){
            for (GoodsAttribute goodsAttribute : goodsAttributes) {
                goodsAttribute.setUpdateTime(date);
                goodsAttributeMapper.insertSelective(goodsAttribute);
            }
        }

        goodsProductMapper.deleteByPrimaryKey(goodsDetail.getGoods().getId());
        List<GoodsProduct> goodsProducts = goodsDetail.getProducts();
        if(!(goodsProducts.isEmpty())){
            for (GoodsProduct goodsProduct : goodsProducts) {
                goodsProduct.setUpdateTime(date);
                goodsProductMapper.insertSelective(goodsProduct);
            }
        }
    }

    @Override
    public BaseRespVo<GoodsListVo<Goods>> queryGoodsList(int page, int limit, String sort, String order, String goodsSn, String name) {
        PageHelper.startPage(page, limit);
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sort + " " + order);
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if (goodsSn != null && !("".equals(goodsSn.trim()))) {
            criteria.andGoodsSnEqualTo(goodsSn);
        }
        if (name != null && !("".equals(name.trim()))) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goods);
        long total = goodsPageInfo.getTotal();
        GoodsListVo<Goods> goodsListVo = new GoodsListVo<>();
        goodsListVo.setItems(goods);
        goodsListVo.setTotal(total);
        return ReturnUtils.ok(goodsListVo,"成功");
    }

    @Override
    public BaseRespVo<CommentListVo<Comment>> queryCommentList(int page, int limit, String sort, String order, Integer userId, Integer valueId) {
        PageHelper.startPage(page, limit);
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause(sort + " " + order);
        CommentExample.Criteria criteria = commentExample.createCriteria();
        if(userId != null){
            criteria.andUserIdEqualTo(userId);
        }
        if(valueId != null){
            criteria.andValueIdEqualTo(valueId);
        }
        criteria.andDeletedEqualTo(false);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        PageInfo<Comment> commentPageInfo = new PageInfo<>(comments);
        long total = commentPageInfo.getTotal();
        CommentListVo commentListVo = new CommentListVo();
        commentListVo.setTotal(total);
        commentListVo.setItems(comments);
        return ReturnUtils.ok(commentListVo, "成功");
    }


    @Override
    public BaseRespVo<CatAndBrand> queryCatAndBrand() {
        List<ForCatList> forCatLists = categoryMapper.queryCatList();
        List<ForBrandList> forBrandLists = brandMapper.queryBrandList();
        CatAndBrand catAndBrand = new CatAndBrand();
        catAndBrand.setCategoryList(forCatLists);
        catAndBrand.setBrandList(forBrandLists);
        return ReturnUtils.ok(catAndBrand, "成功");
    }

    @Override
    public int deleteComment(Integer id) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setDeleted(true);
        int count = commentMapper.updateByPrimaryKeySelective(comment);
        return count;
    }

    @Override
    @Transactional
    public void deleteGood(Integer id) {
        goodsMapper.deleteByPrimaryKey(id);

        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andValueIdEqualTo(id);
        commentMapper.selectByExample(commentExample);

        GoodsProductExample goodsProductExample = new GoodsProductExample();
        GoodsProductExample.Criteria criteriaP = goodsProductExample.createCriteria();
        criteriaP.andGoodsIdEqualTo(id);
        goodsProductMapper.deleteByExample(goodsProductExample);

        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        GoodsAttributeExample.Criteria criteriaA = goodsAttributeExample.createCriteria();
        criteriaA.andGoodsIdEqualTo(id);
        goodsAttributeMapper.deleteByExample(goodsAttributeExample);

        GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
        GoodsSpecificationExample.Criteria criteriaS = goodsSpecificationExample.createCriteria();
        criteriaS.andGoodsIdEqualTo(id);
        goodsSpecificationMapper.deleteByExample(goodsSpecificationExample);
    }
}