package FieldTests;

import Field.*;
import MinePlacerTests.PredictableMinePlacer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void canCreateAnEmptyField() {
        List<Coordinate> mines = new ArrayList<Coordinate>();

        Field field = new Field(new Size(4, 4), new PredictableMinePlacer(mines));

        assertTrue(field.isEmpty());
    }

    @Test
    void canCreateAFieldOfDifferentSizes() {
        List<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(2, 3));

        Field field = new Field(new Size(3, 4), new PredictableMinePlacer(mines));

        String fieldHeight = field.getCurrentField();

        int actualHeight = fieldHeight.split("\n").length;
        int actualWidth = fieldHeight.split("\n")[0].length();

        assertEquals(3, actualHeight);
        assertEquals(4, actualWidth);
    }

    @Test
    void canRevealTheBoardWithAllHintsWhenOneMineIsPlaced() {
        List<Coordinate> mines = new ArrayList<Coordinate>();
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
        List<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));

        Field field = new Field(new Size (4,5), new PredictableMinePlacer(mines));

        field.hit(new Coordinate(0,0));
        String actualField = field.getCurrentField();

        String expectedField =
                        "1....\n" +
                        ".....\n" +
                        ".....\n" +
                        ".....\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    void canCheckIfCurrentSquareIsAMineSquare() {
        List<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        assertTrue(field.hasMineAt(new Coordinate(0,1)));
    }

    @Test
    void canCheckIfCurrentSquareIsNotAMineSquare() {
        List<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        assertFalse(field.hasMineAt(new Coordinate(1,1)));
    }
}