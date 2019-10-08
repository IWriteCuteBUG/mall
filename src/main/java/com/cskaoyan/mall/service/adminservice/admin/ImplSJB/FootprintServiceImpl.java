package com.cskaoyan.mall.service.adminservice.admin.ImplSJB;

import com.cskaoyan.mall.bean.Footprint;
import com.cskaoyan.mall.bean.FootprintExample;
import com.cskaoyan.mall.mapper.FootprintMapper;
import com.cskaoyan.mall.service.adminservice.serviceSJB.FootprintService;
import com.cskaoyan.mall.vo.adminvo.voSJB.FootprintListAndTotalVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootprintServiceImpl implements FootprintService {
    @Autowired
    FootprintMapper footprintMapper;

    @Override
    public FootprintListAndTotalVo queryFootprintsByPage(int page, int limit, String userId, String goodsId, String sortcolnum, String order) {
        PageHelper.startPage(page, limit);
        FootprintExample example = new FootprintExample();
        String sortOrder = sortcolnum + " " + order;
        example.setOrderByClause(sortOrder);
        List<Footprint> footprintList = null;
        int total = 0;
        int uid = 0;
        int gid = 0;
        FootprintExample.Criteria criteria = example.createCriteria();
        if(!(userId == null || "".equals(userId.trim()))){
            uid = Integer.parseInt(userId);
        }
        if(!(goodsId == null || "".equals(goodsId.trim()))){
            gid = Integer.parseInt(goodsId);
        }
        if(uid != 0){
            criteria.andUserIdEqualTo(uid);
        }
        if(gid != 0){
            criteria.andGoodsIdEqualTo(gid);
        }
        footprintList = footprintMapper.selectByExample(example);
        total = (int) footprintMapper.countByExample(example);
        return new FootprintListAndTotalVo(footprintList, total);
    }

    @Override
    public int queryTotalNum() {
        return (int)footprintMapper.countByExample(new FootprintExample());
    }

}
