package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.AdvertService;
import com.cskaoyan.mall.vo.extensionvo.FromAdvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public BaseRespVo AdvertList(FromAdvert forAdvert) {
        BaseRespVo baseRespVo = advertService.queryAdverts(forAdvert);
        return baseRespVo;
    }

//    广告删除
    @RequestMapping("ad/delete")
    public BaseRespVo AdvertDelete(@RequestBody Ad ad) {
        BaseRespVo baseRespVo = advertService.deleteAdvert(ad);
        return baseRespVo;
    }

//    广告修改
    @RequestMapping("ad/update")
    public BaseRespVo AdvertUpdate(@RequestBody Ad ad) {
        BaseRespVo baseRespVo = advertService.updateAdvert(ad);
        return baseRespVo;
    }

//    添加广告
    @RequestMapping("ad/create")
    public BaseRespVo AdvertAdd(@RequestBody Ad ad) {
        BaseRespVo baseRespVo = advertService.insertAd(ad);
        return baseRespVo;
    }

//    文件上传
    @RequestMapping("storage/create")
//    HttpServletRequest request , String name, String filename,
    public BaseRespVo uploadPic(HttpServletRequest request , @RequestParam("file") MultipartFile file) throws IOException {
        BaseRespVo baseRespVo = advertService.uploadPic(request,file);
        return baseRespVo;
    }


}
