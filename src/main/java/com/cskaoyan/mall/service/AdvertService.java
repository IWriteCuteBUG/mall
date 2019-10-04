package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.vo.extensionvo.AdvertList;
import com.cskaoyan.mall.vo.extensionvo.FromAdvert;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface AdvertService {
    BaseRespVo queryAdverts(FromAdvert forAdvert);

    BaseRespVo uploadPic(HttpServletRequest request, MultipartFile myfile) throws IOException;

    BaseRespVo insertAd(Ad ad);

    BaseRespVo updateAdvert(Ad ad);

    BaseRespVo deleteAdvert(Ad ad);
}
