package com.cskaoyan.mall.service.wechatservice.dhd.impl;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Collect;
import com.cskaoyan.mall.bean.CollectExample;
import com.cskaoyan.mall.mapper.CollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
@Service
public class CollectAddordeleteServiceImpl implements CollectAddordeleteService{
    @Autowired
    CollectMapper collectMapper;
    @Override
    public BaseRespVo addordeleteOrAdd(Collect collect) {
        BaseRespVo ok= new BaseRespVo<>();
        System.out.println(collect);
        CollectExample collectExample = new CollectExample();
        collectExample.createCriteria().andUserIdEqualTo(collect.getUserId()).andValueIdEqualTo(collect.getValueId());
        List<Collect> collects = collectMapper.selectByExample(collectExample);
        Date date = new Date();
        collect.setAddTime( date);
        collect.setUpdateTime(date);
        if (collects.size()==0){
            collectMapper.insert(collect);
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("type","delete");
             ok = BaseRespVo.ok(stringStringHashMap);
        }else{
             collectMapper.deleteByUserIdAndValueId(collect.getUserId(),collect.getValueId());
            HashMap<String, String> stringStringHashMap = new HashMap<>();
            stringStringHashMap.put("type","add");
             ok = BaseRespVo.ok(stringStringHashMap);
        }
           return ok;
    }
}
