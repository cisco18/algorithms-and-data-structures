package com.company;

public interface StockChange {
    StockMarket stockmarket = null;
    void activateStock(StockMarket stockMarket);
}
class StockChangeBear implements StockChange{
    public void activateStock(StockMarket stockMarket) {
        System.out.println("\nNadeszła pora niedzwiedzia\n");
        for (Stock stock : stockMarket.stocks) {
            stock.setPrice(stock.getPrice() - (int) (Math.random() * 50));
            if (stock.getPrice()<0){
                stock.setPrice(0);
            }
        }
    }
}

class StockChangeBull implements StockChange{
   public void activateStock(StockMarket stockMarket){
       System.out.println("\nNadeszla pora byka\n");
        for (Stock stock : stockMarket.stocks){
            stock.setPrice(stock.getPrice() + (int) (Math.random() * 50));
        }
    }
}
