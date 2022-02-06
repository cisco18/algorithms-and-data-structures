package com.company;

public class Main {

    public static void main(String[] args) {

        Operations operations = new Operations();
        SortClass sortClass = new SortClass();
        int[] array1A = operations.createTableUnsorted(100000);
        array1A = sortClass.shellSortFullInsert(array1A, sortClass.calculateGapA(array1A.length));
        //operations.printArray(array1A);


        int[] array1B = operations.createTableUnsorted(100000);
        array1B = sortClass.shellSortFullInsert(array1B, sortClass.calculateGapB(array1B.length));
        //operations.printArray(array1B);

        int[] array1C = operations.createTableUnsorted(100000);
        array1C = sortClass.shellSortFullInsert(array1C, sortClass.calculateGapC(array1C.length));
        //operations.printArray(array1C);

        int[] array1D = operations.createTableUnsorted(100000);
        array1D = sortClass.shellSortFullInsert(array1D, sortClass.calculateGapD(array1D.length));
       // operations.printArray(array1D);


        int[] array2A = operations.createTableUnsorted(100000);
        array2A = sortClass.shellSortBubbleEnd(array2A, sortClass.calculateGapD(array2A.length));
        //operations.printArray(array2A);


        int[] array2B = operations.createTableUnsorted(100000);
        array2B = sortClass.shellSortBubbleEnd(array2B, sortClass.calculateGapB(array2B.length));
        //operations.printArray(array2B);

        int[] array2C = operations.createTableUnsorted(100000);
        array2C = sortClass.shellSortBubbleEnd(array2C, sortClass.calculateGapC(array2C.length));
        //operations.printArray(array2C);

        int[] array2D = operations.createTableUnsorted(100000);
        array2D = sortClass.shellSortBubbleEnd(array2D, sortClass.calculateGapD(array2D.length));
        //operations.printArray(array2D);

        int[] array3A = operations.createTableUnsorted(100000);
        array3A = sortClass.shellSortBubbleStart(array3A, sortClass.calculateGapA(array3A.length));
        //operations.printArray(array3A);

        int[] array3B = operations.createTableUnsorted(100000);
        array3B = sortClass.shellSortBubbleStart(array3B, sortClass.calculateGapB(array3B.length));
        //operations.printArray(array3B);

        int[] array3C = operations.createTableUnsorted(100000);
        array3C = sortClass.shellSortBubbleStart(array3C, sortClass.calculateGapC(array3C.length));
       // operations.printArray(array3C);

        int[] array3D = operations.createTableUnsorted(100000);
        array3D = sortClass.shellSortBubbleStart(array3D, sortClass.calculateGapD(array3D.length));
       // operations.printArray(array3D);

        int[] array1E = operations.createTableUnsorted(100000);
        array1E = sortClass.shellSortBubbleEnd(array1E, sortClass.calculateGapD(array1E.length));

        int[] array2E = operations.createTableUnsorted(100000);
        array2E = sortClass.shellSortBubbleEnd(array2E, sortClass.calculateGapD(array2E.length));


        int[] array3E = operations.createTableUnsorted(100000);
        array3E = sortClass.shellSortBubbleStart(array3E, sortClass.calculateGapD(array3E.length));



        int[] arrayFibo = sortClass.calculateGapC(10000);
        operations.printArray(arrayFibo);


        int[] arrayB = sortClass.calculateGapB(10000);
        operations.printArray(arrayB);

        int[] arrayA = sortClass.calculateGapA(10000);
        operations.printArray(arrayA);

        int[] arrayD = sortClass.calculateGapD(10000);
        operations.printArray(arrayD);



    }


}


