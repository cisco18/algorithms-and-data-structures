package com.company;

import java.util.Objects;

public class Card {
   private int value;
   private int color;


   public Card(int value, int color){
       this.color = color;
       this.value = value;

   }

    public int getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    public int compare(Card card){
       if (value== card.getValue()){
            return color-card.getColor();
       }else return value- card.getValue();
    }


    @Override
    public String toString() {
        String colorString = "Podano Niewlasciwy numer(Prawidlowe to 0,1,2,3)";
        String valueString = "Podano Niewlasciwy numer(Prawidlowe to 1-13)";
        switch (color){
            case 0:
                colorString = "kier";
                break;
            case 1:
                colorString = "karo";
                break;
            case 2:
                colorString = "trefl";
                break;
            case 3:
                colorString = "pik";
                break;
        }
        switch (value){
            case 1:
                valueString = "as";
                break;
            case 2:
                valueString = "dwa";
                break;
            case 3:
                valueString = "trzy";
                break;
            case 4:
                valueString = "cztery";
                break;
            case 5:
                valueString = "piec";
                break;
            case 6:
                valueString = "szesc";
                break;
            case 7:
                valueString = "siedem";
                break;
            case 8:
                valueString = "osiem";
                break;
            case 9:
                valueString = "dziewiec";
                break;
            case 10:
                valueString = "dziesiec";
                break;
            case 11:
                valueString = "jopek";
                break;
            case 12:
                valueString = "dama";
                break;
            case 13:
                valueString = "krol";
                break;
        }
        return valueString + " " + colorString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && color == card.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, color);
    }
}

