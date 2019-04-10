package MinePlacerTests;

import Field.*;
import MinePlacer.IMinePlacer;
import MinePlacer.RandomMinePlacer;
import MinePlacer.RealRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomiseMinePlacerTest {

    @Test
    public void ifAFieldIsCreatedWithRandomMinePlacementTheFieldWillNotBeEmpty() {
        Field field = new Field(new Size(5,5), new RandomMinePlacer(new Size(5, 5), new RealRandomNumberGenerator()));

        assertFalse(field.isEmpty());
    }

    @Test
    public void whenNextIntIsCalledTheCorrectValueIsPassedAsTheUpperBoundArgumentForNumberOfMines() {
        Coordinate[] minePositions = new Coordinate[1];
        PredictableNumberGenerator predictableRandom = new PredictableNumberGenerator(1, minePositions);
        Size fieldSize = new Size(5, 5);
        IMinePlacer minePlacer = new RandomMinePlacer(fieldSize, predictableRandom);
        minePlacer.numberOfMines();

        int actualResult = predictableRandom.getUpperBound();

        assertEquals(24, actualResult);
    }

    @Test
    public void whenNextIntIsCalledOnNumberOfMinesTheResultIsTheValueGenerated() {
        Coordinate[] minePositions = new Coordinate[1];
        PredictableNumberGenerator predictableRandom = new PredictableNumberGenerator(5, minePositions);
        Size fieldSize = new Size(5, 5);
        IMinePlacer minePlacer = new RandomMinePlacer(fieldSize, predictableRandom);

        int numberOfMines = minePlacer.numberOfMines();

        assertEquals(5, numberOfMines);
    }

}
