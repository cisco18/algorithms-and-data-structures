package com.company;

public class Main {

    public static void main(String[] args) {
        Zadanie2 zadanie2 = new Zadanie2();
        int[][] niewymiar = new int[3][];
        niewymiar[0] = new int[1];
        niewymiar[1] = new int[2];
        niewymiar[2] = new int[3];
        zadanie2.wypelnijTablice(niewymiar);
        zadanie2.wyswietlTablice(niewymiar);
        niewymiar = zadanie2.zaokraglijTablice(niewymiar);
        System.out.println();
        zadanie2.wyswietlTablice(niewymiar);


    }
}

