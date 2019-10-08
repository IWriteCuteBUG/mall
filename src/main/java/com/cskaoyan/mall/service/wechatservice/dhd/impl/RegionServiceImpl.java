package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.bean.RegionExample;
import com.cskaoyan.mall.mapper.RegionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl  implements  RegionService{
    @Autowired
    RegionMapper regionMapper;
    @Override
    public BaseRespVo selectRegionList(Region region) {
        RegionExample regionExample = new RegionExample();
        regionExample.createCriteria().andPidEqualTo(region.getPid());
        List<Region> regions = regionMapper.selectByExample(regionExample);
        BaseRespVo ok = BaseRespVo.ok(regions);
        return ok;
    }
}
