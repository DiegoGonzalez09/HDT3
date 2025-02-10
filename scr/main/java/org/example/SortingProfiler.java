package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortingProfiler {
    public static Map<String, Long> runProfiler(Integer[] array, int iterations) {
        Map<String, Long> results = new HashMap<>();

        // Crear copias del array para cada algoritmo
        Integer[] insertionArray = Arrays.copyOf(array, array.length);
        Integer[] mergeArray = Arrays.copyOf(array, array.length);
        Integer[] quickArray = Arrays.copyOf(array, array.length);
        Integer[] radixArray = Arrays.copyOf(array, array.length);
        Integer[] bucketArray = Arrays.copyOf(array, array.length);
        Integer[] heapArray = Arrays.copyOf(array, array.length);

        // Probar Insertion Sort
        long startTime = System.nanoTime();
        SortingAlgorithms.insertionSort(insertionArray);
        results.put("Insertion Sort", System.nanoTime() - startTime);

        // Probar Merge Sort
        startTime = System.nanoTime();
        SortingAlgorithms.mergeSort(mergeArray);
        results.put("Merge Sort", System.nanoTime() - startTime);

        // Probar Quick Sort
        startTime = System.nanoTime();
        SortingAlgorithms.quickSort(quickArray);
        results.put("Quick Sort", System.nanoTime() - startTime);

        // Probar Radix Sort
        startTime = System.nanoTime();
        SortingAlgorithms.radixSort(radixArray);
        results.put("Radix Sort", System.nanoTime() - startTime);

        // Probar Bucket Sort
        startTime = System.nanoTime();
        SortingAlgorithms.bucketSort(bucketArray);
        results.put("Bucket Sort", System.nanoTime() - startTime);

        // Probar Heap Sort
        startTime = System.nanoTime();
        SortingAlgorithms.heapSort(heapArray);
        results.put("Heap Sort", System.nanoTime() - startTime);

        return results;
    }
}
