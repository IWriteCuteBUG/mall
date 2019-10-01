package com.cskaoyan.mall.service;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.vo.extensionvo.AdvertList;
import com.cskaoyan.mall.vo.extensionvo.AdvertUploadPic;
import com.cskaoyan.mall.vo.extensionvo.ForAdvert;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface AdvertService {
    AdvertList queryAdverts(ForAdvert forAdvert);

    BaseRespVo uploadPic(HttpServletRequest request, MultipartFile myfile) throws IOException;

}
