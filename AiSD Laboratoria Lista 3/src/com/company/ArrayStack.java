package com.company;

import java.lang.reflect.Array;

public class ArrayStack<T> implements IStack<T> {
    private T[] stack;
    private int taken = 0;
    private Class<T> clasS;

    public ArrayStack(Class<T> clasS) {
        this.clasS = clasS;
        stack = (T[]) Array.newInstance(this.clasS, 7);
    }

    public ArrayStack(Class<T> clasS, int length) {
        this.clasS = clasS;
        stack = (T[]) Array.newInstance(this.clasS, length);
    }

    @Override
    public boolean isEmpty()
    {
        return (taken == 0);
    }

    @Override
    public boolean isFull() {
        return taken == stack.length;
    }

    @Override
    public void push(T t) {
        if (taken >= (stack.length)) {
            System.out.println("Stack Overflow");

        }
        else {
            stack[taken] = t;
            System.out.println(t + " pushed into stack");
            taken++;

        }
    }


    public T pop()
    {
        if (taken == 0) {
            System.out.println("Stack Underflow");
            return null;
        }
        else {
            T variable = stack[taken-1];
            stack[taken-1] = null;
            taken--;
            System.out.println(variable + " popped from stack");
            return variable;
        }
    }

    @Override
    public int size() {
        return taken;
    }

    @Override
    public char top() {
        return (char) stack[taken];
    }
}
