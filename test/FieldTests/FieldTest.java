package FieldTests;

import Field.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    public void canCreateAnEmptyField() {
        Field field = new Field(4,4);
        assertTrue(field.isEmpty());
    }

    @Test
    public void canCreateAnEmptyWorldOfSizeFourByFive() {
        Field field = new Field(4,5);
        assertEquals(4, field.getWidth());
        assertEquals(5, field.getHeight());
    }

    @Test
    public void canPlaceAMineSquare_fieldIsNoLongerEmpty() {
        Field field = new Field(4,5);
        field.placeMineSquareAt(0,1);
        assertFalse(field.isEmpty());
    }

}