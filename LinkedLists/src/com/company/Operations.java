package com.company;

import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Operations {

    public OneWayLinkedListWithHead<Card> createList() {
        OneWayLinkedListWithHead<Card> list = new OneWayLinkedListWithHead<>();
        int goOnCount = 0;
        boolean arrayB[] = new boolean[52];
        while (goOnCount < 2) {
            Random random = new Random();
            int value = random.nextInt(15);
            if (value == 0) {
                goOnCount++;
            } else {
                int color = random.nextInt(4);
                if (value != 14) {
                    Card card = new Card(value, color);
                    if (!arrayB[(color*13)*value){
                        add(list, card);
                        arrayB[(color*13)*value] = true;
                    }
                }else {
                    Card card = new Card(value, -1);
                    add(list, card);
                }
                }
            }


        return list;
    }




    public void showList(OneWayLinkedListWithHead<Card> list) {
        System.out.println("Lista prezentuje sie nastepujaco:");
        int showed = 0;
        Iterator<Card> iterator = list.iterator();
        while (iterator.hasNext()) {
            Card card = iterator.next();
            System.out.println(card);
            if (card.getValue() != 14) {
                showed++;
            }
        }
        System.out.println("liczba kart zakrytych = " + (list.size() - showed));
        System.out.println("liczba odkrytych kart = " + showed);
        System.out.println();

    }

    public void add(OneWayLinkedListWithHead<Card> list, Card card) {
        boolean ended = false;
        for (Card card1 : list) {
            if (card1.compare(card) == 0) {
                int index = list.indexOf(card1);
                list.add(index, card);
                ended = true;
                break;
            }
        }
        if (list.size() >= 2 && !ended) {
            boolean highest = true;
            boolean lowest = true;
            for (Card card1 : list) {
                if (card.compare(card1) < 0) {
                    highest = false;
                }
                if (card.compare(card1) > 0) {
                    lowest = false;
                }
            }
            if (lowest) {
                list.add(card);
            } else if (highest) {
                list.add(0, card);
            } else {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (card.compare(list.get(i)) > 0 && card.compare(list.get(i + 1)) < 0) {
                        list.add(i + 1, card);
                    }
                }
            }
        }
        if (list.size() == 1 && !ended) {
            if (list.get(0).compare(card) > 0) {
                list.add(1, card);
            } else if (list.get(0).compare(card) < 0) {
                list.add(0, card);
            }
        }

        if (list.size() == 0 && !ended) {
            list.add(card);

        }
    }


    public OneWayLinkedListWithHead<Card> deleteNotShowed(OneWayLinkedListWithHead<Card> list){
        OneWayLinkedListWithHead<Card> list2 = new OneWayLinkedListWithHead<>();
        for (Card card: list){
            if(card.getValue() != 14){
                add(list2, card);
            }
        }
        return list2;
    }

    public void showAllOfValue(OneWayLinkedListWithHead<Card> oneWayLinkedListWithHead, int value) {
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
                case 14:
                    System.out.println("Wszystkie karty zakryte");
            }
        }
        Iterator<Card> iterator = oneWayLinkedListWithHead.iterator();
        while (iterator.hasNext()) {
            Card card = (Card) iterator.next();
            if (card.getValue() == value) {
                System.out.println(card.toString());
            }
        }
        System.out.println();
    }

    public void showAllOfColor(OneWayLinkedListWithHead<Card> oneWayLinkedListWithHead, int color) {
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

        Iterator<Card> iterator = oneWayLinkedListWithHead.iterator();
        while (iterator.hasNext()) {
            Card card = (Card) iterator.next();
            if (card.getColor() == color && card.getValue() != 14) {
                System.out.println(card.toString());
            }
        }
        System.out.println();
    }

    private void checkForDuplicate(OneWayLinkedListWithHead<Card> list, Card card) {
        boolean array[][] = new boolean[4][13];
        for (Card card1 : list) {
            array[card1.getColor()][card1.getValue()] = true;
        }
    }
}


