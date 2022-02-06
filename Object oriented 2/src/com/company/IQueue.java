package com.company;

public interface IQueue<T>{
    boolean isEmpty();
    boolean isFull();
    T dequeue() ;
    void enqueue(T elem) ;
    int size(); // zwraca liczbę elementów w kolejce
    T first();
    // zwraca element z początku kolejki bez usuwania go
}
