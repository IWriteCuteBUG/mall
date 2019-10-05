package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.vo.adminvo.dhd.AllVo;
import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.mapper.StorageMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StorageServiceImpl implements  StorageService {
    @Autowired
    StorageMapper storageMapper;
    @Override
    public BaseRespVo storageInfo(int page, int limit,String key,String name) {
        AllVo objectAllVo = new AllVo<>();
        List<Storage> storages = storageMapper.selectStorageListByKeyAndName(key, name);
        PageHelper.startPage(page, limit);
        PageInfo<Storage> storagePageInfo = new PageInfo<>(storages);
        long total = storagePageInfo.getTotal();
        objectAllVo.setItems(storages);
        objectAllVo.setTotal((int) total);
        BaseRespVo ok = BaseRespVo.ok(objectAllVo);
        return ok;
    }
}
