package FieldTests;

import Field.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HintTest {

    @Test
    public void canPlaceOneMineAndHintCountOfAdjacentSquaresIncreasesByOne() {
        Field field = new Field(5,5);
        field.placeMineSquare(0,0);
        String actualField = field.getRevealedField();

        String expectedField =
                        "*1000\n" +
                        "11000\n" +
                        "00000\n" +
                        "00000\n" +
                        "00000\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void canPlaceOneMineInTheCentreAndHintCountOfAdjacentSquaresIncreasesByOne() {
        Field field = new Field(5,5);
        field.placeMineSquare(2,2);
        String actualField = field.getRevealedField();

        String expectedField =
                        "00000\n" +
                        "01110\n" +
                        "01*10\n" +
                        "01110\n" +
                        "00000\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void canPlaceTwoMinesAndHintCountOfAdjacentSquaresIncreasesByOne() {
        Field field = new Field(4,5);
        field.placeMineSquare(0,0);
        field.placeMineSquare(2,2);
        String actualField = field.getRevealedField();

        String expectedField =
                        "*1000\n" +
                        "12110\n" +
                        "01*10\n" +
                        "01110\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void canPlaceThreeMinesAndHintCountOfAdjacentSquaresIncreasesByOne() {
        Field field = new Field(4,5);
        field.placeMineSquare(0,0);
        field.placeMineSquare(2,2);
        field.placeMineSquare(2,1);
        String actualField = field.getRevealedField();

        String expectedField =
                        "*1000\n" +
                        "23210\n" +
                        "1**10\n" +
                        "12210\n";

        assertEquals(expectedField, actualField);
    }

}
