package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Operations operations = new Operations();
        OneWayLinkedListWithHead<Card> list = operations.createList();
        operations.showList(list);
        System.out.println(list.size());
        operations.showAllOfColor(list, 1);
        operations.showAllOfValue(list, 3);
        list = operations.deleteNotShowed(list);
        operations.showList(list);
    }
}
