package com.cskaoyan.mall.service.serviceLJW;

import com.cskaoyan.mall.bean.*;

import com.cskaoyan.mall.vo.voLJW.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface MallManagerService {
   //获取type为1的区域
    List<Region> getAllRegions();
    //获取品牌制造商
    BrandManufacturer getBrandManufacturer(int page, int limit, String sort , String order, String id, String name);

    Brand updateBrand(Brand brand);



    BaseRespVo deleteBrand(int id);

 Brand createBrand(Brand brand);

    Storage uploadPhoto(MultipartFile file);

    List<Category> getcategorylist();

    Category createCategory(Category category);

    boolean deleteCategory(Category category);


    //获取订单s
    ReturnOrders getOrders(int page, int limit, String sort, String order, String orderStatusArray, String userId, String orderSn);

    ReturnData getissues(int page, int limit, String sort, String order, String question);

    Issue createIssue(Issue issue);

    Issue updateIssue(Issue issue);

    void deleteIssue(Issue issue);

    ReturnData<Keyword> getKeywords(int page, int limit, String sort, String order, String keyword, String url);

    Keyword createKeyword(Keyword keyword);

    void deleteKeyword(int id);

    Keyword updateKeyword(Keyword keyword);



    List<Lable> getLabel();

    Category updateCategory(Category category);

    OrderDetail getOrderDetail(int orderid);
}
