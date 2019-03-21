package Field;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private final Random randomNumberGenerator;

    public RandomNumberGenerator() {
        randomNumberGenerator = new Random();
    }

    @Override
    public int nextInt(int i) {
        return randomNumberGenerator.nextInt(i - 1) + 1;
    }
}
