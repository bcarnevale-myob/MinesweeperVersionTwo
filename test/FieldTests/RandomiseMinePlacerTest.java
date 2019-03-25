package FieldTests;

import Field.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomiseMinePlacerTest {

    @Test
    public void ifAFieldIsCreatedWithRandomMinePlacementTheFieldWillNotBeEmpty() {
        Field field = new Field(new Size(5,5), new RandomMinePlacer(new Size(5, 5), new RealRandom()));

        assertFalse(field.isEmpty());
    }

}
