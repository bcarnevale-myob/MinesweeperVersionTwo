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

        this.writer.write(field.printField());
    }

    public void play() {

        String userHit = reader.prompt("Select your hit:");

        String[] userHitCoordinates = userHit.split(",");
        int userHitX = Integer.parseInt(userHitCoordinates[0]);
        int userHitY = Integer.parseInt(userHitCoordinates[1]);

        field.revealSquare(new Coordinates(userHitX, userHitY));

        writer.write(field.printField());

    }
}
