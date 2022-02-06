package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.Callable;

public class Operations {


    public ArrayList<Card> createList() {
        ArrayList<Card> list = new ArrayList<>();
        Random random = new Random();
        boolean goOn = true;
        while (goOn) {
            int value = random.nextInt(14);
            if (value == 0) {
                goOn = false;
            } else {
                int color = random.nextInt(4);
                Card card = new Card(value, color);
                add(card, list);
            }
        }
        return list;
    }


    public void add(Card card, ArrayList<Card> arrayList) {
        boolean ended = false;
        for (Card card1 : arrayList) {
            if (card1.compare(card) == 0) {
                int index = arrayList.indexOf(card1);
                arrayList.add(index, card);
                ended = true;
                break;
            }
        }
        if (arrayList.size() >= 2 && !ended) {
            boolean highest = true;
            boolean lowest = true;
            for (Card card1 : arrayList) {
                if (card.compare(card1) > 0) {
                    highest = false;
                }
                if (card.compare(card1) < 0) {
                    lowest = false;
                }
            }
            if (highest) {
                arrayList.add(card);
            } else if (lowest) {
                arrayList.add(0, card);
            } else {
                for (int i = 0; i < arrayList.size() - 1; i++) {
                    if (card.compare(arrayList.get(i)) > 0 && card.compare(arrayList.get(i + 1)) < 0) {
                        arrayList.add(i + 1, card);
                    }
                }
            }
        }
        if (arrayList.size() == 1 && !ended) {
            if (arrayList.get(0).compare(card) > 0) {
                arrayList.add(1, card);
            } else if (arrayList.get(0).compare(card) < 0) {
                arrayList.add(0, card);
            }
        }

        if (arrayList.size() == 0 && !ended) {
            arrayList.add(card);

        }
    }


    public void showList(ArrayList<Card> arrayList) {
        System.out.println("Lista prezentuje sie nastepujaco:");
        Iterator<Card> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

    }

    public void showNumberOfElements(ArrayList<Card> arrayList) {
        System.out.println("LICZBA ELEMENTOW: " + arrayList.size() + "\n");
    }

    public void showAllOfValue(ArrayList<Card> arrayList, int value) {
        if (value > 1 && value < 11) {
            System.out.println("Wszystkie karty o wartosci " + value);
        } else {
            switch (value) {
                case 1:
                    System.out.println("Wszystkie asy");
                    break;
                case 11:
                    System.out.println("Wszystkie jopki");
                    break;
                case 12:
                    System.out.println("Wszystkie damy");
                    break;
                case 13:
                    System.out.println("Wszyscy krolowie");
                    break;
            }
        }
        Iterator<Card> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Card card = (Card) iterator.next();
            if (card.getValue() == value) {
                System.out.println(card.toString());
            }
        }
        System.out.println();
    }

    public void showAllOfColor(ArrayList<Card> arrayList, int color) {
        System.out.print("Wszystkie karty o kolorze ");
        switch (color) {
            case 0:
                System.out.println("kier:");
                break;
            case 1:
                System.out.println("karo:");
                break;
            case 2:
                System.out.println("trefl:");
                break;
            case 3:
                System.out.print("pik:");
                break;
        }

        Iterator<Card> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Card card = (Card) iterator.next();
            if (card.getColor() == color) {
                System.out.println(card.toString());
            }
        }
        System.out.println();
    }


    public ArrayList<Card> deleteDuplicates(ArrayList<Card> arrayList) {
        Iterator<Card> iterator = arrayList.iterator();
        ArrayList<Card> arrayListNoDuplicates = new ArrayList<Card>();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            if (!arrayListNoDuplicates.contains(card)) {
                add(card, arrayListNoDuplicates);
            }
        }


        return arrayListNoDuplicates;
    }
}







