package Field;

import java.util.Random;

public class RandomMinePlacer implements MinePlacer {

    private final Random randomNumberGenerator;
    private final int xUpper;
    private final int yUpper;

    public RandomMinePlacer(int xUpper, int yUpper) {
        randomNumberGenerator = new Random();
        this.xUpper = xUpper;
        this.yUpper = yUpper;
    }

    @Override
    public int numberOfMines(int i) {
        return randomNumberGenerator.nextInt(i - 1) + 1;
    }

    @Override
    public Coordinates nextCoordinate() {
        return new Coordinates(randomNumberGenerator.nextInt(xUpper), randomNumberGenerator.nextInt(yUpper));
    }
}
