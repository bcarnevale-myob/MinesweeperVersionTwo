package FieldTests;

import Field.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    public void canCreateAnEmptyField() {
        Field field = new Field(4,4, new PredictableNumberGenerator(0,2,3));

        // var mineList = new ArrayList<Coordinates> {
        // new Coordinate(2,3);
        // }
        //Field field = new Field(4,4, new PredictableNumberGenerator(mineList));

        assertTrue(field.isEmpty());
    }

    @Test
    public void canCreateAFieldOfDifferentSizes() {
        Field field = new Field(3,4, new PredictableNumberGenerator(1,2,3));

        int fieldHeight = field.getHeight();
        int fieldWidth = field.getWidth();

        assertEquals(3, fieldHeight);
        assertEquals(4, fieldWidth);
    }

    @Test
    public void canPlaceAMineAndRevealTheBoardWithAllHints() {
        Field field = new Field(4,5, new PredictableNumberGenerator(1,0,0));
        String actualField = field.getRevealedField();

        String expectedField =
                "*1000\n" +
                "11000\n" +
                "00000\n" +
                "00000\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void canRevealOneSquareAndDisplayFieldForUser() {
        Field field = new Field(4,5, new PredictableNumberGenerator(1,0,1));

        field.revealSquare(0,1);
        String actualField = field.getPlayerField();

        String expectedField =
                        ".*...\n" +
                        ".....\n" +
                        ".....\n" +
                        ".....\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void canCheckIfCurrentSquareIsAMineSquare() {
        Field field = new Field(4,5, new PredictableNumberGenerator(1,0,1));

        assertTrue(field.squareIsAMine(0,1));
    }

    @Test
    public void canCheckIfCurrentSquareIsNotAMineSquare() {
        Field field = new Field(4,5, new PredictableNumberGenerator(1,0,1));

        assertFalse(field.squareIsAMine(1,1));
    }

}