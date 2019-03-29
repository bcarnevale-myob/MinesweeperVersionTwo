package MinePlacerTests;

import Field.Coordinates;
import MinePlacer.IRandom;

public class PredictableRandom implements IRandom {

    private final int numberOfMines;
    private final Coordinates[] minePositions;
    private int callCounter = 0;
    private int upperBound;

    public PredictableRandom(int numberOfMines, Coordinates[] minePositions) {
        this.numberOfMines = numberOfMines;
        this.minePositions = minePositions;
    }

    @Override
    public int nextInt(int upperBound) {
        this.upperBound = upperBound;
        callCounter++;

        if (callCounter == 1) {
            return numberOfMines;
        }

        int minePositionIndex = (callCounter / 2) - 1;

        if (callCounter % 2 == 0) {
            return minePositions[minePositionIndex].getX();
        }

        return minePositions[minePositionIndex].getY();
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public int getCallCounter() {
        return callCounter;
    }
}
