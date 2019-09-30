package com.cskaoyan.mall.bean;

public class BaseRespVo<T> {
    private T data;
    private String Errmsg;
    private int Errno;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return Errmsg;
    }

    public void setErrmsg(String errmsg) {
        Errmsg = errmsg;
    }

    public int getErrno() {
        return Errno;
    }

    public void setErrno(int errno) {
        Errno = errno;
    }

    public static BaseRespVo ok(String msg) {
        BaseRespVo<String> baseRespVo = new BaseRespVo<>();
        baseRespVo.setData(msg);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
    public static BaseRespVo info(InfoVo infoVo) {
        BaseRespVo<InfoVo> baseRespVo = new BaseRespVo<>();
        baseRespVo.setData(infoVo);
        baseRespVo.setErrmsg("成功");
        return baseRespVo;
    }
}
