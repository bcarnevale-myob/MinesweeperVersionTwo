package GameTests;

import Field.Coordinate;
import Field.Size;
import Game.Game;
import MinePlacerTests.PredictableNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void whenANewGameIsStartedTheExpectedFieldIsProduced() {

        ArrayList<String> userResponses = new ArrayList<>();
        userResponses.add("0,0");

        TestWriter testWriter = new TestWriter();
        Coordinate[] minePositions = {new Coordinate(0,0), new Coordinate(1,0), new Coordinate(0,1)};
        Game game = new Game(new TestReader(userResponses), testWriter, new PredictableNumberGenerator(3, minePositions));
        game.setUpGame(new Size(4, 3));
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
