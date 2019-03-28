package Game;

import Field.*;
import MinePlacer.RandomMinePlacer;
import MinePlacer.RealRandom;

public class Game {

    private IReader reader;
    private IWriter writer;
    private Field field;

    public Game(IReader reader, IWriter writer) {

        this.writer = writer;
        this.reader = reader;

        setUpGame();

    }

    private void setUpGame() {

        this.writer.write("Welcome To MineSweeper!" + "\n\n" + "Let's Play..." + "\n");

        String height = this.reader.prompt("How tall do you want your field?");

        String width = this.reader.prompt("How wide do you want your field?");

        Size fieldSize = new Size(Integer.parseInt(height), Integer.parseInt(width));
        this.field = new Field(fieldSize, new RandomMinePlacer(fieldSize, new RealRandom()));

        this.writer.write(field.getPlayerField());

    }

    public void play() {

        boolean gameIsNotOver = true;

        while(gameIsNotOver) {

            String userEnterHit = reader.prompt("Select your hit:");

            String[] userHitCoordinates = userEnterHit.split(",");
            int userHitX = Integer.parseInt(userHitCoordinates[0]);
            int userHitY = Integer.parseInt(userHitCoordinates[1]);

            Coordinates userHitCoord = new Coordinates(userHitX, userHitY);

            field.revealSquare(userHitCoord);

            writer.write(field.getPlayerField());

            if(field.squareIsAMine(userHitCoord)) {
                writer.write("You hit a mine! GAME OVER.");
                gameIsNotOver = false;
            }

        }

    }

}
