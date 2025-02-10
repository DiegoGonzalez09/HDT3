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


    private static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void radixSort(Integer[] arr) {
        if (arr == null || arr.length == 0) return;

        // Encontrar el número máximo para saber el número de dígitos
        int max = Arrays.stream(arr).max(Integer::compareTo).orElse(0);

        // Usar array temporal de Integer en lugar de int
        Integer[] output = new Integer[arr.length];

        // Hacer counting sort para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            int[] count = new int[10];

            // Almacenar conteo de ocurrencias
            for (Integer num : arr) {
                count[(num / exp) % 10]++;
            }

            // Cambiar count[i] para contener la posición actual del dígito en output[]
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // Construir el array de salida
            for (int i = arr.length - 1; i >= 0; i--) {
                int digit = (arr[i] / exp) % 10;
                output[count[digit] - 1] = arr[i];
                count[digit]--;
            }

            // Copiar el array de salida a arr[] para tener los números ordenados según el dígito actual
            System.arraycopy(output, 0, arr, 0, arr.length);
        }
    }

    public static void bucketSort(Integer[] arr) {
        if (arr.length == 0) return;

        int max = Arrays.stream(arr).max(Integer::compare).orElse(0);
        int min = Arrays.stream(arr).min(Integer::compare).orElse(0);
        int bucketCount = (max - min) / arr.length + 1;

        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++)
            buckets.add(new ArrayList<>());

        for (int num : arr) {
            int index = (num - min) / arr.length;
            buckets.get(index).add(num);
        }

        int idx = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[idx++] = num;
            }
        }
    }

    public static void heapSort(Integer[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(Integer[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
}
