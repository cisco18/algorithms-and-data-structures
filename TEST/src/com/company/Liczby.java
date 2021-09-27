package com.company;

import java.util.ArrayList;

public class Liczby {
    //HUBERT BUDNY
    public int obliczSumeCyfr(int liczbaCalkowita){
        String liczbaString = String.valueOf(liczbaCalkowita);
        String cyfry[] = liczbaString.split("(?!^)");
        int sum = 0;
        for (String cyfra: cyfry){
           int cyfraInt = Integer.parseInt(cyfra);
           sum = sum + cyfraInt;
        }
        return sum;
    }

    public void wypiszWszystkieCzteroCyfroweParzystaSuma(){
        int ileJestTakichCyfr = 0;
        int minimum = 1000;
        int maximum = 9999;
        ArrayList<Integer> liczbyZgodne = new ArrayList<>();
        for (int i = minimum; i<maximum;i++){
            if (obliczSumeCyfr(i) %2 == 0){
                liczbyZgodne.add(i);
                ileJestTakichCyfr++;
            }
        }
        wydrukujArray(liczbyZgodne);
        System.out.println("\nTakich liczb jest: " + ileJestTakichCyfr);
    }

    private void wydrukujArray(ArrayList<Integer> arrayList){
        int limit = 0;
        for (int liczba : arrayList){
            System.out.print(liczba + "  ");
            limit++;
            if (limit == 10){
                System.out.println();
                limit = 0;
            }
        }
        System.out.println();
    }
}
