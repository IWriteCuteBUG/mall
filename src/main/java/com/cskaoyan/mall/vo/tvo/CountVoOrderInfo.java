package com.cskaoyan.mall.vo.tvo;

public class CountVoOrderInfo {
    /* "day",
             "orders",
             "customers",
             "amount",
             "pcr*/
    private int orders;
    private int customers;
    private int amount;
    private int pcr;
    private String day;

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPcr() {
        return pcr;
    }

    public void setPcr(int pcr) {
        this.pcr = pcr;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
