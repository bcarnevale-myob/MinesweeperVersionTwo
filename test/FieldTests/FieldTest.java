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
    public void canPlaceAMineAndRevealTheBoardWithHints() {
        Field field = new Field(4,5);
        field.placeMineSquare(0,0);

        String expectedField =
                "*0000\n" +
                "00000\n" +
                "00000\n" +
                "00000\n";

        assertEquals(expectedField, field.getRevealedBoard());
    }

    @Test
    public void canCheckIfCurrentSquareIsAMineSquare() {
        Field field = new Field(4,5);
        field.placeMineSquare(0,1);

        assertTrue(field.getSquareAt(0,1).isAMine());
    }

    @Test
    public void canCheckIfCurrentSquareIsNotAMineSquare() {
        Field field = new Field(4,5);
        field.placeMineSquare(0,1);

        assertFalse(field.getSquareAt(1,1).isAMine());
    }

}