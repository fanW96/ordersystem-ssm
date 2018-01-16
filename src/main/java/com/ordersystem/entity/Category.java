package com.ordersystem.entity;

public class Category {
    private int cid;
    private String description;

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", description='" + description + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
