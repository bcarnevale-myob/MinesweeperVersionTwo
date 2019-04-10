package FieldTests;

import Field.*;
import MinePlacerTests.PredictableMinePlacer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerFieldTest {

    @Test
    public void canDisplayBoardForUserCorrectlyWhenThreeSquaresHaveBeenRevealed() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 1));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        field.revealSquare(new Coordinates(0, 0));
        field.revealSquare(new Coordinates(0, 2));
        field.revealSquare(new Coordinates(2, 2));
        String actualField = field.getPlayerField();

        String expectedField =
                        "1.1..\n" +
                        ".....\n" +
                        "..0..\n" +
                        ".....\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void ifPlayerRevealsAMineAllMinesAreRevealed() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 1));
        mines.add(new Coordinates(0, 2));
        mines.add(new Coordinates(2, 2));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        field.revealSquare(new Coordinates(0, 1));
        String actualField = field.getPlayerField();

        String expectedField =
                        "1**10\n" +
                        "13320\n" +
                        "01*10\n" +
                        "01110\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void ifPlayerRevealsAHintSquareAndThenAMineAllMinesAreRevealedAsWellAsTheirFirstChoiceOfSquare() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 1));
        mines.add(new Coordinates(0, 2));
        mines.add(new Coordinates(2, 2));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        field.revealSquare(new Coordinates(0, 0));
        field.revealSquare(new Coordinates(0, 1));
        String actualField = field.getPlayerField();

        String expectedField =
                        "1**10\n" +
                        "13320\n" +
                        "01*10\n" +
                        "01110\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void ifPlayerFieldIsCalledMultipleTimesTheHintsContainCorrectValue() {

        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 1));
        mines.add(new Coordinates(0, 2));
        mines.add(new Coordinates(2, 2));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        field.revealSquare(new Coordinates(0, 0));
        field.getPlayerField();
        field.revealSquare(new Coordinates(2, 4));
        field.getPlayerField();
        field.revealSquare(new Coordinates(0, 1));
        String actualField = field.getPlayerField();

        String expectedField =
                        "1**10\n" +
                        "13320\n" +
                        "01*10\n" +
                        "01110\n";

        assertEquals(expectedField, actualField);

    }

}
