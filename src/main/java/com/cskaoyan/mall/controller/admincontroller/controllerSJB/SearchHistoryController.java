package com.cskaoyan.mall.controller.admincontroller.controllerSJB;

import com.cskaoyan.mall.service.adminservice.serviceSJB.SearchHistoryService;
import com.cskaoyan.mall.vo.adminvo.voSJB.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/history")
public class SearchHistoryController {
    @Autowired
    SearchHistoryService searchHistoryService;
    @RequestMapping("list")
    public SearchHistoryListVo list(int page, int limit, String userId, String keyword, String sort, String order){
        SearchHistoryListAndTotalVo vo = searchHistoryService.querySearchHistorysByPage(page, limit, userId, keyword, sort, order);
        return new SearchHistoryListVo(0, new DataForSearchHistoryListVo(vo.getTotal(), vo.getSearchHistoryList()), "no error");
    }
}
