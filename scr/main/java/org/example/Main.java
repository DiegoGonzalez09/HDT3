
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

    private static void testAlgorithm(String name, SortingAlgorithms sorter, SortingFunction algorithm) {
        // Leer números originales del archivo
        Integer[] numbersOriginal = sorter.readNumbersFromFile();
        if (numbersOriginal == null) {
            System.err.println("Could not read numbers for sorting!");
            return;
        }

        // Crear una copia para cada algoritmo
        Integer[] numbersToSort = Arrays.copyOf(numbersOriginal, numbersOriginal.length);

        // Medir tiempo de ejecución
        System.gc(); // Limpiar memoria para evitar interferencias
        long startTime = System.nanoTime();
        algorithm.sort(numbersToSort);
        long endTime = System.nanoTime();

        // Calcular tiempo en milisegundos
        double timeInMs = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.printf("%s: %.2f ms%n", name, timeInMs);

        // Verificar si está ordenado
        boolean isSorted = Utils.isSorted(numbersToSort);
        System.out.println("Is sorted: " + isSorted);
    }
}

@FunctionalInterface
interface SortingFunction {
    void sort(Integer[] arr);
}
