package com.cskaoyan.mall.service.wechatservice.sjb.impl;


import com.cskaoyan.mall.bean.Footprint;
import com.cskaoyan.mall.bean.FootprintExample;
import com.cskaoyan.mall.mapper.FootprintMapper;
import com.cskaoyan.mall.service.wechatservice.sjb.FootprintServiceSJB;
import com.cskaoyan.mall.vo.adminvo.voSJB.AddressListAndTotalVo;
import com.cskaoyan.mall.vo.adminvo.voSJB.FootprintListAndTotalVo;
import com.cskaoyan.mall.vo.wechatvo.sjb.FootprintListToolVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootprintServiceSJBImpl implements FootprintServiceSJB {

    @Autowired
    FootprintMapper footprintMapper;

    @Override
    public List<FootprintListToolVo> queryFootprintAndGoodsMultiById(int page, int size, int userId) {
        PageHelper.startPage(page, size, "f.update_time desc");
        return footprintMapper.queryFootprintAndGoodsMultiById(userId);
    }


    @Override
    public int queryTotalFootprintByUserId(int userId) {
        FootprintExample example = new FootprintExample();
        FootprintExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return (int) footprintMapper.countByExample(example);
    }

    @Override
    public int addFootprintWithoutId(Footprint footprint) {
        return footprintMapper.addFootprintWithoutId(footprint);
    }
}
