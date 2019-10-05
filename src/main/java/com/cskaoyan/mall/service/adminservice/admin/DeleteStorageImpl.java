package com.cskaoyan.mall.service.adminservice.admin;

import com.cskaoyan.mall.bean.BaseRespVo;
import com.cskaoyan.mall.bean.Storage;
import com.cskaoyan.mall.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStorageImpl implements  DeleteStorage {
    @Autowired
    StorageMapper storageMapper;
    @Override
    public BaseRespVo deleteStorage(Storage storage) {
        storageMapper.deleteByPrimaryKey(storage.getId());
        BaseRespVo ok = BaseRespVo.ok(null);
        return ok;
    }
}
