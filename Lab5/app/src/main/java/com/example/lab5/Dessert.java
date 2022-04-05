package com.example.lab5;

public class Dessert {
    private int imgID;
    private int price;
    private int startProductionAmount;

    public Dessert(int imgID, int price, int startProductionAmount) {
        this.imgID = imgID;
        this.price = price;
        this.startProductionAmount = startProductionAmount;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStartProductionAmount() {
        return startProductionAmount;
    }

    public void setStartProductionAmount(int startProductionAmount) {
        this.startProductionAmount = startProductionAmount;
    }
}
