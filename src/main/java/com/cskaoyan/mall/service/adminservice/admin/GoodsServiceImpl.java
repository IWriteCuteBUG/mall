package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.exception.InsertException;
import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.service.adminservice.GoodsService;
import com.cskaoyan.mall.util.fffUtils.ReturnUtils;
import com.cskaoyan.mall.vo.adminvo.goodsmanagervo.*;
import com.cskaoyan.mall.vo.wechatvo.tongsong.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.System;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsSpecificationMapper getGoodsSpecificationMapper;

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

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    AdMapper adMapper;

    @Autowired
    TopicMapper topicMapper;

    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Autowired
    IssueMapper issueMapper;

    @Autowired
    CollectMapper collectMapper;

    @Autowired
    GoodsAttributeMapper getGoodsAttributeMapper;


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
    public BaseRespVo<GoodsListVo<Goods>> queryGoodsList(ForQueryGoods forQueryGoods) {
        PageHelper.startPage(forQueryGoods.getPage(), forQueryGoods.getLimit());
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(forQueryGoods.getSort() + " " + forQueryGoods.getOrder());
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if (forQueryGoods.getGoodsSn() != null && !("".equals(forQueryGoods.getGoodsSn().trim()))) {
            criteria.andGoodsSnEqualTo(forQueryGoods.getGoodsSn());
        }
        if (forQueryGoods.getName() != null && !("".equals(forQueryGoods.getName().trim()))) {
            criteria.andNameLike("%" + forQueryGoods.getName() + "%");
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
    public BaseRespVo<CommentListVo<Comment>> queryCommentList(ForQueryComments forQueryComments) {
        PageHelper.startPage(forQueryComments.getPage(), forQueryComments.getLimit());
        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause(forQueryComments.getSort() + " " + forQueryComments.getOrder());
        CommentExample.Criteria criteria = commentExample.createCriteria();
        if(forQueryComments.getUserId() != null){
            criteria.andUserIdEqualTo(forQueryComments.getUserId());
        }
        if(forQueryComments.getValueId() != null){
            criteria.andValueIdEqualTo(forQueryComments.getValueId());
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

    @Override
    public BaseRespVo queryAllGoodsInfo() {
        //querynewgoodsList
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andIsNewEqualTo(true);
        PageHelper.startPage(0,5);
        List<Goods> newgoodsList = goodsMapper.selectByExample(goodsExample);
        //querycoupons(优惠券)
        CouponExample couponExample = new CouponExample();
        couponExample.createCriteria().andNameIsNotNull();
        PageHelper.startPage(0,5);
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        //querygoodscategory
        CategoryExample categoryExample = new CategoryExample();
        categoryExample.createCriteria().andNameIsNotNull();
        PageHelper.startPage(0,5);
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        //grouponList
        List<GoodsVoWeChat> grouponList = goodsMapper.queryGoodsForWeChat();
        //bannerList
        AdExample adExample = new AdExample();
        adExample.createCriteria().andNameIsNotNull();
        List<Ad> banner = adMapper.selectByExample(adExample);
        //brandList
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andNameIsNotNull();
        PageHelper.startPage(0,5);
        List<Brand> brands = brandMapper.selectByExample(brandExample);
        //hotGoodsList
        GoodsExample goodsExample1 = new GoodsExample();
        goodsExample1.createCriteria().andIsHotEqualTo(true);
        PageHelper.startPage(0,5);
        List<Goods> hotGoodsList = goodsMapper.selectByExample(goodsExample1);
        //topicList
        TopicExample topicExample = new TopicExample();
        topicExample.createCriteria().andIdIsNotNull();
        PageHelper.startPage(0,5);
        List<Topic> topicList = topicMapper.selectByExample(topicExample);
        //floorGoodsList categories
        ArrayList<GoodsListOfCategory> floorGoodsList = new ArrayList<>();
        for (Category category : categories) {
            GoodsListOfCategory goodsListOfCategory = new GoodsListOfCategory();
            int categoryId = category.getId();
            goodsListOfCategory.setId(categoryId);
            goodsListOfCategory.setName(category.getName());
            GoodsExample goodsExample2 = new GoodsExample();
            goodsExample2.createCriteria().andCategoryIdEqualTo(categoryId);
            List<Goods> goods1 = goodsMapper.selectByExample(goodsExample2);
            goodsListOfCategory.setGoodsList(goods1);
            floorGoodsList.add(goodsListOfCategory);
        }
        GoodsIndexVo goodsIndexVo = new GoodsIndexVo();
        goodsIndexVo.setNewGoodsList(newgoodsList);
        goodsIndexVo.setBanner(banner);
        goodsIndexVo.setBrandList(brands);
        goodsIndexVo.setCouponList(coupons);
        goodsIndexVo.setFloorGoodsList(floorGoodsList);
        goodsIndexVo.setHotGoodsList(hotGoodsList);
        goodsIndexVo.setTopicList(topicList);
        goodsIndexVo.setChannel(categories);
        goodsIndexVo.setGrouponList(grouponList);
        BaseRespVo<GoodsIndexVo> goodsIndexVoBaseRespVo = new BaseRespVo<>();
        goodsIndexVoBaseRespVo.setData(goodsIndexVo);
        goodsIndexVoBaseRespVo.setErrno(0);
        goodsIndexVoBaseRespVo.setErrmsg("成功");
        return goodsIndexVoBaseRespVo;
    }

    @Override
    public BaseRespVo queryGoodsDetailInfo(int id) {
        //specificationList
        List<GoodsInfomationVo> specificationList = goodsSpecificationMapper.queryspecificationList(id);
        //groupon
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        grouponRulesExample.createCriteria().andGoodsIdEqualTo(id);
        List<GrouponRules> groupon = grouponRulesMapper.selectByExample(grouponRulesExample);
        //issue
        IssueExample issueExample = new IssueExample();
        issueExample.createCriteria().andIdIsNotNull();
        List<Issue> issue = issueMapper.selectByExample(issueExample);
        //userHasCollect
        CollectExample collectExample = new CollectExample();
        collectExample.createCriteria().andValueIdEqualTo(id);
        long userHasCollect = collectMapper.countByExample(collectExample);
        //comments
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andValueIdEqualTo(id);
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        CommentOfGoodsVo comment = new CommentOfGoodsVo();
        comment.setCount(comments.size());
        comment.setDate(comments);
        //attribute
        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        goodsAttributeExample.createCriteria().andGoodsIdEqualTo(id);
        List<GoodsAttribute> attribute = goodsAttributeMapper.selectByExample(goodsAttributeExample);
        //brand
        Brand brand = brandMapper.queryBrandByGoodsId(id);
        //productList
        List<GoodsProduct> productList = goodsProductMapper.queryGoodsProductById(id);
        //info
        Goodss goodss = goodsMapper.queryGoodsContainsGallery(id);

        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();

        HashMap<String, Object> map = new HashMap<>();
        map.put("specificationList",specificationList);
        map.put("groupon",groupon);
        map.put("issue",issue);
        map.put("userHasCollect",userHasCollect);
        map.put("comment",comment);
        map.put("attribute",attribute);
        map.put("brand",brand);
        map.put("productList",productList);
        map.put("info",goodss);
        objectBaseRespVo.setData(map);
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }

    @Override
    public BaseRespVo queryGoodsListByCategoryId(int categoryId, int page, int size) {
        //goodsList
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andCategoryIdEqualTo(categoryId);
        PageHelper.startPage(page, size);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        //filterCategoryList
        ArrayList<Category> categories = new ArrayList<>();
        for (Goods good : goods) {
            CategoryExample categoryExample = new CategoryExample();
            categoryExample.createCriteria().andIdEqualTo(good.getCategoryId());
            List<Category> categories1 = categoryMapper.selectByExample(categoryExample);
            categories.add(categories1.get(0));
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("goodsList",goods);
        map.put("filterCategoryList",categories);
        map.put("count",goods.size());
        BaseRespVo ok = BaseRespVo.ok(map);
        return ok;
    }

    @Override
    public BaseRespVo queryRelatedGoodsListByGoodsId(int goodsId) {
        //goods
        GoodsExample goodsExample = new GoodsExample();
        goodsExample.createCriteria().andIdEqualTo(goodsId);
        List<Goods> goods = goodsMapper.selectByExample(goodsExample);
        Goods goods1 = goods.get(0);
        //relatedGoodsList
        GoodsExample goodsExample1 = new GoodsExample();
        goodsExample1.createCriteria().andCategoryIdEqualTo(goods1.getCategoryId());
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample1);
        HashMap<String, Object> map = new HashMap<>();
        map.put("goodsList",goodsList);
        BaseRespVo ok = BaseRespVo.ok(map);
        return ok;
    }
}
