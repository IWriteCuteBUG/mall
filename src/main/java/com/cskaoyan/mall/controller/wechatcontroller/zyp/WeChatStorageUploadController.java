package com.cskaoyan.mall.controller.wechatcontroller.zyp;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.config.AliyunConfig;
import com.cskaoyan.mall.config.MallOssConfig;
import com.cskaoyan.mall.service.wechatservice.zyp.WeChatStorageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
public class WeChatStorageUploadController {
    @Autowired
    WeChatStorageUploadService weChatStorageUploadService;

//  前台的文件上传，用了白嫖的阿里云



    @RequestMapping("wx/storage/upload")
    public BaseRespVo fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        BaseRespVo baseRespVo = weChatStorageUploadService.fileupload(file);
        return baseRespVo;
    }

//    goodscount不知道有啥用的接口
    @RequestMapping("wx/cart/goodscount")
    public BaseRespVo goodsCount() throws IOException {
        Integer id = 1;
        BaseRespVo baseRespVo = weChatStorageUploadService.goodsCount(id);
        return baseRespVo;
    }


}
