package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.bean.CollectExample;
import com.cskaoyan.mall.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CollectAddordeleteServiceImpl implements CollectAddordeleteService{
    @Autowired
    CollectMapper collectMapper;
    @Override
    public BaseRespVo addordeleteOrAdd(Collect collect) {
        CollectExample collectExample = new CollectExample();
        collectExample.createCriteria().andUserIdEqualTo(collect.getUserId()).andValueIdEqualTo(collect.getValueId());
        List<Collect> collects = collectMapper.selectByExample(collectExample);
        Date date = new Date();
        collect.setAddTime( date);
        collect.setUpdateTime(date);
        if (collects ==null){
            collectMapper.insert(collect);
        }else{
             collectMapper.deleteByUserIdAndValueId(collect.getUserId(),collect.getValueId());
        }
        return null;

    }
}
