package com.ordersystem.entity;

import java.security.Timestamp;

public class Orders {
    private String order_ID;
    private User user;
    private Timestamp order_TIME;
    private int status = 0;

    public Orders(String order_ID, User user, Timestamp order_TIME, int status) {
        super();
        this.order_ID = order_ID;
        this.user = user;
        this.order_TIME = order_TIME;
        this.status = status;
    }

    public Orders() {
        super();
    }

    public String getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(String order_ID) {
        this.order_ID = order_ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getOrder_TIME() {
        return order_TIME;
    }

    public void setOrder_TIME(Timestamp order_TIME) {
        this.order_TIME = order_TIME;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
