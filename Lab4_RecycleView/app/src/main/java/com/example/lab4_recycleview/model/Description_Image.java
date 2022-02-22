package com.example.lab4_recycleview.model;

public class Description_Image {
    private int src_img;
    private String description ;

    public Description_Image(int src_img, String description) {
        this.src_img = src_img;
        this.description = description;
    }
    public Description_Image() {
    }

    public int getSrc_img() {
        return src_img;
    }

    public void setSrc_img(int src_img) {
        this.src_img = src_img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
