package MinePlacerTests;

import MinePlacer.IRandom;

public class PredictableRandom implements IRandom {

    private int[] intsToReturn;
    private int callCounter = -1;
    private int upperBound;

    public PredictableRandom(int[] intsToReturn) {
        this.intsToReturn = intsToReturn;
    }

    @Override
    public int nextInt(int upperBound) {
        this.upperBound = upperBound;
        callCounter++;

        return intsToReturn[callCounter];
    }

    public int getUpperBound() {
        return this.upperBound;
    }
}
