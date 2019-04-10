package FieldTests;

import Field.*;
import MinePlacerTests.PredictableMinePlacer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    public void canCreateAnEmptyField() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();

        Field field = new Field(new Size(4, 4), new PredictableMinePlacer(mines));

        assertTrue(field.isEmpty());
    }

    @Test
    public void canCreateAFieldOfDifferentSizes() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(2, 3));

        Field field = new Field(new Size(3, 4), new PredictableMinePlacer(mines));

        String fieldHeight = field.getPlayerField();

        assertEquals(3, fieldHeight.split("\n").length);
        assertEquals(4, fieldHeight.split("\n")[0].length());
    }

    @Test
    public void canRevealTheBoardWithAllHintsWhenOneMineIsPlaced() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 0));

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
    public void canDisplayFieldForUserWhenOneSquareIsRevealed() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 1));

        Field field = new Field(new Size (4,5), new PredictableMinePlacer(mines));

        field.revealSquare(new Coordinates(0,0));
        String actualField = field.getPlayerField();

        String expectedField =
                        "1....\n" +
                        ".....\n" +
                        ".....\n" +
                        ".....\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void canCheckIfCurrentSquareIsAMineSquare() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 1));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        assertTrue(field.squareIsAMineAt(new Coordinates(0,1)));
    }

    @Test
    public void canCheckIfCurrentSquareIsNotAMineSquare() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 1));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        assertFalse(field.squareIsAMineAt(new Coordinates(1,1)));
    }

}