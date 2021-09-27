package com.company;

import java.util.ArrayList;

public class Subject {
    private final StockMarket stockMarket;
    ArrayList<Observer> observers = new ArrayList<>();

    Subject(StockMarket stockMarket) {
        this.stockMarket = stockMarket;
    }

    public void observe(Observer observer) {
        observers.add(observer);
    }

    public void notifyOfDropBelow(int below) {
        for (Stock stock : stockMarket.stocks) {
            String name = stock.getName();
            int price = stock.getPrice();
            if (stock.getPrice() < below) {
                for (Observer observer : observers) {
                    observer.notifyOfDrop(name, price);
                }
            }
        }
    }

    public void notifyOfRiseAbove(int above) {
        for (Stock stock : stockMarket.stocks) {
            String name = stock.getName();
            int price = stock.getPrice();
            if (stock.getPrice() > above) {
                for (Observer observer : observers) {
                    observer.notifyOfRise(name, price);
                }
            }
        }
    }

    public void notifyOfAllStocks() {
        for (Stock stock : stockMarket.stocks) {
            String name = stock.getName();
            int price = stock.getPrice();
            for (Observer observer : observers) {
                observer.notifyOfAllStocks(name, price);
            }
        }
    }
}






