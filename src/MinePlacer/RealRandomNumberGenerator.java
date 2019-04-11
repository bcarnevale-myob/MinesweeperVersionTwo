package MinePlacer;

public class RealRandomNumberGenerator implements Random {

    private final java.util.Random randomNumberGenerator;

    public RealRandomNumberGenerator() {
        this.randomNumberGenerator = new java.util.Random();
    }

    @Override
    public int nextInt(int maxAcceptedValue) {
        return randomNumberGenerator.nextInt(maxAcceptedValue);
    }

}
