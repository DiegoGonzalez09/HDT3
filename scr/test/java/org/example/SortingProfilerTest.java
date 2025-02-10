package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

class SortingProfilerTest {
    @Test
    void testRunProfiler() {
        // Preparar datos de prueba
        Integer[] testArray = new Integer[]{64, 34, 25, 12, 22, 11, 90};
        int iterations = 1;

        // Ejecutar el profiler
        Map<String, Long> results = SortingProfiler.runProfiler(testArray, iterations);

        // Verificar que todos los algoritmos están incluidos
        assertTrue(results.containsKey("Insertion Sort"), "Results should contain key for: Insertion Sort");
        assertTrue(results.containsKey("Merge Sort"), "Results should contain key for: Merge Sort");
        assertTrue(results.containsKey("Quick Sort"), "Results should contain key for: Quick Sort");
        assertTrue(results.containsKey("Radix Sort"), "Results should contain key for: Radix Sort");
        assertTrue(results.containsKey("Bucket Sort"), "Results should contain key for: Bucket Sort");
        assertTrue(results.containsKey("Heap Sort"), "Results should contain key for: Heap Sort");

        // Verificar que los tiempos son positivos
        for (Long time : results.values()) {
            assertTrue(time >= 0, "Execution time should be non-negative");
        }
    }

    @Test
    void testRunProfilerWithEmptyArray() {
        // Probar con array vacío
        Integer[] emptyArray = new Integer[0];
        Map<String, Long> results = SortingProfiler.runProfiler(emptyArray, 1);

        // Verificar que todos los algoritmos están incluidos incluso con array vacío
        assertNotNull(results);
        assertFalse(results.isEmpty());
    }

    @Test
    void testRunProfilerWithSingleElement() {
        // Probar con array de un elemento
        Integer[] singleElementArray = new Integer[]{1};
        Map<String, Long> results = SortingProfiler.runProfiler(singleElementArray, 1);

        // Verificar que todos los algoritmos están incluidos
        assertNotNull(results);
        assertFalse(results.isEmpty());
    }
}
