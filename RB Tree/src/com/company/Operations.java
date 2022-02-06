package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operations {
    public RedBlackTree<String> getFileString(String fileName) {

        try {
            List<HalfNode> temps = new ArrayList<>();
            Scanner inFile1 = new Scanner(new File(fileName));


            int i = 1;
            while (inFile1.hasNext()) {
                // String[] strings = inFile1.nextLine().replaceAll("\\.", " " ).replaceAll("\\,", " " ).replaceAll("\\-", " ").split("\\s+");
                String[] strings = inFile1.nextLine().replaceAll("\\-", " " ).split("[.,?! -  ]");
                for (String s : strings) {
                    System.out.println(s);
                    ArrayList<Integer> array = new ArrayList<>();
                    array.add(i);
                    HalfNode halfNode = new HalfNode(s, array);
                    boolean isInTheList = false;
                    if (temps.size() == 0) {
                        temps.add(halfNode);
                    } else {
                        HalfNode halfNodeToUse = null;
                        for (HalfNode halfNode1 : temps) {
                            if (halfNode.string.equals(halfNode1.string)) {
                                isInTheList = true;
                                halfNodeToUse = halfNode1;
                            }
                        }
                        if (isInTheList) {
                            array.addAll(halfNodeToUse.rowsArrayList);
                            HalfNode newHalfNode = new HalfNode(s, array);
                            temps.add(newHalfNode);
                            temps.remove(halfNodeToUse);
                            isInTheList = false;
                        } else {
                            temps.add(halfNode);
                        }
                    }
                }
                i++;

            }
            RedBlackTree<String> redBlackTree = new RedBlackTree<String>();
            for (HalfNode halfNode : temps) {
                if (halfNode.rowsArrayList!=null) {
                    redBlackTree.insert(halfNode.string, halfNode.rowsArrayList);
                }
            }

            redBlackTree.inOrderHelper();

            inFile1.close();
            return redBlackTree;
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println("BLAD DRZEWO NIE ZOSTALO UTWORZONE");
        return null;
    }

    public String scan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe pliku");
        return scanner.nextLine();
    }

    public String printACommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPodaj binarny kod do rozszyfrowania\n");
        return scanner.nextLine();
    }
}

/*
int[] firstArray = halfNode.rows;
                            int[] secondArray = halfNode1.rows;
                            int fal = firstArray.length;
                            int sal = secondArray.length;
                            int[] result = new int[fal + sal];
                            System.arraycopy(firstArray, 0, result, 0, fal);
                            System.arraycopy(secondArray, 0, result, fal, sal);
                            HalfNode newHalfNode = new HalfNode(s, result);
                            temps.remove(halfNode1);
                            temps.add(newHalfNode);
                            isInTheList = true;
                            System.out.println(halfNode.string + " " + halfNode.rows);
 */
