package com.company;

public class Zegar {
    private int minuta = 0;
    private int sekunda = 0;
    private int godzina = 0;

    Zegar(int godzina, int minuta, int sekunda) {
        if (sekunda < 60) {
            this.sekunda = sekunda;
        }
        if (minuta < 60) {
            this.minuta = minuta;
        }
        if (godzina < 60) {
            this.godzina = godzina;
        }
    }

    public void przesunOSekunde() {
        if (sekunda < 60) {
            sekunda++;
        } else {
            sekunda = 0;
            if (minuta == 59) {
                minuta = 0;
                if (godzina == 23) {
                    godzina = 0;
                } else godzina++;
            } else {
                minuta++;
            }
        }
    }

    public void przesunOMinute() {
        if (minuta == 59) {
            minuta = 0;
            if (godzina == 23) {
                godzina = 0;
            } else godzina++;
        } else minuta++;
    }

    public void przesunOGodzine() {
        if (godzina == 23) {
            godzina = 0;
        } else godzina++;
    }

    public int porownaj(Zegar zegar) {
        int diff = this.godzina - zegar.godzina;
        if (diff == 0) {
            diff = this.minuta - zegar.minuta;
            if (diff == 0) {
            }
        }
        if (diff == 0) {
            return diff;
        }
        return diff > 0 ? 1 : -1;
        }

        public void pokazPelnaGodzine () {
            if (godzina > 0) {
                System.out.println("Godzina: " + godzina + ":" + minuta + ":" + sekunda);
            } else {
                System.out.println("Godzina: 00:" + minuta + ":" + sekunda);
            }
        }

        public int getGodzina () {
            return godzina;
        }

        public int getMinuta () {
            return minuta;
        }

        public int getSekunda () {
            return sekunda;
        }

        @Override
        public String toString () {
            if (godzina < 10) {
                return "0" + godzina + ":" + minuta + ":" + sekunda;
            } else return godzina + ":" + minuta + ":" + sekunda;
        }
    }
