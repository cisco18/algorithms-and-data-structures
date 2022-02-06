package com.company;

import java.util.ArrayList;

public class SortClass {

    public int[] shellSortFullInsert(int[] array, int[] gapArray) {
        Operations o = new Operations();
        long start = System.nanoTime();
        int n = array.length;
        int z = gapArray.length-1;
        for (int gap;z>=0 ; z--) {
            gap = gapArray[z];
            for (int i = gap; i < n; i += 1) {
                int key = array[i];
                int j;

                for (j = i; j >= gap && array[j - gap] > key; j -= gap)
                    array[j] = array[j - gap];


                array[j] = key;
            }
        }
        long end = System.nanoTime() - start;
        System.out.println(end);
        return array;
    }

    public int[] shellSortBubbleEnd(int[] array) {
        long start = System.nanoTime();
        int n = array.length;
        for (int gap = n / 2; gap > 1; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int key = array[i];
                int j;


                for (j = i; j >= gap && array[j - gap] > key; j -= gap)
                    array[j] = array[j - gap];


                array[j] = key;
            }
        }
        for (int j = 0; j < n - 1; j++)
            if (array[j] > array[j + 1]) {

                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }


        long end = System.nanoTime() - start;
        System.out.println(end);
        return array;
    }

    public int[] shellSortBubbleEnd(int[] array, int[] gapArray) {
        long start = System.nanoTime();
        int n = array.length;
        int z = gapArray.length-1;
        for (int gap;z>1 ; z--) {
            gap = gapArray[z];
            for (int i = gap; i < n; i += 1) {
                int key = array[i];
                int j;


                for (j = i; j >= gap && array[j - gap] > key; j -= gap)
                    array[j] = array[j - gap];


                array[j] = key;
            }
        }
        for (int j = 0; j < n - 1; j++)
            if (array[j] > array[j + 1]) {

                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }


        long end = System.nanoTime() - start;
        System.out.println(end);
        return array;
    }


    public int[] shellSortBubbleStart(int[] array) {
        long start = System.nanoTime();
        int n = array.length;
        for (int i = 0; i < n - 1; i++)
            for (int gap = n/2; gap > 0; gap/=2){
                if (i + gap < n - 1) {
                    if (array[i] > array[i + gap]) {

                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                    }
                }
            }
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;


            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }


        long end = System.nanoTime() - start;
        System.out.println(end);
        return array;
    }

    public int[] shellSortBubbleStart(int[] array, int[] gapArray) {
        long start = System.nanoTime();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int z = gapArray.length-1;
            for (int gap;z>1 ; z--) {
                gap = gapArray[z];
                if (i + gap < n - 1) {
                    if (array[i] > array[i + gap]) {

                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                    }
                }
            }
        }
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;


            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }


        long end = System.nanoTime() - start;
        System.out.println(end);
        return array;
    }


    public int[] calculateGapA(int limit) {
        ArrayList<Integer> array = new ArrayList<>();
        int a = 1;
        int p = 1;
        while (a < limit) {
            array.add(a);
            a += Math.pow(3, p);
            p++;
        }
        int b = 0;
        int[] newArray = new int[array.size()];
        for (Integer i : array) {
            newArray[b] = i;
            b++;
        }
        return newArray;
    }

    public int[] calculateGapB(int limit) {
        ArrayList<Integer> array = new ArrayList<>();
        int a = 1;
        for (int i = 1; a < limit; i++) {
            a = (int) Math.pow(2, i) - 1;
            if (a < limit) {
                array.add(a);
            }
        }
        int b = 0;
        int[] newArray = new int[array.size()];
        for (Integer i : array) {
            newArray[b] = i;
            b++;
        }
        return newArray;
    }

    public int[] calculateGapC(int limit) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        int a = 1;
        for (int i = 1; a < limit; i++) {
            a = (int) Math.pow(2, i) + 1;
            if (a < limit) {
                array.add(a);
            }
        }
        int b = 0;
        int[] newArray = new int[array.size()];
        for (Integer i : array) {
            newArray[b] = i;
            b++;
        }
        return newArray;
    }

    public int[] calculateGapD(int limit) {
        ArrayList<Integer> array = new ArrayList<>();
        int fibo = 1;
        array.add(fibo);
        int before = 1;
        for (int i = 0; fibo < limit; i++) {
            array.add(fibo);
            int temp = fibo;
            fibo += before;
            before = temp;
        }
        int b = 0;
        int[] newArray = new int[array.size()];
        for (Integer i : array) {
            newArray[b] = i;
            b++;
        }
        return newArray;
    }

    public int[] calculateGapE(int limit) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = limit/2; i>0;i*=0.75){
            array.add(i);
        }
        int b = 0;
        int[] newArray = new int[array.size()];
        for (Integer i : array) {
            newArray[b] = i;
            b++;
        }
        return newArray;
    }


}
