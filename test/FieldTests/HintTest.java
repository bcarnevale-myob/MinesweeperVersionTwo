package FieldTests;

import Field.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HintTest {

    @Test
    public void canPlaceOneMineAndHintCountOfAdjacentSquaresIncreasesByOne() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 0));

        Field field = new Field(5, 5, new PredictableMinePlacer(mines));

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
    public void canPlaceOneMineInTheCentreAndHintCountOfAdjacentSquaresIncreasesByOne() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(2, 2));

        Field field = new Field(5, 5, new PredictableMinePlacer(mines));

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
    public void canPlaceTwoMinesAndHintCountOfAdjacentSquaresIncreasesByOne() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 0));
        mines.add(new Coordinates(2, 2));

        Field field = new Field(4, 5, new PredictableMinePlacer(mines));
        String actualField = field.getRevealedField();

        String expectedField =
                        "*1000\n" +
                        "12110\n" +
                        "01*10\n" +
                        "01110\n";

        assertEquals(expectedField, actualField);
    }

    @Test
    public void canPlaceThreeMinesAndHintCountOfAdjacentSquaresIncreasesByOne() {
        ArrayList<Coordinates> mines = new ArrayList<Coordinates>();
        mines.add(new Coordinates(0, 0));
        mines.add(new Coordinates(2, 2));
        mines.add(new Coordinates(2, 1));

        Field field = new Field(4, 5, new PredictableMinePlacer(mines));

        String actualField = field.getRevealedField();

        String expectedField =
                        "*1000\n" +
                        "23210\n" +
                        "1**10\n" +
                        "12210\n";

        assertEquals(expectedField, actualField);
    }

}
