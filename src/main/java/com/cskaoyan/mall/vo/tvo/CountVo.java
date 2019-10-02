package com.cskaoyan.mall.vo.tvo;

import java.util.List;

public class CountVo<T> {
    /*"columns":[
            "day",
            "users"
            ],
            "rows":[
    {
        "day":"2019-04-19",
            "users":22
    }
        ]*/
    String[] columns;
    List<T> rows;

    public CountVo() {
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
