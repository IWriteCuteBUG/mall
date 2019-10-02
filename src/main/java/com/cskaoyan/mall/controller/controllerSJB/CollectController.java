package com.cskaoyan.mall.controller.controllerSJB;

import com.cskaoyan.mall.service.serviceSJB.CollectService;
import com.cskaoyan.mall.vo.voSJB.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/collect")
public class CollectController {

    @Autowired
    CollectService collectService;
    @RequestMapping("list")
    public CollectListVo list(int page, int limit, String userId, String valueId, String sort, String order){
        CollectListAndTotalVo vo = collectService.queryCollectsByPage(page, limit, userId, valueId, sort, order);
        return new CollectListVo(0, new DataForCollectListVo(vo.getTotal(), vo.getCollectList()), "no error");
    }
}
