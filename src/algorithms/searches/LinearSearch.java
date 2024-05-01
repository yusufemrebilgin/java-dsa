package algorithms.searches;

import common.util.ArrayUtil;

import java.util.Arrays;

public class LinearSearch {

    public static void main(String[] args) {
        // Getting a random array of the given size and between 0 to given bound
        int[] array = ArrayUtil.generateRandomArray(30, 0, 100);

        System.out.println(Arrays.toString(array));

        int number = 30;
        int returnedIndex = linearSearch(array, number);

        if (returnedIndex != -1) {
            System.out.format("The number %d was found at the index %d\n", number, returnedIndex);
        } else {
            System.out.format("The number %d was not found\n", number);
        }

        number = array[4];
        System.out.println();
        System.out.println("Array after calling linear search with transposition method 3 times for " + number);
        for (int i = 0; i < 3; i++)
            linearSearchWithTranspositionMethod(array, number);

        System.out.println(Arrays.toString(array));

    }

    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return i;
        }
        return -1;
    }

    public static int linearSearchWithTranspositionMethod(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key && i > 0) {
                ArrayUtil.swap(array, i, i - 1); // Transposition
                return i;
            }
        }
        return -1;
    }

}
