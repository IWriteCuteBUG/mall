package com.cskaoyan.mall.controller;

import com.cskaoyan.mall.bean.User;
import com.cskaoyan.mall.service.UserService;
import com.cskaoyan.mall.vo.uservo.UserListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("admin/auth/list")
    //page=1&limit=20&sort=add_time&order=desc
    public UserListVo list(int page, int limit, Enum sort, Enum order){
        UserListVo userListVo = new UserListVo();
        List<User> userList = userService.queryAllUsers();
        if(userList.size() >= 0){
            userListVo.setErrno(0);
            userListVo.setErrmsg("no error");
            userListVo.getData().setItems(userList);
            userListVo.getData().setTotal(userList.size());
        } else {
            userListVo.setErrno(1);
            userListVo.setErrmsg("query error");
        }
        return userListVo;
    }

}
