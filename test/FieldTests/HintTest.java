package FieldTests;

import Field.*;
import MinePlacerTests.PredictableMinePlacer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HintTest {
    @Test
    void aSingleMineInTheTopLeftCornerHasAdjacentHintsOf1() {
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
    void squaresAdjacentToASingleMineHaveHintCountOf1() {
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
    void aSquareWithTwoAdjacentMinesHaveAHintCountOf2() {
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
    void aSquareWithThreeAdjacentMinesHaveAHintCountOf3() {
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
    @Test
    void aSquareWith8AdjacentMinesHasHintOf8() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(1, 1));
        mines.add(new Coordinate(2, 1));
        mines.add(new Coordinate(3, 1));
        mines.add(new Coordinate(1, 2));
        mines.add(new Coordinate(3, 2));
        mines.add(new Coordinate(1, 3));
        mines.add(new Coordinate(2, 3));
        mines.add(new Coordinate(3, 3));

        Field field = new Field(new Size(5, 5), new PredictableMinePlacer(mines));

        String actualField = field.getRevealedField();

        String expectedField =
                        "12321\n" +
                        "2***2\n" +
                        "3*8*3\n" +
                        "2***2\n" +
                        "12321\n";

        assertEquals(expectedField, actualField);
    }
}
