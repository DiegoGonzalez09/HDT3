package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class Utils {

    public static void saveArrayToFile(Integer[] array, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Integer num : array) {
                writer.write(num.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + fileName);
            e.printStackTrace();
        }
    }

    public static Integer[] loadArrayFromFile(String fileName) {
        try {
            if (!Files.exists(Paths.get(fileName))) {
                System.err.println("File not found: " + fileName);
                return new Integer[0];
            }
            return Files.lines(Paths.get(fileName))
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading file: " + fileName);
            e.printStackTrace();
            return new Integer[0];
        }
    }

    public static Integer[] generateRandomArray(int size) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }

    public static boolean isSorted(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
