package com.company;

import java.util.ArrayList;


public class StockMarket {
    ArrayList<Stock> stocks;
    StockChange typeOfStockChange;


    public StockMarket(ArrayList<Stock> arrayListOfStocks, StockChange typeOfStockChange) {
        // StockChangeBear dla rynku malejących akcji StockChangeBull dla rosnących
        this.typeOfStockChange = typeOfStockChange;
        stocks = arrayListOfStocks;
    }

    public void dropAStock(String stockName, int drop) {
        for (Stock stock : stocks) {
            if (stock.getName().equalsIgnoreCase(stockName)) {
                stock.setPrice(stock.getPrice() - drop);
                if (stock.getPrice() > 0) {
                    System.out.print("\n" + stockName + " spadło o " + drop);
                } else {
                    stock.setPrice(stock.getPrice() + drop);
                    System.out.print("Stock nie może mieć ujemnej wartości, drop nieudany");
                }
            }

        }
    }

    public void bumpAStock(String stockName, int bump) {
        for (Stock stock : stocks) {
            if (stock.getName().equalsIgnoreCase(stockName)) {
                stock.setPrice(stock.getPrice() + bump);
                System.out.println("\n" + stockName + " wzrosło o " + bump);
            }

        }
    }

    public void crash() {
        for (Stock stock : stocks) {
            stock.setPrice((int) (Math.random() * 250));
            if (stock.getPrice()<0){
                stock.setPrice(0);
            }
        }
        System.out.println("\nCRASH!!!\n");
    }


}