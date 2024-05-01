package common.util;

public class ArrayUtil {

    private ArrayUtil() {}

    public static int[] generateRandomArray(int length, int origin, int bound) {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = RandomManager.nextInt(origin, bound);
        }
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        if (i < 0 || j < 0 || i >= array.length || j >= array.length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
