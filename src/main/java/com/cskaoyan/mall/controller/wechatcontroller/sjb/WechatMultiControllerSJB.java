package com.cskaoyan.mall.controller.wechatcontroller.sjb;

import com.cskaoyan.mall.bean.*;
import com.cskaoyan.mall.service.wechatservice.sjb.*;


import com.cskaoyan.mall.vo.wechatvo.sjb.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class WechatMultiControllerSJB {

    @Autowired
    GoodsServiceSJB goodsService;

    @Autowired
    CategoryServiceSJB categoryService;

    @Autowired
    KeywordServiceSJB keywordService;

    @Autowired
    AddressServiceSJB addressService;

    @Autowired
    RegionServiceSJB regionService;

    @Autowired
    FootprintServiceSJB footprintService;

    @Autowired
    SearchHistoryServiceSJB searchHistoryService;

    @Autowired
    UserServiceSJB userService;

    @Autowired
    FeedbackServiceSJB feedbackService;

    @Autowired
    CommentServiceSJB commentService;


//    @RequestMapping("wx/goods/list")
    @ResponseBody
    public BaseRespVo goodsList(@Valid GoodsSearchListReqVo reqVo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            String field = fieldError.getField();
            return BaseRespVo.baseRespErr(106, field + ": " + defaultMessage);
        }
        String keyword = reqVo.getKeyword();
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));
        List<Goods> goodsList = goodsService.queryGoodsByPage(keyword, reqVo.getPage(), reqVo.getSize(), reqVo.getSort(), reqVo.getOrder(), reqVo.getCategoryId());
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
        searchHistory.setFrom(null);
        int count = searchHistoryService.addSearchHistory(searchHistory);
        int size = goodsList.size();
        return BaseRespVo.baseRespOk(new GoodsListAndCategoryListVo(goodsList, size, categoryList));
    }

    @RequestMapping("wx/search/helper")
    @ResponseBody
    public BaseRespVo searchHelper(String keyword){
        return BaseRespVo.baseRespOk(null);
    }

    @RequestMapping("wx/search/index")
    @ResponseBody
    public BaseRespVo searchIndex(){
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));
        //int userId = 1;
        SearchIndexVo data = new SearchIndexVo();
        Keyword defaultKeyword = keywordService.getDefaultKeyword();
        List<SearchHistory> historyKeywordList = searchHistoryService.querySearchHistoryByUserId(userId);
        List<Keyword> hotKeywordList = keywordService.getHotKeywordList();
        List<StringToolVo> list = new ArrayList<>();
        for (SearchHistory searchHistory : historyKeywordList) {
            list.add(new StringToolVo(searchHistory.getKeyword()));
        }
        data.setDefaultKeyword(defaultKeyword);
        data.setHistoryKeywordList(list);
        data.setHotKeywordList(hotKeywordList);
        return BaseRespVo.baseRespOk(data);
    }

    @RequestMapping("wx/address/list")
    @ResponseBody
    public BaseRespVo addressList(){
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));
        //int userId = 1;
        List<Address> addressList = addressService.getAddressesByUserId(userId);
        List<AddressListWechatVo> data = new ArrayList<>();
        for (Address address : addressList) {
            data.add(new AddressListWechatVo(address.getAddress(), address.getId(), address.getIsDefault(), address.getMobile(), address.getName()));
        }
        return BaseRespVo.baseRespOk(data);
    }

    @RequestMapping("wx/address/detail")
    @ResponseBody
    public BaseRespVo addressDetail(int id){
        Address address = addressService.getAddressById(id);
        int areaId = address.getAreaId();
        String areaName = regionService.queryNameById(areaId);
        int cityId = address.getCityId();
        String cityName = regionService.queryNameById(cityId);
        int provinceId = address.getProvinceId();
        String provinceName = regionService.queryNameById(provinceId);
        AddressDetailVo data = new AddressDetailVo(address.getAddress(), areaId, areaName,
                cityId, cityName, address.getId(), address.getIsDefault(), address.getMobile(),
                address.getName(), provinceId, provinceName);
        return BaseRespVo.baseRespOk(data);
    }

    @RequestMapping("wx/address/save")
    @ResponseBody
    public BaseRespVo addressSave(@RequestBody AddressSaveReqVo vo){
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));
        //int userId = 1;
        Address address = new Address();
        address.setUserId(userId);
        address.setAddress(vo.getAddress());
        address.setProvinceId(vo.getProvinceId());
        address.setAreaId(vo.getAreaId());
        address.setCityId(vo.getCityId());
        address.setId(vo.getId());
        address.setIsDefault(vo.getIsDefault());
        address.setMobile(vo.getMobile());
        address.setName(vo.getName());
        address.setUpdateTime(new Date());
        int count = 0;
        if(vo.getId() != 0){
            count = addressService.updateAddressById(address);
        }
        if(vo.getId() == 0){
            count = addressService.addAddress(address);
        }
        if(count == 1){
            return BaseRespVo.baseRespOk(vo.getId());
        } else {
            return BaseRespVo.baseRespErr(1, "错误");
        }
    }

    @RequestMapping("wx/address/delete")
    @ResponseBody
    public BaseRespVo addressDelete(@RequestBody AddressDeleteVo vo){
        int id = vo.getId();
        int count = addressService.addressDelete(id);
        if(count == 1){
            return BaseRespVo.baseRespOk(null);
        } else {
            return BaseRespVo.baseRespErr(2, "错误");
        }
    }

    @RequestMapping("wx/footprint/list")
    @ResponseBody
    public BaseRespVo footprintList(int page, int size){
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));
        //int userId = 1;
        List<FootprintListToolVo> footprintList = footprintService.queryFootprintAndGoodsMultiById(page, size, userId);
        int totalPages = (footprintService.queryTotalFootprintByUserId(userId) / size) + 1;
        FootprintAndGoodsDataToolVo<FootprintListToolVo> dataToolVo= new FootprintAndGoodsDataToolVo<>(footprintList, totalPages);
        return BaseRespVo.baseRespOk(dataToolVo);
    }

    @RequestMapping("wx/feedback/submit")
    @ResponseBody
    public BaseRespRepVo feedbackSubmit(@RequestBody FeedbackSubmitReqVo vo){
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));
        //int userId = 1;
        String username = userService.getUsernameByUserId(userId);
        Feedback feedback = new Feedback();
        feedback.setUserId(userId);
        feedback.setUsername(username);
        feedback.setContent(vo.getContent());
        feedback.setFeedType(vo.getFeedType());
        feedback.setHasPicture(vo.isHasPicture());
        feedback.setMobile(vo.getMobile());
        feedback.setPicUrls(vo.getPicUrls());
        feedback.setStatus(0);
        feedback.setAddTime(new Date());
        feedback.setUpdateTime(new Date());
        feedback.setDeleted(false);
        int count = feedbackService.insertFeedback(feedback);
        if(count == 1){
            return new BaseRespRepVo("成功", 0);
        } else {
            return new BaseRespRepVo("错误", 1);
        }
    }

    @RequestMapping("wx/comment/post")
    @ResponseBody
    public BaseRespVo commentPost(@RequestBody CommentPostReqVo vo){
        Comment comment = new Comment();
        int userId = Integer.parseInt(String.valueOf(SecurityUtils.getSubject().getSession().getAttribute("userId")));
        //int userId = 1;
        comment.setContent(vo.getContent());
        comment.setHasPicture(vo.isHasPicture());
        comment.setPicUrls(vo.getPicUrls());
        comment.setStar((short) vo.getStar());
        comment.setType((byte)vo.getType());
        comment.setValueId(vo.getValueId());
        comment.setAddTime(new Date());
        comment.setUpdateTime(new Date());
        comment.setUserId(userId);
        int count = commentService.insertComment(comment);
        if(count == 1){
            return BaseRespVo.baseRespOk(comment);
        } else {
            return BaseRespVo.baseRespErr(1, "错误");
        }
    }

    @RequestMapping("wx/comment/list")
    @ResponseBody
    public BaseRespVo commentList(CommentListReqVo vo){
        List<Comment> commentList = commentService.queryCommentsByPage(vo);
        List<CommentAndUserInfoVo> commentAndUserInfoVoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentAndUserInfoVo userInfoVo = new CommentAndUserInfoVo();
            userInfoVo.setAddTime(comment.getAddTime());
            userInfoVo.setContent(comment.getContent());
            userInfoVo.setPicList(Arrays.toString(comment.getPicUrls()).replace("{", "[").replace("}", "]"));
            User user = userService.getUserById(comment.getUserId());
            userInfoVo.setUserInfo(new CommentAndUserInfoToolVo(user.getAvatar(), user.getNickname()));
            commentAndUserInfoVoList.add(userInfoVo);
        }
        CommentListRespDataVo<CommentAndUserInfoVo> data = new CommentListRespDataVo<>();
        data.setCount(commentList.size());
        data.setCurrentPage(vo.getPage());
        data.setData(commentAndUserInfoVoList);
        return BaseRespVo.baseRespOk(data);
    }
}
