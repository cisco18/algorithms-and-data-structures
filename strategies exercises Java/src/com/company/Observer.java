package com.company;

public interface Observer {
    void notifyOfDrop(String stockName, int drop);
    void notifyOfRise(String stockName, int bump);
    void notifyOfAllStocks(String stockName, int bump);
}
