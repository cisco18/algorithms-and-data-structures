package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Stock> stockArrayList = new ArrayList<>();
            stockArrayList.add(new Stock("Google", 700));
            stockArrayList.add(new Stock("Amazon", 500));
            stockArrayList.add(new Stock("Ford", 600));
            stockArrayList.add(new Stock("GameStop", 450));
            stockArrayList.add(new Stock("Tesla", 300));

        StockMarket stockMarket = new StockMarket(stockArrayList, new StockChangeBear());

        StockObserver stockObserver1 = new StockObserver("John");
        StockObserver stockObserver2 = new StockObserver("Anna");

        Subject subject = new Subject(stockMarket);
        subject.observe(stockObserver1);
        subject.observe(stockObserver2);

        stockMarket.dropAStock("Amazon", 120);
        stockMarket.bumpAStock("Tesla", 220);


        subject.notifyOfDropBelow(400);
        subject.notifyOfRiseAbove(600);


        stockMarket.crash();

        subject.notifyOfDropBelow(200);
        subject.notifyOfRiseAbove(300);

        System.out.println();
        stockMarket.typeOfStockChange.activateStock(stockMarket);
        subject.notifyOfAllStocks();



    }
}
