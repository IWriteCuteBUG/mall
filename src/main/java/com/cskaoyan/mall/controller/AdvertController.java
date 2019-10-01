package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.AdvertService;
import com.cskaoyan.mall.vo.extensionvo.AdvertList;
import com.cskaoyan.mall.vo.extensionvo.AdvertUploadPic;
import com.cskaoyan.mall.vo.extensionvo.ForAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("admin")
public class AdvertController {
    @Autowired
    AdvertService advertService;

//    广告列表显示
    @RequestMapping("ad/list")
    public BaseRespVo AdvertList(ForAdvert forAdvert) {
        AdvertList advertListVo = advertService.queryAdverts(forAdvert);
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk(advertListVo);
        return baseRespVo;
    }

//    广告删除
    @RequestMapping("ad/delete")
    public BaseRespVo AdvertDelete(ForAdvert forAdvert) {
        /*AdvertList advertListVo = advertService.queryAdverts(page, limit, add_time, order);
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk(advertListVo);*/
        return null;
    }
    @RequestMapping("ad/update")
    public BaseRespVo AdvertUpdate(ForAdvert forAdvert) {
        /*AdvertList advertListVo = advertService.queryAdverts(page, limit, add_time, order);
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk(advertListVo);*/
        return null;
    }


//    文件上传
    @RequestMapping("storage/create")
//    HttpServletRequest request , String name, String filename,
    public BaseRespVo uploadPic(HttpServletRequest request , @RequestParam("file") MultipartFile file) throws IOException {
        BaseRespVo baseRespVo = advertService.uploadPic(request,file);
        return baseRespVo;
    }


}
