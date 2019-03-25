package Field;

public class PredictableRandom implements IRandom {

    private int[] intsToReturn;
    private int callCounter = 0;

    public PredictableRandom(int[] intsToReturn) {
        this.intsToReturn = intsToReturn;
    }

    @Override
    public int nextInt(int upperBound) {
        callCounter++;

        if (callCounter == intsToReturn.length) {
            callCounter = 0;
        }

        return intsToReturn[callCounter];
    }

}
