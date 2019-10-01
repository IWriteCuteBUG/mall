package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.ConfigerService;
import com.cskaoyan.mall.service.CountService;
import com.cskaoyan.mall.vo.tvo.ConfigerVoWx;
import com.cskaoyan.mall.vo.tvo.CountVo;
import com.cskaoyan.mall.vo.tvo.IndexVoInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatController {

    @Autowired
    CountService countService;

    @RequestMapping(value = "/admin/stat/user", method = {RequestMethod.GET})
    public BaseRespVo countUserLoginInfo(){
        CountVo countVo = countService.countUserLoginInfo();
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData(countVo);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }

    @RequestMapping(value = "/admin/stat/order", method = {RequestMethod.GET})
    public BaseRespVo countOrderInfo(){
        CountVo countVo = countService.countOrderInfo();
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData(countVo);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }

    @RequestMapping(value = "/admin/stat/goods", method = {RequestMethod.GET})
    public BaseRespVo countGoodsInfo(){
        CountVo countVo = countService.countGoodsInfo();
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData(countVo);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }

    @RequestMapping(value = "/admin/dashboard", method = {RequestMethod.GET})
    public BaseRespVo queryInfoIndex(){
        IndexVoInfo indexVoInfo = countService.queryInfoIndex();
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData(indexVoInfo);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }
}
