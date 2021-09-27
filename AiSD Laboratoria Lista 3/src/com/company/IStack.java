package com.company;

public interface IStack<T> {
    public boolean isEmpty();
    public boolean isFull();
    public void push(T t);
    public T pop();
    public int size();
    public char top();
}
