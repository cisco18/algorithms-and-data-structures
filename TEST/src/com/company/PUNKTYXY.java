package com.company;

import java.util.*;

public class PUNKTYXY {
    //HUBERT BUDNY
    HashMap<Integer, Integer> hashMap = null;


    PUNKTYXY(int n) {
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
        System.out.println();
    }

    public void wyswietlOdleglosci() {
        Iterator iterator = hashMap.entrySet().iterator();
        ArrayList<Double> arrayListOfDistances = new ArrayList<>();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            double distanceTemp = Math.sqrt(((int) (pair.getKey()) * (int) pair.getKey()) + ((int) (pair.getValue()) * (int) pair.getValue()));
                int x = (int) pair.getKey();
                int y = (int) pair.getValue();
                arrayListOfDistances.add(distanceTemp);
        }
        Collections.sort(arrayListOfDistances);
        System.out.println("Odleglosci od najmniejszej do najwiekszej");
        for (double distance : arrayListOfDistances){
            System.out.println("dystans wynosi: " + distance);
        }
        System.out.println();
    }

    public void punktyOdlegleOdSiebie(){
        Iterator iterator = hashMap.entrySet().iterator();
        double maxDistance = 0;
        int x1A = 0;
        int x2A = 0;
        int y1A = 0;
        int y2A = 0;
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            int x1 = (int) pair.getKey();
            int y1 = (int) pair.getValue();
            Iterator iterator2 = hashMap.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry pair2 = (Map.Entry) iterator2.next();
                int x2 = (int) pair2.getKey();
                int y2 = (int) pair2.getValue();
                double distance = Math.sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
                if (distance > maxDistance){
                maxDistance = distance;
                x1A = x1;
                x2A = x2;
                y1A = y1;
                y2A = y2;
                }
            }
        }
        System.out.println("Punkty najbardziej odległe od siebie to:  x1 " + x1A + " y1 " + y1A + "  x2 " + x2A + " y2 " + y2A + "  A ich dystans to " + maxDistance + "\n");
    }
}
