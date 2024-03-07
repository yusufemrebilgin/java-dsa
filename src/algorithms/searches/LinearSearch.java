package algorithms.searches;

import java.util.Random;

public class LinearSearch {

    public static void main(String[] args) {
        // Getting a random array of the given size and between 0 to given bound
        int[] array = getRandomArray(30, 100);

        printArray(array);

        int number = 30;
        int returnedIndex = linearSearch(array, number);

        if (returnedIndex != -1) {
            System.out.format("The number %d was found at the index %d", number, returnedIndex);
        } else {
            System.out.println("The number was not found");
        }

        number = array[4];
        System.out.println();
        System.out.println("Array after calling linear search with transposition method 3 times for " + number);
        for (int i = 0; i < 3; i++)
            linearSearchWithTranspositionMethod(array, number);

        printArray(array);

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
                swap(array, i, i - 1); // Transposition
                return i;
            }
        }
        return -1;
    }

    public static void swap(int[] array, int index1, int index2) {
        if (index1 < 0 || index2 < 0 || index1 >= array.length || index2 >= array.length)
            return;

        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static int[] getRandomArray(int size, int bound) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }

    public static void printArray(final int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1)
                System.out.print(array[i] + "]");
            else
                System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

}
