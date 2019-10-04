package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.bean.Ad;
import com.cskaoyan.mall.bean.AdExample;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.mapper.AdMapper;
import com.cskaoyan.mall.mapper.StorageMapper;
import com.cskaoyan.mall.service.AdvertService;
import com.cskaoyan.mall.utils.AdvertUploadUtils;
import com.cskaoyan.mall.vo.extensionvo.FromAdvert;
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

    /*@Autowired
    ImgProperties imgProperties;*/

//    显示广告
    @Override
    public BaseRespVo queryAdverts(FromAdvert forAdvert) {
        String order = forAdvert.getOrder();
        String orderBy = forAdvert.getSort() + "  " + order;
        PageHelper.startPage(forAdvert.getPage(), forAdvert.getLimit(), orderBy);
        String name = forAdvert.getName();
        String content = forAdvert.getContent();
        List<Ad> ads;
        AdExample adExample = new AdExample();
        AdExample.Criteria criteria = adExample.createCriteria();
        /*if (name == null && content == null) {
            ads = adMapper.queryAds();
        }*/
        if(name != null){
            criteria = criteria.andNameLike("%" + name + "%");
        }
        if (content != null) {
            criteria.andContentLike("%"+content+"%");
        }
        ads = adMapper.selectByExample(adExample);
        PageInfo<Ad> adPageInfo = new PageInfo<>(ads);
        return BaseRespVo.baseRespListOk((int) adPageInfo.getTotal(),ads);
    }

    /**
     * 图片上传
     * @param request
     * @param file
     * @return
     * @throws IOException
     */
    @Override
    public BaseRespVo uploadPic(HttpServletRequest request, MultipartFile file) throws IOException {
//       获取当前服务器下的文件夹
//        String localUpload = request.getServletContext().getRealPath("/static/img/");
        String localUpload = "C:/static/img/";
//        进行文件上传，并返回文件的部分路径
        String uploadName = AdvertUploadUtils.upload(file, localUpload);
//      获取本机IP
        String myIp = InetAddress.getLocalHost().toString();
        int iIP = myIp.lastIndexOf("/");
        String ipSubstring = myIp.substring(0, iIP + 1);
        myIp = myIp.replace(ipSubstring, "");
//        String advert = imgProperties.getAdvert();
//        生成Storage对象
        Storage storage = new Storage();
//        获取现在的日期
        Date date = new Date();
//        获取文件大小
        int size = (int) file.getSize();
//      获取文件key值
        int i = uploadName.lastIndexOf("/");
        String substring = uploadName.substring(0, i + 1);
        String key = uploadName.replace(substring, "");
        storage.setKey(key);
        storage.setName(file.getOriginalFilename());
//      获取文件类型
        String contentType = file.getContentType();
        storage.setType(contentType);
        storage.setSize(size);
        storage.setUrl("http://" + myIp + "/img" + uploadName);
        storage.setAddTime(date);
        storage.setUpdateTime(date);
        storage.setDeleted(false);
        int insert = storageMapper.insertSelective(storage);
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk(storage);
        return baseRespVo;
    }

//  添加广告
    @Override
    public BaseRespVo insertAd(Ad ad) {
        Date date = new Date();
        ad.setAddTime(date);
        ad.setUpdateTime(date);
        int i = adMapper.insertSelective(ad);
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk(ad);
        return baseRespVo;
    }

//    修改广告信息
    @Override
    public BaseRespVo updateAdvert(Ad ad) {
        int update = adMapper.updateByPrimaryKey(ad);
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk(ad);
        return baseRespVo;
    }

//  删除广告
    @Override
    public BaseRespVo deleteAdvert(Ad ad) {
        int i = adMapper.deleteByPrimaryKey(ad.getId());
        BaseRespVo baseRespVo = BaseRespVo.baseRespOk("");
        return baseRespVo;
    }

}
