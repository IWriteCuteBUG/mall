package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.GrouponsService;
import com.cskaoyan.mall.vo.tvo.CountVo;
import com.cskaoyan.mall.vo.tvo.GrouponsVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrouponsController {

    @Autowired
    GrouponsService grouponsService;

    @RequestMapping("/admin/groupon/listRecord")
    public BaseRespVo getGrouponActive(int page, int limit, String sort, String order){
        GrouponsVo grouponsVo = grouponsService.getGrouponActive(page, limit, sort, order);
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData(grouponsVo);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }
}
