package com.cskaoyan.mall.vo.voSJB;

public class SearchHistoryListVo {
    private int errno;
    private DataForSearchHistoryListVo data;
    private String errmsg;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public DataForSearchHistoryListVo getData() {
        return data;
    }

    public void setData(DataForSearchHistoryListVo data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "SearchHistoryListVo{" +
                "errno=" + errno +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public SearchHistoryListVo(int errno, DataForSearchHistoryListVo data, String errmsg) {
        this.errno = errno;
        this.data = data;
        this.errmsg = errmsg;
    }

    public SearchHistoryListVo() {
    }
}
