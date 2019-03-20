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

}
