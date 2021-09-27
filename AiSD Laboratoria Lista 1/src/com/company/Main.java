package com.company;


public class Main {

    public static void main(String[] args) {
        Operations operations = new Operations();
        // read from file ma limit 20 pracownikow w liscie, w razie potrzeby zmienic pojemnosc tablicy
        Worker[] workerS = operations.readFromFile("workers.txt");
        operations.addWorkers(workerS);
        operations.showWorkersList(workerS);
        operations.writeToFile(workerS);

    }
}
