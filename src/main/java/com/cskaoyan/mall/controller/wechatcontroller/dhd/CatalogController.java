package com.cskaoyan.mall.controller.wechatcontroller.dhd;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.wechatservice.dhd.impl.CatalogIndexService;
import com.cskaoyan.mall.service.wechatservice.dhd.impl.CollecionListService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {
    @Autowired
    CatalogIndexService catalogIndexService;
    @RequestMapping("/wx/catalog/index")
    public BaseRespVo catalogIndexInfo(){
        BaseRespVo baseRespVo=catalogIndexService.selectCatalogIndex();
        return baseRespVo;
    }
    @RequestMapping("/wx/catalog/current")
    public BaseRespVo catalogCurrentInfo(int id){
        BaseRespVo baseRespVo=catalogIndexService.selectCurrentlogIndex(id);
        return  baseRespVo;
    }

}
