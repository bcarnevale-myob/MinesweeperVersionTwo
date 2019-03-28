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
        int[] intsToReturn = new int[1];
        PredictableRandom predictableRandom = new PredictableRandom(intsToReturn);
        Size fieldSize = new Size(5, 5);
        IMinePlacer minePlacer = new RandomMinePlacer(fieldSize, predictableRandom);
        minePlacer.numberOfMines();

        int actualResult = predictableRandom.getUpperBound();

        assertEquals(24, actualResult);
    }

    @Test
    public void whenNextIntIsCalledOnNumberOfMinesTheResultIsTheValueGeneratedPlusOne() {
        int[] intsToReturn = new int[1];
        intsToReturn[0] = 4;
        PredictableRandom predictableRandom = new PredictableRandom(intsToReturn);
        Size fieldSize = new Size(5, 5);
        IMinePlacer minePlacer = new RandomMinePlacer(fieldSize, predictableRandom);

        int numberOfMines = minePlacer.numberOfMines();

        assertEquals(5, numberOfMines);
    }

    @Test
    public void whenNumberOfMinesIsCalledThenCallCounterIsOne() {
        int[] intsToReturn = new int[2];
        intsToReturn[0] = 4;
        PredictableRandom predictableRandom = new PredictableRandom(intsToReturn);
        Size fieldSize = new Size(5, 5);
        IMinePlacer minePlacer = new RandomMinePlacer(fieldSize, predictableRandom);
        Field field = new Field(fieldSize, minePlacer);

        int calledTimes = predictableRandom.getCallCounter();

        assertEquals(1, calledTimes);
    }

}
