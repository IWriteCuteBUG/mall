package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageUpdageServiceImpl implements StorageUpdageService{
    @Autowired
    StorageMapper storageMapper;

    @Override
    public BaseRespVo updageStorage(Storage storage) {
        storageMapper.updateByPrimaryKey(storage);
        BaseRespVo ok = BaseRespVo.ok(storage);
        return ok;
    }
}
