package com.cskaoyan.mall.controller.controllerSJB;

import com.cskaoyan.mall.service.serviceSJB.UserService;
import com.cskaoyan.mall.vo.voSJB.DataForUserListVo;
import com.cskaoyan.mall.vo.voSJB.UserListAndTotalVo;
import com.cskaoyan.mall.vo.voSJB.UserListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("admin/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("list")
    public UserListVo list(int page, int limit, String username, String mobile, String sort, String order){
        UserListAndTotalVo vo = userService.queryUsersByPage(page, limit, username, mobile, sort, order);
        return new UserListVo(0, new DataForUserListVo(vo.getTotal(), vo.getUserList()), "no error");
    }

}
