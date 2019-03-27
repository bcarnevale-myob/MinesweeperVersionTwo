package FieldTests;

import Field.*;
import MinePlacer.MinePlacer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomiseMinePlacerTest {

    @Test
    public void ifAFieldIsCreatedWithRandomMinePlacementTheFieldWillNotBeEmpty() {
        Field field = new Field(new Size(5,5), new RandomMinePlacer(new Size(5, 5), new RealRandom()));

        assertFalse(field.isEmpty());
    }

    @Test
    public void whenNextIntIsCalledTheCorrectValueIsPassedAsTheUpperBoundArgument() {
        int[] intsToReturn = new int[1];
        PredictableRandom predictableRandom = new PredictableRandom(intsToReturn);
        Size fieldSize = new Size(4, 5);
        MinePlacer minePlacer = new RandomMinePlacer(fieldSize, predictableRandom);
        Field field = new Field(fieldSize, minePlacer);

        int actualResult = predictableRandom.getUpperBound();

        assertEquals(24, actualResult);
    }

}
