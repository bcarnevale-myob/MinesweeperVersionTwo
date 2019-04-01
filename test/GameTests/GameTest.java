package GameTests;

import Field.Coordinates;
import Game.Game;
import MinePlacerTests.PredictableRandom;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    public void whenANewGameIsMadeAndAUserInputsA4X3FieldTheFieldSizeIs4X3() {
        ArrayList<String> userResponses = new ArrayList<>();
        userResponses.add("4");
        userResponses.add("3");
        userResponses.add("0,0");

        TestWriter testWriter = new TestWriter();
        Game game = new Game(new TestReader(userResponses), testWriter);
        Coordinates[] minePositions = {new Coordinates(0,0), new Coordinates(1,0), new Coordinates(0,1)};
        game.setUpGame(new PredictableRandom(3, minePositions));
        game.play();

        ArrayList<String> messagesReceived = testWriter.messagesReceived;
        String actualField = messagesReceived.get(messagesReceived.size() - 1);

        String expectedField =
                        "**1\n" +
                        "*31\n" +
                        "110\n" +
                        "000\n";

        assertEquals(expectedField, actualField);

    }
}