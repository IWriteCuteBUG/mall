package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.bean.AdExample;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.mapper.AdMapper;
import com.cskaoyan.mall.mapper.StorageMapper;
import com.cskaoyan.mall.properties.ImgProperties;
import com.cskaoyan.mall.service.AdvertService;
import com.cskaoyan.mall.util.AdvertUploadUtils;
import com.cskaoyan.mall.vo.extensionvo.AdvertList;
import com.cskaoyan.mall.vo.extensionvo.AdvertUploadPic;
import com.cskaoyan.mall.vo.extensionvo.ForAdvert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;
import java.util.List;

@Service
public class AdvertServiceImpl implements AdvertService {
    @Autowired
    AdMapper adMapper;

    @Autowired
    StorageMapper storageMapper;

    @Autowired
    ImgProperties imgProperties;

    @Override
    public AdvertList queryAdverts(ForAdvert forAdvert) {
        PageHelper.startPage(forAdvert.getPage(), forAdvert.getLimit());
        String name = forAdvert.getName();
        String content = forAdvert.getContent();
        List<Ad> ads;
        AdExample adExample = new AdExample();
        AdExample.Criteria criteria = adExample.createCriteria();
        if (name == null && content == null) {
            ads = adMapper.queryAds();
        }
        if(name != null){
            if (content != null) {
                criteria = criteria.andContentLike("%"+content+"%");
            }
            criteria.andNameLike("%"+name+"%");
        }
        if (content != null && name == null) {
            criteria.andContentLike("%"+content+"%");
        }
        ads = adMapper.selectByExample(adExample);
        PageInfo<Ad> adPageInfo = new PageInfo<>();
        long total = adPageInfo.getTotal();
        AdvertList advertList = new AdvertList();
        advertList.setTotal(total);
        advertList.setItems(ads);
        return advertList;
    }

    /**
     * 图片上传
     *
     * @param request
     * @param name
     * @param filename
     * @param myfile
     * @return
     * @throws IOException
     */
    @Override
    public BaseRespVo uploadPic(HttpServletRequest request, MultipartFile file) throws IOException {
//       获取当前服务器下的文件夹
//        String localUpload = request.getServletContext().getRealPath("/static/img/");
        String localUpload = "D:/static/img/";
//        进行文件上传，并返回文件的部分路径
        String uploadName = AdvertUploadUtils.upload(file, localUpload);
//      获取本机IP
//        String advert = InetAddress.getLocalHost().toString();
        String advert = imgProperties.getAdvert();
//        生成Storage对象
        Storage storage = new Storage();
//        获取现在的日期
        Date date = new Date();
//        获取文件大小
        int size = (int) file.getSize();
//      key
        storage.setKey("mykey");
        storage.setName(file.getOriginalFilename());
//      type
        storage.setType("jpg");
        storage.setSize(size);
        storage.setUrl(advert + "/img" + uploadName);
        storage.setAddTime(date);
        storage.setUpdateTime(date);
        storage.setDeleted(false);
        int insert = storageMapper.insertSelective(storage);
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk(storage);
        return baseRespVo;
    }

}
