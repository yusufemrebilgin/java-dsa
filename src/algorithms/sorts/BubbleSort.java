package algorithms.sorts;

import common.util.ArrayUtil;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        // Getting a random array of the given size and between 0 to given bound
        int[] array = ArrayUtil.generateRandomArray(30, 0, 100);

        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // We made it adaptive by using flag
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    ArrayUtil.swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped)
                return;
        }
    }

}
