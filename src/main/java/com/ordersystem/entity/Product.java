package com.ordersystem.entity;

public class Product {
    //图片、编号、名称、类型、单价、库存
    private int pid;//产品编号
    private int cid;//fk 类型
    private Category category;
    private String pname;//名称
    //private int saler_id ;//fk 客商
    //private User user;
    private int	state;//是否上架状态
    private double price;//单价
    private double mount;
    //添加上传照片
    private String picture;


    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", category=" + category +
                ", pname='" + pname + '\'' +
                ", state=" + state +
                ", price=" + price +
                ", mount=" + mount +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMount() {
        return mount;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
