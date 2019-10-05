package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.vo.adminvo.dhd.AllVo;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Log;
import com.cskaoyan.mall.bean.LogExample;
import com.cskaoyan.mall.mapper.LogMapper;
import com.github.pagehelper.PageHelper;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public BaseRespVo logListInfo(int page, int limit,String name) {
        AllVo allVo = new AllVo();
        PageHelper.startPage(page,limit);
        LogExample logExample = new LogExample();
        if (name!=null){
            logExample.createCriteria().andAdminIsNotNull().andAdminLike(name+"%");
        }
        else{
            logExample.createCriteria().andAdminIsNotNull();
        }
        List<Log> logs = logMapper.selectByExample(logExample);
        allVo.setItems(logs);
        PageInfo<Log> logPageInfo = new PageInfo<>(logs);
        long total = logPageInfo.getTotal();
        allVo.setTotal((int)total);
        BaseRespVo ok = BaseRespVo.ok(allVo);
        return ok;
    }
}
