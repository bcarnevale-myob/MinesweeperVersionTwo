package Field;

import Game.*;
import MinePlacer.RealRandomNumberGenerator;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(new ConsoleReader(), new ConsoleWriter(), new RealRandomNumberGenerator());
        Size fieldSize = game.getUserInputForFieldSize();
        game.setUpGame(fieldSize);

        while(!game.getGameIsOver()) {
            game.play();
        }

    }

}
