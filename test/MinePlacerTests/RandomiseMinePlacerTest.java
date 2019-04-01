package MinePlacerTests;

import Field.*;
import MinePlacer.IMinePlacer;
import MinePlacer.RandomMinePlacer;
import MinePlacer.RealRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomiseMinePlacerTest {

    @Test
    public void ifAFieldIsCreatedWithRandomMinePlacementTheFieldWillNotBeEmpty() {
        Field field = new Field(new Size(5,5), new RandomMinePlacer(new Size(5, 5), new RealRandom()));

        assertFalse(field.isEmpty());
    }

    @Test
    public void whenNextIntIsCalledTheCorrectValueIsPassedAsTheUpperBoundArgumentForNumberOfMines() {
        Coordinates[] minePositions = new Coordinates[1];
        PredictableRandom predictableRandom = new PredictableRandom(1, minePositions);
        Size fieldSize = new Size(5, 5);
        IMinePlacer minePlacer = new RandomMinePlacer(fieldSize, predictableRandom);
        minePlacer.numberOfMines();

        int actualResult = predictableRandom.getUpperBound();

        assertEquals(24, actualResult);
    }

    @Test
    public void whenNextIntIsCalledOnNumberOfMinesTheResultIsTheValueGeneratedPlusOne() {
        Coordinates[] minePositions = new Coordinates[1];
        PredictableRandom predictableRandom = new PredictableRandom(4, minePositions);
        Size fieldSize = new Size(5, 5);
        IMinePlacer minePlacer = new RandomMinePlacer(fieldSize, predictableRandom);

        int numberOfMines = minePlacer.numberOfMines();

        assertEquals(5, numberOfMines);
    }

    @Test
    public void whenNumberOfMinesIsCalledThenCallCounterIsOne() {
        Coordinates[] minePositions = new Coordinates[1];
        PredictableRandom predictableRandom = new PredictableRandom(4, minePositions);
        Size fieldSize = new Size(5, 5);
        IMinePlacer minePlacer = new RandomMinePlacer(fieldSize, predictableRandom);

        int calledTimes = predictableRandom.getCallCounter();

        assertEquals(1, calledTimes);
    }

}
