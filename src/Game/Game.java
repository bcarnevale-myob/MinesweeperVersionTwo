package Game;

import Field.*;
import MinePlacer.IRandom;
import MinePlacer.RandomMinePlacer;
import MinePlacer.RealRandomNumberGenerator;

public class Game {

    private IReader reader;
    private IWriter writer;
    private Field field;
    private boolean gameIsOver;

    public Game(IReader reader, IWriter writer) {

        this.writer = writer;
        this.reader = reader;
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

    public void setUpGame(IRandom random, Size fieldSize) {

        this.field = new Field(fieldSize, new RandomMinePlacer(fieldSize, random));

        this.writer.write(field.getPlayerField());

    }

    public void setUpGame() {
        setUpGame(new RealRandomNumberGenerator(), getUserInputForFieldSize());
    }

    public void play() {

        String userHitEntry = reader.prompt("Select your hit:");

        String[] userHitEntrySplit = userHitEntry.split(",");
        int userHitX = Integer.parseInt(userHitEntrySplit[0]);
        int userHitY = Integer.parseInt(userHitEntrySplit[1]);

        Coordinates userHitCoordinates = new Coordinates(userHitX, userHitY);

        field.revealSquare(userHitCoordinates);

        writer.write(field.getPlayerField());

        if(field.squareIsAMineAt(userHitCoordinates)) {
            writer.write("You hit a mine! GAME OVER.");
            writer.write(field.getRevealedField());
            this.gameIsOver = true;
        }

    }

    public boolean getGameIsOver() {
        return this.gameIsOver;
    }

}
