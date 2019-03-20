package FieldTests;

import Field.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomiseMines {

    @Test
    public void ifAFieldIsCreatedWithRandomMinePlacementTheFieldWillNotBeEmpty() {
        Field field = new Field(5,5, new MockMineRandom(1, 0, 0));

        assertFalse(field.isEmpty());
    }

    @Test
    public void ifAFieldIsCreatedWithRandomMinePlacementOfZeroZeroThenZeroZeroShouldBeAMineSquare() {
        Field field = new Field(4,5, new MockMineRandom(1, 0, 0));

        assertTrue(field.squareIsAMine(0,0));

    }

    @Test
    public void ifAFieldIsCreatedWithRandomMinePlacementOfZeroZeroThenZeroOneShouldBeASafeSquare() {
        Field field = new Field(4,5, new MockMineRandom(1, 0, 0));

        assertFalse(field.squareIsAMine(0,1));
    }

}
