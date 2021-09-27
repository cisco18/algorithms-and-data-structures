package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class PunktyXY {
    HashMap<Integer, Integer> hashMap = null;


    PunktyXY(int n) {
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

    public void poleTrojkata() {
        Iterator iterator = hashMap.entrySet().iterator();
        int x1 = 0;
        int x2 = 0;
        int x3 = 0;
        int y1 = 0;
        int y2 = 0;
        int y3 = 0;
        double distance = 0;
        int x = 0;
        int y = 0;
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            double distanceTemp = Math.sqrt(((int) (pair.getKey()) * (int) pair.getKey()) + ((int) (pair.getValue()) * (int) pair.getValue()));
            if (distanceTemp > Math.sqrt((x1 * x1) + (y1 * y1))) {
                x3 = x2;
                y3 = y2;
                x2 = x1;
                y2 = y1;
                x1 = (int) pair.getKey();
                y1 = (int) pair.getValue();
            }
        }
        double a = Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
        double b = Math.sqrt(((x3-x1)*(x3-x1))+((y3-y1)*(y3-y1)));
        double c = Math.sqrt(((x3-x2)*(x3-x2))+((y3-y2)*(y3-y2)));
        double polowaObwodu = (a+b+c)/2;
        double pole = Math.sqrt(polowaObwodu*(polowaObwodu-a)*(polowaObwodu-b)*(polowaObwodu-c));
        System.out.println("POLE TROJKATA WYNOSI " + pole);
    }

}
