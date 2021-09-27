package com.company;

public class Stock {
    private final String name;
    private int price;
    Stock(String name, int price){
        this.name = name;
        this.price = price;
        if(price<0){
            setPrice(0);
        }
    }



    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
