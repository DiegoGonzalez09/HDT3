package org.example;

import org.example.Utils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testIsSorted() {
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        Integer[] unsortedArray = {5, 3, 4, 1, 2};
        assertTrue(Utils.isSorted(sortedArray));
        assertFalse(Utils.isSorted(unsortedArray));
    }

    @Test
    void testGenerateRandomArray() {
        Integer[] array = Utils.generateRandomArray(10);
        assertNotNull(array);
        assertEquals(10, array.length); // Asegura que el tamaño sea correcto
    }

    @Test
    void testSaveAndLoadArrayFromFile() throws IOException {
        Integer[] array = {10, 20, 30, 40, 50};
        String testFilePath = "test-numbers.txt";

        try {
            Utils.saveArrayToFile(array, testFilePath);
            Integer[] loadedArray = Utils.loadArrayFromFile(testFilePath);

            assertNotNull(loadedArray);
            assertArrayEquals(array, loadedArray);

        } finally {
            // Limpiar el archivo de prueba
            File file = new File(testFilePath);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
