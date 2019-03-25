package FieldTests;

import Field.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerFieldTest {

    @Test
    public void canRevealThreeSquaresAndDisplayBoardForUser() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 1));

        Field field = new Field(4, 5, new PredictableMinePlacer(mines));

        field.revealSquare(0, 0);
        field.revealSquare(0, 2);
        field.revealSquare(2, 2);
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


        Field field = new Field(4, 5, new PredictableMinePlacer(mines));

        field.revealSquare(0, 1);
        String actualField = field.getPlayerField();

        String expectedField =
                        ".**..\n" +
                        ".....\n" +
                        "..*..\n" +
                        ".....\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void ifPlayerRevealsASquareAndThenAMineAllMinesAreRevealedAsWellAsTheirFirstChoiceOfSquare() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 1));
        mines.add(new Coordinates(0, 2));
        mines.add(new Coordinates(2, 2));

        Field field = new Field(4, 5, new PredictableMinePlacer(mines));

        field.revealSquare(0, 0);
        field.revealSquare(0, 1);
        String actualField = field.getPlayerField();

        String expectedField =
                "1**..\n" +
                        ".....\n" +
                        "..*..\n" +
                        ".....\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void ifPlayerRevealsTwoSquaresAndThenAMineAllMinesAreRevealedAsWellAsTheFirstTwoRevealedSquares() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 1));
        mines.add(new Coordinates(0, 2));
        mines.add(new Coordinates(2, 2));

        Field field = new Field(4, 5, new PredictableMinePlacer(mines));

        field.revealSquare(0, 0);
        field.revealSquare(2, 4);
        field.revealSquare(0, 1);
        String actualField = field.getPlayerField();

        String expectedField =
                        "1**..\n" +
                        ".....\n" +
                        "..*.0\n" +
                        ".....\n";

        assertEquals(expectedField, actualField);
    }

}
