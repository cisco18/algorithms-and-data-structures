package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Zadanie1 {
    HashMap<Integer, Integer> hashMap = null;


    Zadanie1(int n) {
        hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            Random random2 = new Random();
            int x = random.nextInt(100) - 50;
            int y = random2.nextInt(100) - 50;
            hashMap.put(x, y);
        }
    }


    public void wydrukuj() {
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println("x " + pair.getKey() + "  y " + pair.getValue());
        }
    }

    public void najblizszyPunkt() {
        Iterator it = hashMap.entrySet().iterator();
        double distance = 2000000;
        int x = 0;
        int y = 0;
        //na pewno bedzie nadpisane, dystans z mapy nie osiagnie takiej wartosci
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            double distanceTemp = Math.sqrt(((int) (pair.getKey()) * (int) pair.getKey()) + ((int) (pair.getValue()) * (int) pair.getValue()));
            if (distanceTemp < distance) {
                distance = distanceTemp;
                x = (int) pair.getKey();
                y = (int) pair.getValue();
            }
        }
        System.out.println("Najblizszy punkt to x:" + x + " y: " + y + " a dystans wynosi " + distance);
    }

    public void najdalszyPunkt() {
        Iterator iterator = hashMap.entrySet().iterator();
        double distance = 0;
        int x = 0;
        int y = 0;
        //na pewno bedzie nadpisane, dystans z mapy nie osiagnie takiej wartosci
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            double distanceTemp = Math.sqrt(((int) (pair.getKey()) * (int) pair.getKey()) + ((int) (pair.getValue()) * (int) pair.getValue()));
            if (distanceTemp > distance) {
                distance = distanceTemp;
                x = (int) pair.getKey();
                y = (int) pair.getValue();

            }
        }
        System.out.println("Najdalszy punkt to x:" + x + " y: " + y + " a dystans wynosi " + distance);
    }

    public void minimalnyProstokat() {
        int minX = 50;
        int maxX = -50;
        int minY = 50;
        int maxY = -50;
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            it.remove();
            if ((int) pair.getKey() < minX) {
                minX = (int) pair.getKey();
            }
            if ((int) pair.getKey() > maxX) {
                maxX = (int) pair.getKey();
            }
            if ((int) pair.getValue() < minY) {
                minY = (int) pair.getValue();
            }
            if ((int) pair.getValue() > maxY) {
                maxY = (int) pair.getValue();
            }

        }
        System.out.println("Punkty tego prostokata sa nastepujace: " + maxX + ":" + maxY + "  " + maxX + ":" + minY + "  "
                + minX + ":" + maxY + "  " + minX + ":" + minY + "  ");
    }

}

