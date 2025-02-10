package org.example;

import java.io.IOException;
import java.util.*;

public class SortingAlgorithms {
    private static final String FILE_PATH = "numbers.txt";

    public void generateRandomNumbers(int count) throws IOException {
        Integer[] randomArray = Utils.generateRandomArray(count);
        Utils.saveArrayToFile(randomArray, FILE_PATH);
    }

    public Integer[] readNumbersFromFile() {
        return Utils.loadArrayFromFile(FILE_PATH);
    }

    public static void insertionSort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(Integer[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        Integer[] left = Arrays.copyOfRange(arr, 0, mid);
        Integer[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(Integer[] arr, Integer[] left, Integer[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = left[i] <= right[j] ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }

    public static void quickSort(Integer[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
