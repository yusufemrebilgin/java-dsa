package common.util;

import java.util.Random;

public class RandomManager {

    private static final Random RANDOM = new Random();

    private RandomManager() {}

    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static int nextInt(int origin, int bound) {
        if (origin >= bound) {
            throw new IllegalArgumentException("Origin must be less than bound");
        }
        return RANDOM.nextInt(bound - origin) + origin;
    }

}
