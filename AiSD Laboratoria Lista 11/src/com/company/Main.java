package com.company;

public class Main {

    public static void main(String[] args) {
        Operations operations = new Operations();
        RedBlackTree<String> redBlackTree = operations.getFileString(operations.scan());
        System.out.println("Rozmiar drzewa to " + redBlackTree.size());

        System.out.println("\nUSUWAMY WEZEL w \n");
        redBlackTree.remove("w");
        redBlackTree.inOrderHelper();
        System.out.println("Rozmiar drzewa to " + redBlackTree.size());
        System.out.println("\nDRZEWO WSZERZ\n");
        redBlackTree.wszerz();


    }
}
