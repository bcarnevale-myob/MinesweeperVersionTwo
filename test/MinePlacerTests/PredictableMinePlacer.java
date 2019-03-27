package MinePlacerTests;

import Field.Coordinates;
import MinePlacer.IMinePlacer;

import java.util.List;

public class PredictableMinePlacer implements IMinePlacer {

    private List<Coordinates> mines;
    private int callCounter = -1;

    public PredictableMinePlacer(List<Coordinates> mines) {
        this.mines = mines;
    }

    @Override
    public int numberOfMines() {
        return mines.size();
    }

    @Override
    public Coordinates nextCoordinate() {
        callCounter++;

        if (callCounter == mines.size()) {
            callCounter = 0;
        }

        return mines.get(callCounter);
    }
}
