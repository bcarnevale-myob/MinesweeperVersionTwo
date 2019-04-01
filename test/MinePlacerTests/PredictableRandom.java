package MinePlacerTests;

import Field.Coordinates;
import MinePlacer.IRandom;

public class PredictableRandom implements IRandom {

    private final int numberOfMinesMinusOne;
    private final Coordinates[] minePositions;
    private int callCounter = 0;
    private int upperBound;

    public PredictableRandom(int numberOfMines, Coordinates[] minePositions) {
        // Since RandomMinePlacer adds 1 to the random value returned from the random number source,
        // we subtract one here so that the desired number of mines is placed
        this.numberOfMinesMinusOne = numberOfMines - 1;
        this.minePositions = minePositions;
    }

    @Override
    public int nextInt(int upperBound) {
        this.upperBound = upperBound;
        callCounter++;

        if (callCounter == 1) {
            return numberOfMinesMinusOne;
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
}
