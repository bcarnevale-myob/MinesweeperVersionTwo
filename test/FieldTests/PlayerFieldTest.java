package FieldTests;

import Field.*;
import MinePlacerTests.PredictableMinePlacer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFieldTest {

    @Test
    void canDisplayBoardForUserCorrectlyWhenThreeSquaresHaveBeenRevealed() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        field.revealSquare(new Coordinate(0, 0));
        field.revealSquare(new Coordinate(0, 2));
        field.revealSquare(new Coordinate(2, 2));
        String actualField = field.getPlayerField();

        String expectedField =
                        "1.1..\n" +
                        ".....\n" +
                        "..0..\n" +
                        ".....\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    void ifPlayerRevealsAMineAllMinesAreRevealed() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));
        mines.add(new Coordinate(0, 2));
        mines.add(new Coordinate(2, 2));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        field.revealSquare(new Coordinate(0, 1));
        String actualField = field.getPlayerField();

        String expectedField =
                        "1**10\n" +
                        "13320\n" +
                        "01*10\n" +
                        "01110\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    void ifPlayerRevealsAHintSquareAndThenAMineAllMinesAreRevealedAsWellAsTheirFirstChoiceOfSquare() {
        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));
        mines.add(new Coordinate(0, 2));
        mines.add(new Coordinate(2, 2));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        field.revealSquare(new Coordinate(0, 0));
        field.revealSquare(new Coordinate(0, 1));
        String actualField = field.getPlayerField();

        String expectedField =
                        "1**10\n" +
                        "13320\n" +
                        "01*10\n" +
                        "01110\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    void ifPlayerFieldIsCalledMultipleTimesTheHintsContainCorrectValue() {

        ArrayList<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));
        mines.add(new Coordinate(0, 2));
        mines.add(new Coordinate(2, 2));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        field.revealSquare(new Coordinate(0, 0));
        field.getPlayerField();
        field.revealSquare(new Coordinate(2, 4));
        field.getPlayerField();
        field.revealSquare(new Coordinate(0, 1));
        String actualField = field.getPlayerField();

        String expectedField =
                        "1**10\n" +
                        "13320\n" +
                        "01*10\n" +
                        "01110\n";

        assertEquals(expectedField, actualField);

    }
}
