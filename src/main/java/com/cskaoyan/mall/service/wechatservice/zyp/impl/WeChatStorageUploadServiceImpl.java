package com.cskaoyan.mall.service.wechatservice.zyp.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Cart;
import com.cskaoyan.mall.bean.CartExample;
import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.config.AliyunConfig;
import com.cskaoyan.mall.config.MallOssConfig;
import com.cskaoyan.mall.mapper.CartMapper;
import com.cskaoyan.mall.mapper.StorageMapper;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.service.wechatservice.zyp.WeChatStorageUploadService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class WeChatStorageUploadServiceImpl implements WeChatStorageUploadService {
    @Autowired
    AliyunConfig aliyunConfig;
    @Autowired
    MallOssConfig ossConfig;
    @Autowired
    StorageMapper storageMapper;
    @Autowired
    CartMapper cartMapper;
    @Override
    public BaseRespVo fileupload(MultipartFile myfile) throws IOException {
        InputStream inputStream = myfile.getInputStream();
        String bucket = ossConfig.getBucket();
        String endPoint = ossConfig.getEndPoint();
        String accessKeyId = aliyunConfig.getAccessKeyId();
        String accessSecret = aliyunConfig.getAccessSecret();
        OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessSecret);

        String key = myfile.getOriginalFilename();
        char[] chars = key.toCharArray();
        int size = chars.length;
        key = key.substring(size - 20, size);
        ossClient.putObject(new PutObjectRequest(bucket, key, inputStream));
        Storage storage = new Storage();
        storage.setKey(key);
        storage.setName(key);
        storage.setType(myfile.getContentType());
        storage.setSize((int)myfile.getSize());
        Date date = new Date();
        storage.setUrl("https://cskaoyan.oss-cn-beijing.aliyuncs.com/"+key);
        storage.setAddTime(date);
        storage.setUpdateTime(date);
        storage.setDeleted(false);
        storageMapper.insertSelective(storage);
        return BaseRespVo.baseRespOk(storage);
    }


    @Override
    public BaseRespVo goodsCount(Integer id) {
//        int userId = 1;
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if (userId == null) {
            return BaseRespVo.ok(0);
        }
        CartExample cartExample = new CartExample();
        cartExample.createCriteria().andUserIdEqualTo(userId);
        List<Cart> carts = cartMapper.selectByExample(cartExample);
        int size = carts.size();
        return BaseRespVo.ok(size);
    }

}
