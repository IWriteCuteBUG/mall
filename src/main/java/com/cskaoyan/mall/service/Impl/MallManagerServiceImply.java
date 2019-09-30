package com.cskaoyan.mall.service.Impl;

import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.bean.RegionExample;
import com.cskaoyan.mall.mapper.RegionMapper;
import com.cskaoyan.mall.service.MallManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MallManagerServiceImply  implements MallManagerService {
   @Autowired
    RegionMapper regionMapper;
    @Override
    public List<Region> getAllRegions() {
       RegionExample regionExample=new RegionExample();
    RegionExample.Criteria criteria=regionExample.createCriteria();
    criteria.andIdNotEqualTo(-1);
  List<Region> regions=  regionMapper.selectByExample(regionExample);

        return regions;
    }
}
