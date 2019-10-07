package com.cskaoyan.mall.vo.wechatvo.sjb;

public class AddressDeleteVo {
    private int id;

    @Override
    public String toString() {
        return "AddressDeleteVo{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AddressDeleteVo(int id) {
        this.id = id;
    }

    public AddressDeleteVo() {
    }
}
