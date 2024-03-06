package algorithms.sorts;

import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        // Getting a random array of the given size and between 0 to given bound
        int[] array = getRandomArray(30, 100);

        printArray(array);
        bubbleSort(array);
        printArray(array);

    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // We made it adaptive by using flag
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                return;
        }
    }

    public static void swap(int[] array, int index1, int index2) {
        if (index1 < 0 || index2 <0 || index1 >= array.length || index2 >= array.length)
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
