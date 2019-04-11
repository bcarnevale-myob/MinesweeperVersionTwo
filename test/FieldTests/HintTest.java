package FieldTests;

import Field.*;
import MinePlacerTests.PredictableMinePlacer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HintTest {
    @Test
    void canCorrectlyCalculateHintCountWhenAdjacentSquaresTouchOneMine() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 0));

        Field field = new Field(new Size(5, 5), new PredictableMinePlacer(mines));

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
    void canCorrectlyCalculateHintCountWhenAMineIsPlacedInTheCentreOfTheField() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(2, 2));

        Field field = new Field(new Size(5, 5), new PredictableMinePlacer(mines));

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
    void canCorrectlyCalculateHintCountOfAdjacentSquaresTouchingTwoMines() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 0));
        mines.add(new Coordinate(2, 2));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));
        String actualField = field.getRevealedField();

        String expectedField =
                        "*1000\n" +
                        "12110\n" +
                        "01*10\n" +
                        "01110\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    void canCorrectlyCalculateHintCountOfAdjacentSquaresTouchingThreeMines() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 0));
        mines.add(new Coordinate(2, 2));
        mines.add(new Coordinate(2, 1));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        String actualField = field.getRevealedField();

        String expectedField =
                        "*1000\n" +
                        "23210\n" +
                        "1**10\n" +
                        "12210\n";

        assertEquals(expectedField, actualField);
    }
}
