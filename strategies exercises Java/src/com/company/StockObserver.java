package com.company;

public class StockObserver implements Observer{
    private String name;

    StockObserver(String name) {
        this.name = name;
    }

    public void notifyOfDrop(String stockName, int drop) {
        System.out.print("\n" + name + " stock " + stockName + " spadl do " + drop);
    }
    public void notifyOfRise(String stockName, int rise) {
        System.out.print("\n" + name + " stock " + stockName + " wzrosl do " + rise);
    }
    public void notifyOfAllStocks(String stockName, int price){
        System.out.print("\n" + name + " stock " + stockName + " ma wartosc " + price);
    }
}
