package com.company;

public class Main {

    public static void main(String[] args) {
        int[][] tablica = new int[3][];
        tablica[0] = new int[1];
        tablica[1] = new int[2];
        tablica[2] = new int[3];
        tablica[1][1] = 2;
        Tablice tablice = new Tablice();
        tablica = tablice.operujNaTablicy(tablica);
        tablice.drukujTablice(tablica);
        System.out.println();
        PunktyZaSlowo punktyZaSlowo = new PunktyZaSlowo();
        punktyZaSlowo.rozpocznijGre();
    }
}
