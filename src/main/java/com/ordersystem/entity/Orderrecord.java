package com.ordersystem.entity;

public class Orderrecord {
    private int order_recorder;
    private Orders order;
    private Product product;
    private int number;

    public int getOrder_recorder() {
        return order_recorder;
    }

    public void setOrder_recorder(int order_recorder) {
        this.order_recorder = order_recorder;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
