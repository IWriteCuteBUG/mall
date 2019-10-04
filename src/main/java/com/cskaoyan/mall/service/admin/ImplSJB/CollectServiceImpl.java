package com.cskaoyan.mall.service.admin.ImplSJB;

import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.bean.CollectExample;
import com.cskaoyan.mall.mapper.CollectMapper;
import com.cskaoyan.mall.service.serviceSJB.CollectService;
import com.cskaoyan.mall.vo.voSJB.CollectListAndTotalVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectMapper collectMapper;

    @Override
    public CollectListAndTotalVo queryCollectsByPage(int page, int limit, String userId, String valueId, String sortcolnum, String order) {
        PageHelper.startPage(page, limit);
        CollectExample example = new CollectExample();
        String sortOrder = sortcolnum + " " + order;
        example.setOrderByClause(sortOrder);
        List<Collect> collectList = null;
        int total = 0;
        int uid = 0;
        int vid = 0;
        CollectExample.Criteria criteria = example.createCriteria();
        if(!(userId == null || "".equals(userId.trim()))){
            uid = Integer.parseInt(userId);
        }
        if(!(valueId == null || "".equals(valueId.trim()))){
            vid = Integer.parseInt(valueId);
        }
        if(uid != 0){
            criteria.andUserIdEqualTo(uid);
        }
        if(vid != 0){
            criteria.andValueIdEqualTo(vid);
        }
        collectList = collectMapper.selectByExample(example);
        total = (int) collectMapper.countByExample(example);
        return new CollectListAndTotalVo(collectList, total);
    }

    @Override
    public int queryTotalNum() {
        return (int)collectMapper.countByExample(new CollectExample());
    }
}
