package com.company;

public class Main {

    public static void main(String[] args) {
       Zegar zegar = new Zegar(23,12,40);
       zegar.przesunOGodzine();
        Zegar zegar2 = new Zegar(23,12,40);
       zegar.pokazPelnaGodzine();
        System.out.println(zegar.porownaj(zegar2));


       RandomXY randomXY = new RandomXY();
       randomXY.bladzenie(2);
       randomXY.bladzenie(6);
       randomXY.bladzenie(12);
       randomXY.drukujTabelę();


       Stos stos = new Stos(6);
       stos.add(2);
       stos.add(4);
       stos.add(6);
       stos.takeFromStack();
       stos.showLatest();
        System.out.println(stos.isStackEmpty());


}
}
