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
    public void ifRevealMethodIsCalledOnASquareItsStringValueIsReturned() {
        Field field = new Field(4,5);
        assertEquals("0", field.revealSquare(0,0));
    }

    @Test
    public void canPlaceAMineAndSelectThatSquareToRevealThePlayersBoard() {
        Field field = new Field(4,5);
        field.placeMineSquare(0,0);
        field.revealSquare(0,0);

        String expectedField =
                        "*....\n" +
                        ".....\n" +
                        ".....\n" +
                        ".....\n";

        assertEquals(expectedField, field.getPlayerBoard());
    }

    @Test
    public void canCheckIfCurrentSquareIsAMineSquare() {
        Field field = new Field(4,5);
        field.placeMineSquare(0,1);

        assertTrue(field.getSquareTypeAt(0,1));
    }

    @Test
    public void canCheckIfCurrentSquareIsNotAMineSquare() {
        Field field = new Field(4,5);
        field.placeMineSquare(0,1);

        assertFalse(field.getSquareTypeAt(1,1));
    }

}