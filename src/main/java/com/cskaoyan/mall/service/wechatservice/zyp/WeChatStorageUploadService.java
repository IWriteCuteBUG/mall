package com.cskaoyan.mall.service.wechatservice.zyp;

import com.cskaoyan.mall.bean.BaseRespVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface WeChatStorageUploadService {
    BaseRespVo fileupload(MultipartFile myfile) throws IOException;

    BaseRespVo goodsCount(Integer id);
}
