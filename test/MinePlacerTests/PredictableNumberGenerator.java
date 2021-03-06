package MinePlacerTests;

import Field.Coordinate;
import MinePlacer.Random;

public class PredictableNumberGenerator implements Random {

    private final int numberOfMinesMinusOne;
    private final Coordinate[] minePositions;
    private int callCounter = 0;
    private int upperBound;

    public PredictableNumberGenerator(int numberOfMines, Coordinate[] minePositions) {
        // Since RandomMinePlacer adds 1 to the random value returned from the random number source,
        // we subtract one here so that the desired number of mines is placed
        this.numberOfMinesMinusOne = numberOfMines - 1;
        this.minePositions = minePositions;
    }

    @Override
    public int nextInt(int maximumAcceptedValue) {
        this.upperBound = maximumAcceptedValue;
        callCounter++;

        if (callCounter == 1) {
            return numberOfMinesMinusOne;
        }

        return getMinePositions();
    }

    private int getMinePositions() {
        int minePositionIndex = (callCounter / 2) - 1;

        if (callCounter % 2 == 0) {
            return minePositions[minePositionIndex].getX();
        }

        return minePositions[minePositionIndex].getY();
    }

    public int getUpperBound() {
        return this.upperBound;
    }
}
