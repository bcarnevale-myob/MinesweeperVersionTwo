package Game;

import Field.*;
import MinePlacer.Random;
import MinePlacer.RandomMinePlacer;

public class Game {

    private Reader reader;
    private Writer writer;
    private Random random;
    private Field field;
    private boolean gameIsOver;

    public Game(Reader reader, Writer writer, Random random) {

        this.writer = writer;
        this.reader = reader;
        this.random = random;
        this.gameIsOver = false;

        welcomeMessage();

    }

    private void welcomeMessage() {
        this.writer.write("Welcome To MineSweeper!" + "\n\n" + "Let's Play..." + "\n");
    }

    public Size getUserInputForFieldSize() {

        String fieldSizeInput = this.reader.prompt("What size would you like your field?");

        String[] fieldSizeInputSplit = fieldSizeInput.split(",");
        int height = Integer.parseInt(fieldSizeInputSplit[0]);
        int width = Integer.parseInt(fieldSizeInputSplit[1]);

        return new Size(height, width);
    }

    public void setUpGame(Size size) {

        this.field = new Field(size, new RandomMinePlacer(size, this.random));

        this.writer.write(field.getPlayerField());

    }

    public void play() {

        String userHitEntry = reader.prompt("Select your hit:");

        String[] userHitEntrySplit = userHitEntry.split(",");
        int userHitX = Integer.parseInt(userHitEntrySplit[0]);
        int userHitY = Integer.parseInt(userHitEntrySplit[1]);

        Coordinate userHitCoordinates = new Coordinate(userHitX, userHitY);

        field.revealSquare(userHitCoordinates);

        writer.write(field.getPlayerField());

        if(field.squareIsAMineAt(userHitCoordinates)) {
            writer.write("You hit a mine! GAME OVER.");
            writer.write(field.getPlayerField());
            this.gameIsOver = true;
        }

    }

    public boolean getGameIsOver() {
        return this.gameIsOver;
    }

}
