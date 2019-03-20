package FieldTests;

import Field.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerFieldTest {

    @Test
    public void canRevealThreeSquaresAndDisplayBoardForUser() {
        Field field = new Field(4,5);
        field.placeMineSquare(0,1);

        field.revealSquare(0,0);
        field.revealSquare(0,2);
        field.revealSquare(2,2);
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
        Field field = new Field(4,5);
        field.placeMineSquare(0,1);
        field.placeMineSquare(0,2);
        field.placeMineSquare(2,2);

        field.revealSquare(0,1);
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
        Field field = new Field(4,5);
        field.placeMineSquare(0,1);
        field.placeMineSquare(0,2);
        field.placeMineSquare(2,2);

        field.revealSquare(0,0);
        field.revealSquare(0,1);
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
        Field field = new Field(4,5);
        field.placeMineSquare(0,1);
        field.placeMineSquare(0,2);
        field.placeMineSquare(2,2);

        field.revealSquare(0,0);
        field.revealSquare(2,4);
        field.revealSquare(0,1);
        String actualField = field.getPlayerField();

        String expectedField =
                        "1**..\n" +
                        ".....\n" +
                        "..*.0\n" +
                        ".....\n";

        assertEquals(expectedField, actualField);
    }

}
