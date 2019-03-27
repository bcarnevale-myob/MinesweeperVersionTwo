package MinePlacer;

import java.util.Random;

public class RealRandom implements IRandom {

    private final Random randomNumberGenerator;

    public RealRandom() {
        this.randomNumberGenerator = new Random();
    }

    @Override
    public int nextInt(int i) {
        return randomNumberGenerator.nextInt(i);
    }

}
