package FieldTests;

import Field.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RandomiseMines {

    @Test
    public void ifAFieldIsCreatedWithRandomMinePlacementTheFieldWillNotBeEmpty() {
        Field field = new Field(4,5, true);

        assertFalse(field.isEmpty());
    }

}
