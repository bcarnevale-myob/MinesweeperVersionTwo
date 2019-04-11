package FieldTests;

import Field.*;
import MinePlacerTests.PredictableMinePlacer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerFieldTest {

    @Test
    void displaysCorrectBoardWhen3SafeSquaresAreRevealed() {
        List<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        field.hit(new Coordinate(0, 0));
        field.hit(new Coordinate(0, 2));
        field.hit(new Coordinate(2, 2));
        String actualField = field.getCurrentField();

        String expectedField =
                        "1.1..\n" +
                        ".....\n" +
                        "..0..\n" +
                        ".....\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    void selectingAMineRevealsTheField() {
        List<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));
        mines.add(new Coordinate(0, 2));
        mines.add(new Coordinate(2, 2));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        field.hit(new Coordinate(0, 0));
        field.hit(new Coordinate(0, 1));
        String actualField = field.getCurrentField();

        String expectedField =
                        "1**10\n" +
                        "13320\n" +
                        "01*10\n" +
                        "01110\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    void callingGetPlayerFieldMultipleTimesDoesntAffectHintCount() {

        List<Coordinate> mines = new ArrayList<Coordinate>();
        mines.add(new Coordinate(0, 1));
        mines.add(new Coordinate(0, 2));
        mines.add(new Coordinate(2, 2));

        Field field = new Field(new Size(4, 5), new PredictableMinePlacer(mines));

        field.hit(new Coordinate(0, 0));
        field.getCurrentField();
        field.hit(new Coordinate(2, 4));
        field.getCurrentField();
        field.hit(new Coordinate(0, 1));
        String actualField = field.getCurrentField();

        String expectedField =
                        "1**10\n" +
                        "13320\n" +
                        "01*10\n" +
                        "01110\n";

        assertEquals(expectedField, actualField);

    }
}
