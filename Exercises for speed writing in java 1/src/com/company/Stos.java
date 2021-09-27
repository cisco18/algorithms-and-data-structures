package com.company;

public class Stos {
    int size = 0;
    int[] integers = null;

    public Stos(int size) {
        integers = new int[size];
        this.size = size;
    }

    public boolean add(int added) {
        boolean didItWork = false;
        if (added == 0) {
            System.out.println("NIE MOŻESZ DODAC 0 DO STACKU");
        } else {
            int length = integers.length;
            for (int i = 0; i < integers.length; i++) {
                if (integers[i] == 0) {
                    integers[i] = added;
                    i = integers.length;
                    didItWork = true;
                }
            }

        }
        return didItWork;
    }

    public boolean takeFromStack() {
        for (int i = integers.length-1; i > 0 ; i--) {
            if (integers[i] != 0){
                integers[i] = 0;
                i = 0;
                return true;
            }
        }
        return false;

    }

    public void showLatest() {
        int latest = 0;
        for (int integer : integers){
            if (integer != 0){
                latest = integer;
            }
        }
        System.out.println("Na szczycie stosu jest " + latest);
    }

    public boolean isStackEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] != 0) {
                isEmpty = false;
                i = integers.length;
            }
        }
        return isEmpty;
    }

    public boolean isStackFull() {
        boolean isFull = true;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] == 0) {
                isFull = false;
            }
        }
        return isFull;
    }


}



