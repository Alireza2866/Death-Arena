package ir.ac.kntu.logic;

import java.util.Random;

public final class RandomHelper {
    private static long seed = System.currentTimeMillis();

    private static final Random RANDOM_GENERATOR = new Random(seed);

    private RandomHelper() {
    }

    public static double nextDouble() {
        seed += 301;
        RANDOM_GENERATOR.setSeed(seed);
        return RANDOM_GENERATOR.nextDouble();
    }

    public static boolean nextBoolean() {
        seed += 301;
        RANDOM_GENERATOR.setSeed(seed);
        return RANDOM_GENERATOR.nextBoolean();
    }

    public static int nextInt() {
        seed += 301;
        RANDOM_GENERATOR.setSeed(seed);
        return RANDOM_GENERATOR.nextInt();
    }

    public static int nextInt(int bound) {
        seed += 301;
        RANDOM_GENERATOR.setSeed(seed);
        return RANDOM_GENERATOR.nextInt(bound);
    }

    public static int nextInt(int start, int end) {
        seed += 301;
        RANDOM_GENERATOR.setSeed(seed);
        return start + RANDOM_GENERATOR.nextInt(end - start);
    }
}
