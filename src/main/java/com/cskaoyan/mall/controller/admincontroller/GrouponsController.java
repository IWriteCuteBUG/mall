package com.cskaoyan.mall.controller.admincontroller;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.service.adminservice.GrouponsService;
import com.cskaoyan.mall.vo.adminvo.tvo.GrouponsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GrouponsController {

    @Autowired
    GrouponsService grouponsService;

    @RequestMapping("/admin/groupon/listRecord")
    public BaseRespVo getGrouponActive(int page, int limit, String sort, String order){
        int goodsId = 0;
        GrouponsVo grouponsVo = grouponsService.getGrouponActive(page, limit, sort, order, goodsId);
        BaseRespVo<Object> objectBaseRespVo = new BaseRespVo<>();
        objectBaseRespVo.setErrno(0);
        objectBaseRespVo.setData(grouponsVo);
        objectBaseRespVo.setErrmsg("成功");
        return objectBaseRespVo;
    }

}
