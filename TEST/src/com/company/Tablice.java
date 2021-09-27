package com.company;

import java.util.Random;

public class Tablice {
    //HUBERT BUDNY
    public int[] polaczTablice(int[] tablica1, int[] tablica2) {
        if (tablica1.length != tablica2.length) {
            System.out.println("TABLICE MUSZA BYC TYCH SAMYCH DLUGOSCI, ZWROCONO PUSTA TABLICE");
            return new int[0];
        } else {
            int[] tablica = new int[tablica1.length + tablica2.length];
            int k = 1;
            int j = 0;
            for (int i = 0; i < tablica1.length; i++) {
                tablica[j] = tablica1[i];
                tablica[k] = tablica2[i];
                k = k + 2;
                j = j + 2;
            }
            return tablica;
        }
    }
// ta funckja słu
    public int findMax(int[] tablica) {
        int max = 0;
        int iMax = 0;
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] > max) {
                max = tablica[i];
                iMax = i;
            }
        }
        System.out.println("Element maksymalny to " + max + " a jego indeks to " + iMax);
        return max;
    }


    public int[] wypelnijTabliceLosowymi(int[] tablica) {
        Random random = new Random();
        for (int i = 0; i < tablica.length; i++) {
            tablica[i] = random.nextInt(10);
        }
        return tablica;
    }

    public void wydrukujTablice(int[] tablica){
        System.out.println();
        for (int i = 0; i < tablica.length; i++) {
            System.out.println(tablica[i]);
        }
        System.out.println();
    }
}


