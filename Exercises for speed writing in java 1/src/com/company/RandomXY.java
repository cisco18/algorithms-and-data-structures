package com.company;

import com.sun.jdi.Value;

import java.util.*;

public class RandomXY {
    //Key to odleglosc value to count
    HashMap<Double, Integer> hashMap = new HashMap<>();

    public void bladzenie(double n) {
        int x = 0;
        int y = 0;
        int count = 0;
        while (Math.sqrt((x * x) + (y * y)) < n) {
            int random = (int) (Math.random() * 4);
            if (random == 0) {
                x++;
            }
            if (random == 1) {
                x--;
            }
            if (random == 2) {
                y++;
            }
            if (random == 3) {
                y--;
            }
            count++;
        }
        hashMap.put(n, count);
    }

    public void drukujTabelę() {
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry pair = (Map.Entry) iterator.next();
            System.out.println("Dla odległości " + pair.getKey() + " liczba prob  wynosila " + pair.getValue());

        }
    }
}
