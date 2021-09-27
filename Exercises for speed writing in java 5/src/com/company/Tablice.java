package com.company;

public class Tablice {
    public int[][] operujNaTablicy(int[][] tablica) {
        boolean isRegular = true;
        int lengthAtStart = tablica[0].length;
        int length = 0;
        for (int i = 0; i < tablica.length; i++) {
            length = tablica[i].length;
            if (lengthAtStart != length) {
                isRegular = false;
            }
        }
        if (!isRegular) {
            int max = 0;
            for (int i = 0; i < tablica.length; i++) {
                if (tablica[i].length > max) {
                    max = tablica[i].length;
                }
            }
            int tablica2[][] = new int[tablica.length][max];
            for (int i = 0; i < tablica.length; i++) {
                int temp = 0;
                for (int j = 0; j < tablica[i].length; j++) {
                    tablica2[i][j] = tablica[i][j];
                    temp = j;
                }

                for (int k = tablica[i].length; k < max; k++) {
                    tablica2[i][k] = tablica[i][temp];
                }
            }
            return tablica2;
        } else {
            int m = tablica.length;
            int n = tablica[0].length;

            int[][] transponowana = new int[n][m];

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    transponowana[x][y] = tablica[y][x];
                }
            }

            return transponowana;
        }
    }

    public void drukujTablice(int[][] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            System.out.println();
            for (int j = 0; j < tablica[i].length; j++) {
                System.out.print(tablica[i][j] + " ");
            }
        }
    }
}
