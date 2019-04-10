package MinePlacer;

import java.util.Random;

public class RealRandomNumberGenerator implements IRandom {

    private final Random randomNumberGenerator;

    public RealRandomNumberGenerator() {
        this.randomNumberGenerator = new Random();
    }

    @Override
    public int nextInt(int i) {
        return randomNumberGenerator.nextInt(i);
    }

}