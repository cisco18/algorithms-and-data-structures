package com.company;

public class Main {

    public static void main(String[] args) {
        Operations operations = new Operations();
        SortClass sortClass = new SortClass();
        /*
        int[] tableA = operations.createTableUnsorted(100000);
        sortClass.insertSort(tableA);
        //operations.printArray(tableA);
        int[] tableA2 = operations.createTableSortedGrowing(100000);
        sortClass.insertSort(tableA2);
        //operations.printArray(tableA2);
        int[] tableA3 = operations.createTableSortedDecreasing(100000);
        sortClass.insertSort(tableA3);
        //operations.printArray(tableA3);

        System.out.println();

        int[] tableB = operations.createTableUnsorted(100000);
        sortClass.selectSort(tableB);
        //operations.printArray(tableB);
        int[] tableB2 = operations.createTableSortedGrowing(100000);
        sortClass.selectSort(tableB2);
        //operations.printArray(tableB2);
        int[] tableB3 = operations.createTableSortedDecreasing(100000);
        sortClass.selectSort(tableB3);
        //operations.printArray(tableB3);

        System.out.println();

        int[] tableC = operations.createTableUnsorted(100000);
        sortClass.bubbleSort(tableC);
        //operations.printArray(tableC);
        int[] tableC2 = operations.createTableSortedGrowing(100000);
        sortClass.bubbleSort(tableC2);
        //operations.printArray(tableC2);
        int[] tableC3 = operations.createTableSortedDecreasing(100000);
        sortClass.bubbleSort(tableC3);
        //operations.printArray(tableC3);

        System.out.println();

        int[] tableD = operations.createTableUnsorted(100000);
        sortClass.quickSortWithPrinting(tableD);
       //operations.printArray(tableD);
        int[] tableD1 = operations.createTableUnsorted(100000);
        sortClass.quickSortWithPrinting(tableD1);
        //operations.printArray(tableD1);
        int[] tableD2 = operations.createTableUnsorted(100000);
        sortClass.quickSortWithPrinting(tableD2);
        //operations.printArray(tableD2);

        System.out.println();

        int[] tableE = operations.createTableUnsorted(100000);
        sortClass.mergeSortWithPrinting(tableE);
        //operations.printArray(tableE);
        int[] tableE1 = operations.createTableUnsorted(100000);
        sortClass.mergeSortWithPrinting(tableE1);
        //operations.printArray(tableE1);
        int[] tableE2 = operations.createTableUnsorted(100000);
        sortClass.mergeSortWithPrinting(tableE2);
        //operations.printArray(tableE2);

        System.out.println();

        int[] tableF = operations.createTableUnsorted(100000);
        sortClass.heapSort(tableF);
        //operations.printArray(tableF);
        int[] tableF1 = operations.createTableUnsorted(100000);
        sortClass.heapSort(tableF1);
        //operations.printArray(tableF1);
        int[] tableF2 = operations.createTableUnsorted(100000);
        sortClass.heapSort(tableF2);
        //operations.printArray(tableF2);


         */
        int[] tableA = operations.createTableUnsorted(10000);
        sortClass.insertSort(tableA);
        operations.printArray(tableA);
        int[] tableA2 = operations.createTableSortedGrowing(10000);
        sortClass.insertSort(tableA2);
        //operations.printArray(tableA2);
        int[] tableA3 = operations.createTableSortedDecreasing(10000);
        sortClass.insertSort(tableA3);
        //operations.printArray(tableA3);

        System.out.println();

        int[] tableB = operations.createTableUnsorted(10000);
        sortClass.selectSort(tableB);
        //operations.printArray(tableB);
        int[] tableB2 = operations.createTableSortedGrowing(10000);
        sortClass.selectSort(tableB2);
        //operations.printArray(tableB2);
        int[] tableB3 = operations.createTableSortedDecreasing(10000);
        sortClass.selectSort(tableB3);
        //operations.printArray(tableB3);

        System.out.println();

        int[] tableC = operations.createTableUnsorted(10000);
        sortClass.bubbleSort(tableC);
        //operations.printArray(tableC);
        int[] tableC2 = operations.createTableSortedGrowing(10000);
        sortClass.bubbleSort(tableC2);
        //operations.printArray(tableC2);
        int[] tableC3 = operations.createTableSortedDecreasing(10000);
        sortClass.bubbleSort(tableC3);
        //operations.printArray(tableC3);

        System.out.println();

        int[] tableD = operations.createTableUnsorted(10000);
        sortClass.quickSortWithPrinting(tableD);
        //operations.printArray(tableD);
        int[] tableD1 = operations.createTableUnsorted(10000);
        sortClass.quickSortWithPrinting(tableD1);
        //operations.printArray(tableD1);
        int[] tableD2 = operations.createTableUnsorted(10000);
        sortClass.quickSortWithPrinting(tableD2);
        //operations.printArray(tableD2);

        System.out.println();

        int[] tableE = operations.createTableUnsorted(10000);
        sortClass.mergeSortWithPrinting(tableE);
        //operations.printArray(tableE);
        int[] tableE1 = operations.createTableUnsorted(10000);
        sortClass.mergeSortWithPrinting(tableE1);
        //operations.printArray(tableE1);
        int[] tableE2 = operations.createTableUnsorted(10000);
        sortClass.mergeSortWithPrinting(tableE2);
        //operations.printArray(tableE2);

        System.out.println();

        int[] tableF = operations.createTableUnsorted(10000);
        sortClass.heapSort(tableF);
        //operations.printArray(tableF);
        int[] tableF1 = operations.createTableUnsorted(10000);
        sortClass.heapSort(tableF1);
        //operations.printArray(tableF1);
        int[] tableF2 = operations.createTableUnsorted(10000);
        sortClass.heapSort(tableF2);
        //operations.printArray(tableF2);


    }


}
