package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Operations operations = new Operations();
        ArrayList<Card> list = operations.createList();
        operations.showList(list);
        operations.showNumberOfElements(list);
        operations.showAllOfColor(list, 1);
        operations.showAllOfValue(list, 3);
        operations.add(new Card(1, 0), list);
        operations.add(new Card(1, 0), list);
        operations.add(new Card(1, 0), list);
        operations.showList(list);

        list = operations.deleteDuplicates(list);
        operations.showList(list);


    }
}
