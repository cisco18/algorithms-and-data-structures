package com.company;

import java.util.Random;

public class Zadanie2 {
    public int[][] zaokraglijTablice(int[][] tablica) {
        int max = 0;
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i].length > max) {
                max = tablica[i].length;
            }
        }
        int tablica2[][] = new int[tablica.length][max];
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                tablica2[i][j] = tablica[i][j];
            }
            if (max > tablica[i].length) {
                for (int k = tablica[i].length; k < max; k++) {
                    tablica2[i][k] = -1;
                }
            }

        }
        return tablica2;
    }
        /*
        if (tablica.length > tablica[0].length) {
            int[][] tablica2 = new int[tablica.length][tablica.length];
            for (int i = 0; i < tablica.length; i++) {
                for (int j = 0; j < tablica.length; j++) {
                    if (i<tablica.length && j<tablica.length){
                        tablica2[i][j] = tablica[i][j];
                    }else {
                        tablica2[i][j] = -1;
                    }

                }
            }
        return tablica2;
        }
        if (tablica.length < tablica[0].length) {
            int[][] tablica2 = new int[tablica[0].length][tablica[0].length];
            for (int i = 0; i < tablica[0].length; i++) {
                for (int j = 0; j < tablica[0].length; j++) {
                    if (i<tablica.length && j<tablica[0].length){
                        tablica2[i][j] = tablica[i][j];
                    }else {
                        tablica2[i][j] = -1;
                    }

                }
            }
            return tablica2;
        }
        return tablica;
    }

         */


    public int[][] stworz(int n, int k) {
        int[][] tablica = new int[n][k];
        return tablica;
    }

    public int[][] wypelnijTablice(int[][] tablica) {
        Random random = new Random();
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].length; j++) {
                tablica[i][j] = random.nextInt(10);
            }

        }
        return tablica;
    }

    public void wyswietlTablice(int[][] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            System.out.println();
            for (int j = 0; j < tablica[i].length; j++) {
                System.out.print(tablica[i][j] + " ");
            }
        }
    }
}


