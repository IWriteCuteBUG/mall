package com.cskaoyan.mall.service.Impl.ImplSJB;

import com.cskaoyan.mall.bean.Address;
import com.cskaoyan.mall.bean.AddressExample;
import com.cskaoyan.mall.mapper.AddressMapper;
import com.cskaoyan.mall.service.serviceSJB.AddressService;
import com.cskaoyan.mall.vo.voSJB.AddressListAndTotalVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public AddressListAndTotalVo queryAddressesByPage(int page, int limit, String name, String userId, String sortcolnum, String order) {
        PageHelper.startPage(page, limit);
        AddressExample example = new AddressExample();
        String sortOrder = sortcolnum + " " + order;
        example.setOrderByClause(sortOrder);
        List<Address> addressList = null;
        int total = 0;
        int uid = 0;
        if(!(userId == null || "".equals(userId.trim()))){
            uid = Integer.parseInt(userId);
        }
        if(uid != 0){
            AddressExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(uid);
        } else if(!(name == null || "".equals(name.trim()))){
            AddressExample.Criteria criteria = example.createCriteria();
            criteria.andNameLike("%" + name + "%");
        }
        addressList = addressMapper.selectByExample(example);
        total = (int) addressMapper.countByExample(example);
        return new AddressListAndTotalVo(addressList, total);
    }

    @Override
    public int queryTotalNum() {
        return (int)addressMapper.countByExample(new AddressExample());
    }

}
