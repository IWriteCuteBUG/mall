package com.cskaoyan.mall.controller.wechatcontroller.dhd;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.service.wechatservice.dhd.impl.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionListController {
    @Autowired
    RegionService regionService;
    public BaseRespVo RegionInfo(Region region){
        BaseRespVo baseRespVo=regionService.selectRegionList(region);
        return baseRespVo;
    }
}
