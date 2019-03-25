package FieldTests;

import Field.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomiseMines {

    @Test
    public void ifAFieldIsCreatedWithRandomMinePlacementTheFieldWillNotBeEmpty() {
        Field field = new Field(5, 5, new RandomMinePlacer(5, 5));

        assertFalse(field.isEmpty());
    }

}
