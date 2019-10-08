package com.cskaoyan.mall.service.wechatservice.tangsong.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Brand;
import com.cskaoyan.mall.bean.BrandExample;
import com.cskaoyan.mall.mapper.BrandMapper;
import com.cskaoyan.mall.service.wechatservice.tangsong.WeChatBrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class WeChatBrandServiceImpl implements WeChatBrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public BaseRespVo queryBrandList(int page, int size) {
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andNameIsNotNull();
        PageHelper.startPage(page, size);
        List<Brand> brands = brandMapper.selectByExample(brandExample);
        int total = brands.size()/size;
        HashMap<String, Object> map = new HashMap<>();
        map.put("totalPages",total);
        map.put("brandList",brands);
        BaseRespVo ok = BaseRespVo.ok(map);
        return ok;
    }

    @Override
    public BaseRespVo queryBrandInfo(int id) {
        BrandExample brandExample = new BrandExample();
        brandExample.createCriteria().andIdEqualTo(id);
        List<Brand> brands = brandMapper.selectByExample(brandExample);
        HashMap<String, Object> map = new HashMap<>();
        map.put("brand",brands.get(0));
        BaseRespVo ok = BaseRespVo.ok(map);
        return ok;
    }
}
