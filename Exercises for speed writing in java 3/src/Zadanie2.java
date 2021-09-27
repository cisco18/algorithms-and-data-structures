import java.util.Random;

public class Zadanie2 {

    public void zaokraglijTablice(int[][] tablica) {
        Random random = new Random();
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
        }
    }
    public int[][] stworz(int n, int k){
        int[][] tablica = new int[n][k];
    return tablica;
    }

    public int[][] wypelnijTablice(int[][] tablica) {
        Random random = new Random();
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[0].length; j++) {
                tablica[i][j] = random.nextInt(10);
            }

        }
        return tablica;
    }

    public void wyswietlTablice(int[][] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            System.out.println();
            for (int j = 0; j < tablica[0].length; j++) {
                System.out.print(tablica[i][j] + " ");
            }
        }
    }
}
