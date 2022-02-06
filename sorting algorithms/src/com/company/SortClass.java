package com.company;

import java.util.Random;

public class SortClass {
    public void insertSort(int[] array) {
        long start = System.nanoTime();
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;


            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        long end = System.nanoTime();
        System.out.println("insert sort took " + (end - start) + " miliseconds");
    }

    public void bubbleSort(int[] arr) {
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        long end = System.nanoTime();
        System.out.println("bubble sort took " + (end - start) + " miliseconds");
    }

    public void selectSort(int[] arr) {
        long start = System.nanoTime();
        int n = arr.length;


        for (int i = 0; i < n - 1; i++) {

            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;


            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
        long end = System.nanoTime();
        System.out.println("select sort took " + (end - start) + " miliseconds");
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    static int partition(int[] arr, int low, int high) {


        int pivot = arr[high];


        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {


            if (arr[j] < pivot) {


                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }



    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);


            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    void merge(int arr[], int l, int m, int r) {

        //1 array ma indeksy od l do m
        //2 array ma indeksy od m+1 do r
        int n1 = m - l + 1;
        int n2 = r - m;


        int[] L = new int[n1];
        int[] R = new int[n2];


        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;


        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

//pozostale elementy L kopiujemy
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

//pozostale elementy R kopiujemy
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    void mergeSort(int arr[], int l, int r) {
        if (l < r) {

            int m = l + (r - l) / 2;


            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);


            merge(arr, l, m, r);
        }

    }

    public void heapSort(int arr[]) {
        long start = System.nanoTime();
        int n = arr.length;


        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);


        for (int i = n - 1; i > 0; i--) {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr, i, 0);
        }
        long end = System.nanoTime();
        System.out.println("heap sort took " + (end - start) + " miliseconds");
    }


    void heapify(int arr[], int n, int i) {
        int largest = i; // najwiekszy element to korzen
        int l = 2 * i + 1; // prawy = 2*i + 1
        int r = 2 * i + 2; // lewy = 2*i + 2


        if (l < n && arr[l] > arr[largest])
            largest = l;


        if (r < n && arr[r] > arr[largest])
            largest = r;


        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;


            heapify(arr, n, largest);
        }
    }

    public void quickSortWithPrinting(int[] arr){
        long start = System.nanoTime();
        quickSort(arr, 0, arr.length-1);
        long end = System.nanoTime();
        System.out.println("quick sort took " + (end - start) + " miliseconds");
    }
    public void mergeSortWithPrinting(int[] arr){
        long start = System.nanoTime();
        mergeSort(arr, 0,(arr.length-1));
        long end = System.nanoTime();
        System.out.println("merge sort took " + (end - start) + " miliseconds");

    }


}
