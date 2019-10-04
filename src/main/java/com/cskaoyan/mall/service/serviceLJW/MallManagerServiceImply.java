package com.cskaoyan.mall.service.serviceLJW;

import com.cskaoyan.mall.bean.*;

import com.cskaoyan.mall.mapper.*;
import com.cskaoyan.mall.util.utiLJW.PhotoUploadUtils;
import com.cskaoyan.mall.util.utiLJW.ReturnUtils;
import com.cskaoyan.mall.vo.voLJW.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.lang.System;
import java.util.Date;
import java.util.List;

@Component
public class MallManagerServiceImply implements MallManagerService {
    @Autowired
    RegionMapper regionMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Region> getAllRegions() {
        RegionExample regionExample = new RegionExample();
        RegionExample.Criteria criteria = regionExample.createCriteria();
        criteria.andTypeEqualTo(Byte.parseByte("1"));
        List<Region> regions = regionMapper.selectByExample(regionExample);

        return regions;
    }


    //获取商品的品牌列表
    @Override
    public BrandManufacturer getBrandManufacturer(int page, int limit, String sort, String order, String id, String name) {
        PageHelper.startPage(page, limit);
        BrandExample brandExample = new BrandExample();
        BrandExample.Criteria criteria = brandExample.createCriteria();
        criteria.andIdIsNotNull();
        if (id != null&&!"".equals(id.trim())) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (name != null&&!"".equals(name.trim())) {
            criteria.andNameLike("%" + name + "%");
        }
        brandExample.setOrderByClause(sort + " " + order);
        List<Brand> brands = brandMapper.selectByExample(brandExample);
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        int total = (int) brandPageInfo.getTotal();
        return new BrandManufacturer(total, brands);
    }

    @Override
    public Brand updateBrand(Brand putbrand) {

        Brand brand = brandMapper.selectByPrimaryKey(putbrand.getId());

        if (brandEqual(putbrand, brand)) {
            return null;
        }
        brandMapper.updateByPrimaryKey(putbrand);
        return brand;
    }

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public BaseRespVo deleteBrand(int id) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andGoodsSnEqualTo(String.valueOf(id));
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        //删除品牌所属商品
        StringBuilder goodsname =new StringBuilder("");

        if (!goodsList.isEmpty()) {
            int goodsnum = goodsList.size();
            goodsname.append("旗下" + goodsnum + "件商品：");
            for (Goods goods : goodsList) {
                goodsname.append(goods.getName() + "  ");
                goodsMapper.deleteByPrimaryKey(goods.getId());
            }
            goodsname.append("都已删除");
            brandMapper.deleteByPrimaryKey(id);
            System.out.println(goodsname.toString());
            return ReturnUtils.ok(null, goodsname+"");

        } else {
            goodsname.append("旗下无上架商品");
            brandMapper.deleteByPrimaryKey(id);
            System.out.println(goodsname.toString());
            return ReturnUtils.ok(null, goodsname.toString());
        }


    }





    @Override
    public Brand createBrand(Brand brand) {
        brand.setDeleted(false);
        brand.setAddTime(new Date());
        brand.setUpdateTime(new Date());

        brandMapper.insert(brand);

        return brand;
    }

    @Override
    public Storage uploadPhoto(MultipartFile file) {
        Storage storage = new Storage();
        storage.setUrl(PhotoUploadUtils.upload(file));
        return storage;
    }

    @Override
    public List<Category> getcategorylist() {
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andIdIsNotNull();
        criteria.andLevelEqualTo("L1");
        List<Category> categories = categoryMapper.selectByExample(categoryExample);

        for (Category c : categories) {
            List<Category> category = categoryMapper.selectPaAndSonBy(categoryExample);
            c.setChildrens(categoryMapper.selectPaAndSonBy(categoryExample));
        }
        return categories;
    }

    //新增种类
    @Override
    public Category createCategory(Category category) {
        categoryMapper.insert(category);
        category.setAddTime(new Date());
        category.setUpdateTime(new Date());

        return category;
    }


    private boolean brandEqual(Brand a, Brand b) {
        System.out.println("a是" + a);
        System.out.println("b是" + b);
//        System.out.println(a.equals(b));
//        return a.equals(b);
        if (!a.getDesc().equals(b.getDesc())) {
            return false;
        } else if (!a.getName().equals(b.getName())) {
            return false;
        } else if (a.getFloorPrice().intValue() != b.getFloorPrice().intValue()) {
            return false;
        } else if (!a.getPicUrl().equals(b.getPicUrl())) {
            return false;
        }
        return true;


    }

    //删除种类
    @Override
    public boolean deleteCategory(Category category) {
        categoryMapper.deleteByPrimaryKey(category.getId());
        CategoryExample deletecategory = new CategoryExample();
        CategoryExample.Criteria criteria = deletecategory.createCriteria();
        criteria.andPidEqualTo(category.getPid());
        categoryMapper.deleteByExample(deletecategory);
        return true;

    }

    //获取订单s
    @Override
    public ReturnOrders getOrders(int page, int limit, String sort, String order, String orderStatusArray, String userId, String orderSn) {
        PageHelper.startPage(page, limit);

        OrderExample OrderExample = new OrderExample();
        OrderExample.Criteria criteria = OrderExample.createCriteria();
        criteria.andIdNotEqualTo(-1);
        if (orderStatusArray != null) {
            criteria.andOrderStatusEqualTo(Short.valueOf(orderStatusArray));
        }
        System.out.println(userId + 11);
        if (userId != null) {
            System.out.println(Integer.valueOf(userId));
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (orderSn != null) {
            criteria.andOrderSnEqualTo(orderSn);
        }
        OrderExample.setOrderByClause(sort + " " + order);
        List<Order> orders = orderMapper.selectByExample(OrderExample);
        PageInfo<Order> OrderPageInfo = new PageInfo<>(orders);
        int total = (int) OrderPageInfo.getTotal();
        return new ReturnOrders(total, orders);

    }


    @Autowired
    IssueMapper issueMapper;

    //获取问题列表
    @Override
    public ReturnData getissues(int page, int limit, String sort, String order, String question) {
        PageHelper.startPage(page, limit);

        IssueExample issueExample = new IssueExample();
        IssueExample.Criteria criteria = issueExample.createCriteria();
        criteria.andIdIsNotNull();
        if (question != null) {
            criteria.andQuestionLike("%" + question + "%");
        }

        issueExample.setOrderByClause(sort + " " + order);
        List<Issue> Issues = issueMapper.selectByExample(issueExample);
        PageInfo<Issue> IssuePageInfo = new PageInfo<>(Issues);
        int total = (int) IssuePageInfo.getTotal();
        return new ReturnData(total, Issues);

    }

    @Override
    public Issue createIssue(Issue issue) {

        issueMapper.insert(issue);
        issue.setAddTime(new Date());
        issue.setUpdateTime(new Date());
        return issue;

    }

    @Override
    public Issue updateIssue(Issue issue) {
        issue.setUpdateTime(new Date());
        issueMapper.updateByPrimaryKey(issue);

        return issue;
    }

    @Override
    public void deleteIssue(Issue issue) {
        issueMapper.deleteByPrimaryKey(issue.getId());
    }


    @Autowired
    KeywordMapper keywordMapper;

    //获取关键词列表
    @Override
    public ReturnData<Keyword> getKeywords(int page, int limit, String sort, String order, String keyword, String url) {
        PageHelper.startPage(page, limit);

        KeywordExample KeywordExample = new KeywordExample();
        KeywordExample.Criteria criteria = KeywordExample.createCriteria();
        criteria.andIdIsNotNull();
        if (keyword != null) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        if (url != null) {
            criteria.andUrlLike("%" + url + "%");
        }

        KeywordExample.setOrderByClause(sort + " " + order);
        List<Keyword> keywords = keywordMapper.selectByExample(KeywordExample);
        PageInfo<Keyword> keywordPageInfo = new PageInfo<>(keywords);
        int total = (int) keywordPageInfo.getSize();
        return new ReturnData(total, keywords);

    }

    //创建关键词
    @Override
    public Keyword createKeyword(Keyword keyword) {
        keyword.setSortOrder(100);
        keywordMapper.insert(keyword);
        System.out.println("keyword.getId()" + keyword.getId());
        return keywordMapper.selectByPrimaryKey(keyword.getId());

    }

    @Override
    public void deleteKeyword(int id) {
        keywordMapper.deleteByPrimaryKey(id);

    }

    @Override
    public Keyword updateKeyword(Keyword keyword) {
        keywordMapper.updateByPrimaryKey(keyword);
        return keyword;
    }

    //获取商品标签
    @Override
    public List<Lable> getLabel() {
        List<Lable> lables = categoryMapper.selectLabel();
        return lables;
    }

    //更新商品种类
    @Override
    public Category updateCategory(Category category) {
        category.setUpdateTime(new Date());
        categoryMapper.updateByPrimaryKey(category);
        return category;
    }

    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Autowired
    UserMapper userMapper;


    //获取订单详情
    @Override
    public OrderDetail getOrderDetail(int orderid) {
        //获取订单商品列表
        OrderGoodsExample orderGoodsExample = new OrderGoodsExample();
        OrderGoodsExample.Criteria criteria = orderGoodsExample.createCriteria();
        criteria.andGoodsIdEqualTo(orderid);
        List<OrderGoods> orderGoods = orderGoodsMapper.selectByExample(orderGoodsExample);
//获取订单
        Order order = orderMapper.selectByPrimaryKey(orderid);
        //获取用户
        int userid = order.getUserId();
        User user = userMapper.selectByPrimaryKey(userid);


        return new OrderDetail(orderGoods, user, order);
    }
}
