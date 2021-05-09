package com.java.practice.algorithms;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {1, 4, 2, 5, 7, 6, 10, 9};
        System.out.println("Merge sort uses divide and conquer method to solve it.");
        mergeSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }
    }

    public static void mergeSort(int[] a, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid + 1, h);
            merge(a, l, mid, h);
        }
    }

    public static void merge(int[] a, int l, int m, int h) {
        //int i = 0, j = 0, k = 0;

        int n1 = m - l + 1;
        int n2 = h - m;
        int[] x = new int[n1];
        int[] y = new int[n2];

        for (int i = 0; i < n1; ++i) {
            x[i] = a[l + i];
        }

        for (int j = 0; j < n2; ++j) {
            y[j] = a[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (x[i] <= y[j]) {
                a[k++] = x[i++];
            } else {
                a[k++] = y[j++];
            }
        }

        while(i < n1) {
            a[k++] = x[i++];
        }
        while(j < n2){
            a[k++] = y[j++];
        }

    }
}


