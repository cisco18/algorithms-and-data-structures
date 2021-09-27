package com.company;

import java.util.Scanner;

public class PunktyZaSlowo {
    private String wczytajSlowo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadz slowo");
        String line = scanner.nextLine();
        String slowa[] = line.split(" ");
        String slowo = slowa[0];
        return slowo;
    }

    private void policzPunktyZaSlowo(String slowo) {
        int punkty = 0;
        String litery[] = slowo.split("(?!^)");
        for (String litera : litery) {
            if (litera.toLowerCase().equals("a") || litera.toLowerCase().equals("e") || litera.toLowerCase().equals("i") || litera.toLowerCase().equals("n") || litera.toLowerCase().equals("o") ||
                    litera.toLowerCase().equals("r") || litera.toLowerCase().equals("s") || litera.toLowerCase().equals("w") || litera.toLowerCase().equals("z")) {
                punkty += 1;
            }
            if (litera.toLowerCase().equals("c") || litera.toLowerCase().equals("d") || litera.toLowerCase().equals("k") || litera.toLowerCase().equals("l") || litera.toLowerCase().equals("m") ||
                    litera.toLowerCase().equals("p") || litera.toLowerCase().equals("t") || litera.toLowerCase().equals("b")) {
                punkty += 2;
            }
            if (litera.toLowerCase().equals("g") || litera.toLowerCase().equals("h") || litera.toLowerCase().equals("j") || litera.toLowerCase().equals("u") || litera.toLowerCase().equals("y")) {
                punkty += 3;
            }
            if (litera.toLowerCase().equals("f") || litera.toLowerCase().equals("x") || litera.toLowerCase().equals("q") || litera.toLowerCase().equals("v")) {
                punkty += 5;
            }

        }
        System.out.println("PUNKTY: " + punkty);
    }

    public void rozpocznijGre() {
        policzPunktyZaSlowo(wczytajSlowo());

    }
}

