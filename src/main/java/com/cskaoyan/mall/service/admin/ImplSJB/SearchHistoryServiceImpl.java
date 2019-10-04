package com.cskaoyan.mall.service.admin.ImplSJB;

import com.cskaoyan.mall.bean.SearchHistory;
import com.cskaoyan.mall.bean.SearchHistoryExample;
import com.cskaoyan.mall.mapper.SearchHistoryMapper;
import com.cskaoyan.mall.service.serviceSJB.SearchHistoryService;
import com.cskaoyan.mall.vo.voSJB.SearchHistoryListAndTotalVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {

    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    @Override
    public SearchHistoryListAndTotalVo querySearchHistorysByPage(int page, int limit, String userId, String keyword, String sortcolnum, String order) {
        PageHelper.startPage(page, limit);
        SearchHistoryExample example = new SearchHistoryExample();
        String sortOrder = sortcolnum + " " + order;
        example.setOrderByClause(sortOrder);
        List<SearchHistory> searchHistoryList = null;
        int total = 0;
        int uid = 0;
        SearchHistoryExample.Criteria criteria = example.createCriteria();
        if(!(userId == null || "".equals(userId.trim()))){
            uid = Integer.parseInt(userId);
        }
        if(uid != 0){
            criteria.andUserIdEqualTo(uid);
        }
        if(!(keyword == null || "".equals(keyword.trim()))){
            criteria.andKeywordLike("%" + keyword + "%");
        }
        searchHistoryList = searchHistoryMapper.selectByExample(example);
        total = (int) searchHistoryMapper.countByExample(example);
        return new SearchHistoryListAndTotalVo(searchHistoryList, total);
    }

    @Override
    public int queryTotalNum() {
        return (int)searchHistoryMapper.countByExample(new SearchHistoryExample());
    }
}
