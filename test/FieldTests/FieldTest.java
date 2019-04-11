package FieldTests;

import Field.*;
import MinePlacerTests.PredictableMinePlacer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void canCreateAnEmptyField() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();

        Field field = new Field(new Size(4, 4), new PredictableMinePlacer(mines));

        assertTrue(field.isEmpty());
    }

    @Test
    void canCreateAFieldOfDifferentSizes() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(2, 3));

        Field field = new Field(new Size(3, 4), new PredictableMinePlacer(mines));

        String fieldHeight = field.getPlayerField();

        int actualHeight = fieldHeight.split("\n").length;
        int actualWidth = fieldHeight.split("\n")[0].length();

        assertEquals(3, actualHeight);
        assertEquals(4, actualWidth);
    }

    @Test
    void canRevealTheBoardWithAllHintsWhenOneMineIsPlaced() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 0));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        String actualField = field.getRevealedField();

        String expectedField =
                "*1000\n" +
                "11000\n" +
                "00000\n" +
                "00000\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    void canDisplayFieldForUserWhenOneSquareIsRevealed() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));

        Field field = new Field(new Size (4,5), new PredictableMinePlacer(mines));

        field.revealSquare(new Coordinate(0,0));
        String actualField = field.getPlayerField();

        String expectedField =
                        "1....\n" +
                        ".....\n" +
                        ".....\n" +
                        ".....\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    void canCheckIfCurrentSquareIsAMineSquare() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        assertTrue(field.squareIsAMineAt(new Coordinate(0,1)));
    }

    @Test
    void canCheckIfCurrentSquareIsNotAMineSquare() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        assertFalse(field.squareIsAMineAt(new Coordinate(1,1)));
    }
}