
package org.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        SortingAlgorithms sorter = new SortingAlgorithms(); // Única instancia

        // Tamaños de arrays a probar
        final int[] sizes = {10, 100, 500, 1000, 2000, 3000};

        for (int size : sizes) {
            System.out.println("Testing with size: " + size);

            // Generar números aleatorios
            sorter.generateRandomNumbers(size);

            // Probar cada algoritmo
            testAlgorithm("Insertion Sort", sorter, SortingAlgorithms::insertionSort);
            testAlgorithm("Merge Sort", sorter, SortingAlgorithms::mergeSort);
            testAlgorithm("Quick Sort", sorter, SortingAlgorithms::quickSort);
            testAlgorithm("Radix Sort", sorter, SortingAlgorithms::radixSort);
            testAlgorithm("Bucket Sort", sorter, SortingAlgorithms::bucketSort);
            testAlgorithm("Heap Sort", sorter, SortingAlgorithms::heapSort);

            System.out.println();
        }
    }
