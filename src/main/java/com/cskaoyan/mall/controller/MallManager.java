package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;

import com.cskaoyan.mall.bean.Region;
import com.cskaoyan.mall.service.MallManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MallManager {
    @Autowired
    MallManagerService mallManager;
     @RequestMapping("admin/region/list")
    public BaseRespVo regionList(){
      BaseRespVo baseRespVo=new BaseRespVo();
         List<Region> regions=mallManager.getAllRegions();
         baseRespVo.setData(regions);
         baseRespVo.setErrno(0);
         baseRespVo.setErrmsg("³É¹¦");
         return baseRespVo;

    }
}
