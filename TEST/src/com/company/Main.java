package com.company;

public class Main {

    public static void main(String[] args) {
        //HUBERT BUDNY
        //zadanie 1
        PUNKTYXY punktyxy = new PUNKTYXY(5);
        punktyxy.wydrukuj();
        punktyxy.wyswietlOdleglosci();
        punktyxy.punktyOdlegleOdSiebie();
        //zadanie2
        Liczby liczby = new Liczby();
        liczby.wypiszWszystkieCzteroCyfroweParzystaSuma();
        //zadanie3
        int[] tablica1 = new int[6];
        int[] tablica2 = new int[6];
        Tablice tablice = new Tablice();
        tablice.wypelnijTabliceLosowymi(tablica1);
        tablice.wypelnijTabliceLosowymi(tablica2);
        tablice.wydrukujTablice(tablica1);
        tablice.wydrukujTablice(tablica2);
        tablice.wydrukujTablice(tablice.polaczTablice(tablica1, tablica2));
        System.out.println(tablice.findMax(tablica1));




    }
}
