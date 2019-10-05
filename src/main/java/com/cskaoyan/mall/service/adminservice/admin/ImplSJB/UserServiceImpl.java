package com.cskaoyan.mall.service.adminservice.impl.ImplSJB;

import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.bean.UserExample;
import com.cskaoyan.mall.mapper.UserMapper;
import com.cskaoyan.mall.service.adminservice.serviceSJB.UserService;
import com.cskaoyan.mall.vo.adminvo.voSJB.UserListAndTotalVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserListAndTotalVo queryUsersByPage(int page, int limit, String username, String mobile, String sortcolnum, String order) {
        PageHelper.startPage(page, limit);
        UserExample example = new UserExample();
        String sortOrder = sortcolnum + " " + order;
        example.setOrderByClause(sortOrder);
        List<User> userList = null;
        int total = 0;
        if(!((username == null || "".equals(username.trim())) && (mobile == null || "".equals(mobile.trim())))){
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameLike("%" + username + "%").andMobileLike("%" + mobile + "%");
        }
        userList = userMapper.selectByExample(example);
        total = (int) userMapper.countByExample(example);
        return new UserListAndTotalVo(userList, total);
    }

    @Override
    public int queryTotalNum() {
        return (int)userMapper.countByExample(new UserExample());
    }
}
