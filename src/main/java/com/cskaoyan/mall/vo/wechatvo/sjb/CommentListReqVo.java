package com.cskaoyan.mall.vo.wechatvo.sjb;
//valueId=363&type=1&showType=0&page=1&size=5

public class CommentListReqVo {
    private int valueId;
    private int type;
    private int showType;
    private int page;
    private int size;

    @Override
    public String toString() {
        return "CommentListReqVo{" +
                "valueId=" + valueId +
                ", type=" + type +
                ", showType=" + showType +
                ", page=" + page +
                ", size=" + size +
                '}';
    }

    public CommentListReqVo(int valueId, int type, int showType, int page, int size) {
        this.valueId = valueId;
        this.type = type;
        this.showType = showType;
        this.page = page;
        this.size = size;
    }

    public CommentListReqVo() {
    }

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
