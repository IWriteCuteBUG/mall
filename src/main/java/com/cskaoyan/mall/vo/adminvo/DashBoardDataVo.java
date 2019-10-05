package com.cskaoyan.mall.vo.adminvo;
//"goodsTotal": 256,
////		"userTotal": 22,
////		"productTotal": 261,
////		"orderTotal": 207
public class DashBoardDataVo {
    private int userTotal;
    private int productTotal;
    private int orderTotal;

    @Override
    public String toString() {
        return "DashBoardDataVo{" +
                "userTotal=" + userTotal +
                ", productTotal=" + productTotal +
                ", orderTotal=" + orderTotal +
                '}';
    }

    public int getUserTotal() {
        return userTotal;
    }

    public void setUserTotal(int userTotal) {
        this.userTotal = userTotal;
    }

    public int getProductTotal() {
        return productTotal;
    }

    public void setProductTotal(int productTotal) {
        this.productTotal = productTotal;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }
}
