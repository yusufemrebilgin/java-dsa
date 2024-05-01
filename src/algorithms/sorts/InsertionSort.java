package algorithms.sorts;

import common.util.ArrayUtil;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        // Getting a random array of the given size and between 0 to given bound
        int[] array = ArrayUtil.generateRandomArray(30, 0, 100);

        System.out.println(Arrays.toString(array));
        insertionSort(array);
        System.out.println(Arrays.toString(array));
        
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

}
