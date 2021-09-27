package com.company;

public class Czas {
    int godzina = 0;
    int minuta = 0;
    int sekunda = 0;

    Czas(int godzina, int minuta, int sekunda) {
        this.sekunda = sekunda;
        this.godzina = godzina;
        this.minuta = minuta;
    }


    public void dodajMinuty(int n) {
        if (n < 60) {
            if (minuta + n < 60) {
                minuta = minuta + n;
            } else {
                if (godzina == 23) {
                    godzina = 0;
                    minuta = minuta + n - 60;
                } else {
                    godzina++;
                    minuta = minuta + n - 60;
                }
            }
        } else {
            System.out.println("NIE MOZNA DODAC WIECEJ NIZ 59 MINUT");
        }
    }

    public void dodajGodziny(int n) {
        if (n < 24) {
            if (godzina == 23) {
                godzina = 0;
            } else {
                godzina += n;
            }
        } else {
            System.out.println("NIE MOZNA DODAC WIECEJ NIZ 23 GODZINY");
        }
    }

    public void dodajSekundy(int n) {
        if (n < 60) {
            if (sekunda + n < 60) {
                sekunda += n;
            } else {
                if (minuta != 59) {
                    sekunda = sekunda + n - 60;
                    minuta++;
                } else {
                    sekunda = sekunda + n - 60;
                    minuta = 0;
                    if (godzina == 23) {
                        godzina = 0;
                    } else {
                        godzina++;
                    }
                }
            }
        } else {
            System.out.println("NIE MOZNA DODAC WIECEJ NIZ 59 SEKUND");
        }
    }

    public int porownaj(Czas czas) {
        int diff = this.godzina - czas.godzina;
        if (diff == 0) {
            diff = this.minuta - czas.minuta;
            if (diff == 0) {
            }
        }
        if (diff == 0) {
            return diff;
        }
        return diff > 0 ? 1 : -1;
    }
}

