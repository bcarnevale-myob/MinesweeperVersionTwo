package Field;

public class PredictableRandom implements IRandom {

    private int callCounter = 0;

    public PredictableRandom() {

    }

    @Override
    public int nextInt(int upperBound) {
        if(callCounter == 0) {
            callCounter++;
            return 1;
        }
        return 0;
    }

}
