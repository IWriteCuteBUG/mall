package com.cskaoyan.mall.controller.admincontroller.controllerLJW;

import com.cskaoyan.mall.bean.*;

import com.cskaoyan.mall.util.utiLJW.PicDeleteUtil;
import com.cskaoyan.mall.vo.adminvo.voLJW.BrandManufacturer;
import com.cskaoyan.mall.vo.adminvo.voLJW.OrderDetail;
import com.cskaoyan.mall.vo.adminvo.voLJW.ReturnData;
import com.cskaoyan.mall.service.adminservice.serviceLJW.MallManagerServiceImply;
import com.cskaoyan.mall.util.utiLJW.ReturnUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.System;
import java.util.List;

@RestController
//@RequestBody 接受json
//@ResponseBody 返回json,如果前端没有任何处理会直接显示json字符串在网页
public class MallManager {
    @Autowired
    MallManagerServiceImply mallManager;

    //图片文件删除通用接口
    @RequestMapping("deletepic")
    public String deletepic(HttpServletRequest request){
      String catalog=  request.getParameter("catalog");
      String result=  PicDeleteUtil.delete(catalog);
      return  result;

    }

    //获取区域
    @RequestMapping("admin/region/list")
    public BaseRespVo regionList() {
        BaseRespVo baseRespVo = new BaseRespVo();
        List<Region> regions = mallManager.getAllRegions();
        baseRespVo.setData(regions);
        baseRespVo.setErrno(0);
        baseRespVo.setErrmsg("�ɹ�");


        return baseRespVo;

    }

    //获取品牌列表
    @RequestMapping("admin/brand/list")
    public BaseRespVo getBrandManufacturer(int page, int limit, String sort, String order, String id, String name) {

        System.out.println(name);
        BaseRespVo<BrandManufacturer> brandManufacturerBaseRespVo = new BaseRespVo<>();
        brandManufacturerBaseRespVo.setErrmsg("成功");
        brandManufacturerBaseRespVo.setErrno(0);
        brandManufacturerBaseRespVo.setData(mallManager.getBrandManufacturer(page, limit, sort, order, id, name));

        return brandManufacturerBaseRespVo;

    }

    //修改品牌
    @RequestMapping("admin/brand/update")
    public BaseRespVo updateBrand(@RequestBody Brand brand) {
        Brand newBrand = mallManager.updateBrand(brand);
        return (newBrand == null) ? ReturnUtils.fail(null, "Please make changes before submission. ") : ReturnUtils.ok(newBrand, "修改成功");

    }

    //删除品牌
    @RequestMapping("admin/brand/delete")
    public BaseRespVo deleteBrand(@RequestBody Brand brand) {
      BaseRespVo baseRespVo=  mallManager.deleteBrand(brand.getId());
        System.out.println(baseRespVo.getErrmsg());
        return baseRespVo ;
    }

    //新增商品品牌
    @RequestMapping("admin/brand/create")
    public BaseRespVo createBrand(@RequestBody Brand brand) {
        Brand newbrand = mallManager.createBrand(brand);
        System.out.println(newbrand);
        return ReturnUtils.ok(newbrand, "添加成功");


    }

//    //上传图片
//    @RequestMapping("/admin/storage/create")
//    public BaseRespVo uplaod(HttpServletRequest req, @RequestParam("file") MultipartFile file) {
//        return ReturnUtils.ok(mallManager.uploadPhoto(file), "上传成功");
//    }


    //获取商品种类列表
    @RequestMapping("admin/category/list")
    public BaseRespVo getcategorylist() {
        List<Category> categories = mallManager.getcategorylist();
        return ReturnUtils.ok(categories, "成功");
    }

    //
    @RequestMapping("admin/category/l1")
    public BaseRespVo getLabel() {
        return ReturnUtils.ok(mallManager.getLabel(), "ok");

    }

    //添加商品种类
    @RequestMapping("admin/category/create")
    public BaseRespVo createCategory(@RequestBody Category category) {
        return ReturnUtils.ok(mallManager.createCategory(category), "添加商品种类成功");
    }

    //删除商品种类
    @RequestMapping("admin/category/delete")
    public BaseRespVo deleteCategory(@RequestBody Category category) {
        mallManager.deleteCategory(category);
        return ReturnUtils.ok(null, "成功");
    }

    @RequestMapping("admin/category/update")
    public BaseRespVo updateCategory(@RequestBody Category category) {
        Category newcategory = mallManager.updateCategory(category);
        return ReturnUtils.ok(category, "修改成功");
    }

    //获取订单列表
    @RequestMapping("admin/order/list")
    public BaseRespVo getOrders(int page, int limit, String sort, String order, String orderStatusArray, String userId, String orderSn) {

        Object data = mallManager.getOrders(page, limit, sort, order, orderStatusArray, userId, orderSn);
        return ReturnUtils.ok(data, "ok");
    }

    //获取订单详情
    @RequestMapping("admin/order/detail")
    public BaseRespVo getOrderDetail(int id) {
        OrderDetail orderDetail = mallManager.getOrderDetail(id);
        return ReturnUtils.ok(orderDetail, "成功");
    }


    //获取通用问题
    @RequestMapping("admin/issue/list")
    public BaseRespVo getissues(int page, int limit, String sort, String order, String question) {
        return ReturnUtils.ok(mallManager.getissues(page, limit, sort, order, question), "ok");
    }

    //通用问题编辑
    @RequestMapping("admin/issue/update")
    public BaseRespVo updataIssue(@RequestBody Issue issue) {
        mallManager.updateIssue(issue);
        return ReturnUtils.ok(null, "修改通用问题成功");
    }

    //通用问题删除
    @RequestMapping("admin/issue/delete")
    public BaseRespVo deleteIssue(@RequestBody Issue issue) {
        mallManager.deleteIssue(issue);
        return ReturnUtils.ok(null, "删除成功");
    }

    //通用问题添加
    @RequestMapping("admin/issue/create")
    public BaseRespVo createIssue(@RequestBody Issue issue) {
        Issue newissue = mallManager.createIssue(issue);
        return ReturnUtils.ok(newissue, "添加通用问题成功");
    }


    //获取关键词列表
    @RequestMapping("admin/keyword/list")
    public BaseRespVo getKeywords(int page, int limit, String sort, String order, String keyword, String url) {
        ReturnData returnData = mallManager.getKeywords(page, limit, sort, order, keyword, url);
        System.out.println("returnData是" + returnData);
        return ReturnUtils.ok(returnData, "成功");
    }

    //增加关键词
    @RequestMapping("admin/keyword/create")
    public BaseRespVo createKeyword(@RequestBody Keyword keyword) {
        Keyword newKeyword = mallManager.createKeyword(keyword);
        return ReturnUtils.ok(newKeyword, "添加成功");
    }

    //删除关键词
    @RequestMapping("admin/keyword/delete")
    public BaseRespVo deleteKeyword(int id) {
        mallManager.deleteKeyword(id);
        return ReturnUtils.ok(null, "删除成功");
    }

    //修改关键词
    @RequestMapping("admin/keyword/update")
    public BaseRespVo updateKeyword(Keyword keyword) {
        mallManager.updateKeyword(keyword);
        return ReturnUtils.ok(keyword, "修改成功");
    }


}








