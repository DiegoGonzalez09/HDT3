package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmsTest {

    @Test
    void testInsertionSort() {
        Integer[] array = {5, 2, 9, 1, 5, 6};
        Integer[] expected = {1, 2, 5, 5, 6, 9};
        SortingAlgorithms.insertionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testMergeSort() {
        Integer[] array = {3, 7, 8, 5, 2, 1, 9, 5};
        Integer[] expected = {1, 2, 3, 5, 5, 7, 8, 9};
        SortingAlgorithms.mergeSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testQuickSort() {
        Integer[] array = {10, 7, 8, 9, 1, 5};
        Integer[] expected = {1, 5, 7, 8, 9, 10};
        SortingAlgorithms.quickSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testRadixSort() {
        Integer[] array = {170, 45, 75, 90, 802, 24, 2, 66};
        Integer[] expected = {2, 24, 45, 66, 75, 90, 170, 802};
        SortingAlgorithms.radixSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testHeapSort() {
        Integer[] array = {4, 10, 3, 5, 1};
        Integer[] expected = {1, 3, 4, 5, 10};
        SortingAlgorithms.heapSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testBucketSort() {
        Integer[] array = {78, 17, 39, 26, 72, 94, 21, 12, 23, 68};
        Integer[] expected = {12, 17, 21, 23, 26, 39, 68, 72, 78, 94};
        SortingAlgorithms.bucketSort(array);
        assertArrayEquals(expected, array);
    }
}
