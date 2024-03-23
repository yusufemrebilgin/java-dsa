package algorithms.sorts;

import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {
        // Getting a random array of the given size and between 0 to given bound
        int[] array = getRandomArray(30, 100);

        printArray(array);
        insertionSort(array);
        printArray(array);
        
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
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
