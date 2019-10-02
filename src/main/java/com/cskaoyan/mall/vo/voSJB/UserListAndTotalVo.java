package com.cskaoyan.mall.vo.voSJB;

import com.cskaoyan.mall.bean.User;

import java.util.List;

public class UserListAndTotalVo {
    private List<User> userList;
    private int total;

    @Override
    public String toString() {
        return "UserListAndTotalVo{" +
                "userList=" + userList +
                ", total=" + total +
                '}';
    }

    public UserListAndTotalVo(List<User> userList, int total) {
        this.userList = userList;
        this.total = total;
    }

    public UserListAndTotalVo() {
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
