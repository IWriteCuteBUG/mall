package com.cskaoyan.mall.controller.controllerSJB;


import com.cskaoyan.mall.service.serviceSJB.FootprintService;
import com.cskaoyan.mall.vo.voSJB.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/footprint")
public class FootprintController {

    @Autowired
    FootprintService footprintService;
    @RequestMapping("list")
    public FootprintListVo list(int page, int limit, String userId, String goodsId, String sort, String order){
        FootprintListAndTotalVo vo = footprintService.queryFootprintsByPage(page, limit, userId, goodsId, sort, order);
        return new FootprintListVo(0, new DataForFootprintListVo(vo.getTotal(), vo.getFootprintList()), "no error");
    }
}
