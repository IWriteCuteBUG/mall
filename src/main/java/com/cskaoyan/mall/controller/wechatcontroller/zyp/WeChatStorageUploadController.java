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

    @RequestMapping("wx/storage/upload")
    public BaseRespVo fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        BaseRespVo baseRespVo = weChatStorageUploadService.fileupload(file);
        return baseRespVo;
    }
}
