package Field;

import MinePlacer.IMinePlacer;

public class Field {

    private final Square[][] field;
    private final IMinePlacer minePlacer;
    private final Size size;

    public Field(Size size, IMinePlacer minePlacer) {
        this.minePlacer = minePlacer;
        this.field = new Square[size.getHeight()][size.getWidth()];
        this.size = size;
        for (int x = 0; x < size.getHeight(); x++) {
            for (int y = 0; y < size.getWidth(); y++) {
                field[x][y] = new SafeSquare();
            }
        }

        this.setRandomMinePositions();
        addHintsToField();
    }

    private void setRandomMinePositions() {
        int numberOfMinesToPlace = minePlacer.numberOfMines();

        for (int i = 0; i < numberOfMinesToPlace; i++) {
            Coordinates minePosition = minePlacer.nextCoordinate();
            field[minePosition.getX()][minePosition.getY()] = new MineSquare();
        }
    }

    public String getPlayerField() {
        String playerField = "";

        for (int x = 0; x < this.size.getHeight(); x++) {
            for (int y = 0; y < this.size.getWidth(); y++) {
                Coordinates position = new Coordinates(x, y);
                if ((squareIsAMineAt(position)) && (field[x][y].isRevealed())) {
                    return getRevealedField();
                }
                playerField += field[x][y].toString();
            }
            playerField += "\n";
        }
        return playerField;
    }

    public String getRevealedField() {
        String revealedField = "";

        for (int x = 0; x < this.size.getHeight(); x++) {
            for (int y = 0; y < this.size.getWidth(); y++) {
                Coordinates position = new Coordinates(x, y);
                this.revealSquare(position);
                revealedField += field[x][y].toString();
            }
            revealedField += "\n";
        }
        return revealedField;
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int x = 0; x < this.size.getHeight(); x++) {
            for (int y = 0; y < this.size.getWidth(); y++) {
                if (field[x][y] instanceof MineSquare) {
                    isEmpty = false;
                }
            }
        }
        return isEmpty;
    }

    public boolean squareIsAMineAt(Coordinates coordinates) {
        int row = coordinates.getX();
        int col = coordinates.getY();
        return field[row][col].isAMine();
    }

    public void revealSquare(Coordinates coordinates) {
        int row = coordinates.getX();
        int col = coordinates.getY();
        field[row][col].reveal();
    }

    private void addHintsToField() {
        for (int x = 0; x < this.size.getHeight(); x++) {
            for (int y = 0; y < this.size.getWidth(); y++) {
                Coordinates coordinates = new Coordinates(x, y);
                if (squareIsAMineAt(coordinates)) {
                    increaseHintCountAround(coordinates);
                }
            }
        }
    }

    private void increaseHintCountAround(Coordinates coordinates) {
        int currentX = coordinates.getX();
        int currentY = coordinates.getY();
        for (int x = currentX - 1; x <= currentX + 1; x++) {
            if (!(isOutOfBounds(x, this.size.getHeight())))
                for (int y = currentY - 1; y <= currentY + 1; y++) {
                    if (!(isOutOfBounds(y, this.size.getWidth()))) {
                        field[x][y].increaseHintCount();
                    }
                }
        }
    }

    private boolean isOutOfBounds(int coordinate, int maxValue) {
        return (coordinate < 0) || (coordinate >= maxValue);
    }

}
