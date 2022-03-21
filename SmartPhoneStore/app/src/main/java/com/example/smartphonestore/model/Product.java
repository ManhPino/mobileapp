package com.example.smartphonestore.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String tensp;
    private String des;
    private String link ;
    private String price;

    public Product(int id, String tensp, String des, String link, String price) {
        this.id = id;
        this.tensp = tensp;
        this.des = des;
        this.link = link;
        this.price = price;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
