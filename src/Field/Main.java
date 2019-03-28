package Field;

import Game.*;

public class Main {

    public static void main(String[] args) {

        Game game = new Game(new ConsoleReader(), new ConsoleWriter());

        game.play();

    }

}
