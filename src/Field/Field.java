package Field;

import MinePlacer.MinePlacer;

public class Field {

    private final Square[][] field;
    private final MinePlacer minePlacer;
    private final Size size;

    public Field(Size size, MinePlacer minePlacer) {
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
            Coordinate minePosition = minePlacer.nextCoordinate();
            field[minePosition.getX()][minePosition.getY()] = new MineSquare();
        }
    }

    public String getPlayerField() {
        String playerField = "";

        for (int x = 0; x < this.size.getHeight(); x++) {
            for (int y = 0; y < this.size.getWidth(); y++) {
                Coordinate coordinate = new Coordinate(x, y);
                if ((squareIsAMineAt(coordinate)) && (field[x][y].isRevealed())) {
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
                Coordinate coordinate = new Coordinate(x, y);
                this.revealSquare(coordinate);
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

    public boolean squareIsAMineAt(Coordinate coordinate) {
        int row = coordinate.getX();
        int col = coordinate.getY();
        return field[row][col].isAMine();
    }

    public void revealSquare(Coordinate coordinate) {
        int row = coordinate.getX();
        int col = coordinate.getY();
        field[row][col].reveal();
    }

    private void addHintsToField() {
        for (int x = 0; x < this.size.getHeight(); x++) {
            for (int y = 0; y < this.size.getWidth(); y++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (squareIsAMineAt(coordinate)) {
                    increaseHintCountAround(coordinate);
                }
            }
        }
    }

    private void increaseHintCountAround(Coordinate coordinate) {
        int currentX = coordinate.getX();
        int currentY = coordinate.getY();
        for (int x = currentX - 1; x <= currentX + 1; x++) {
            if (!(isOutOfBounds(x, this.size.getHeight())))
                for (int y = currentY - 1; y <= currentY + 1; y++) {
                    if (!isOutOfBounds(y, this.size.getWidth()) && !squareIsAMineAt(new Coordinate(x,y))) {
                        ((SafeSquare) field[x][y]).increaseHintCount();
                    }
                }
        }
    }

    private boolean isOutOfBounds(int coordinate, int maxValue) {
        return (coordinate < 0) || (coordinate >= maxValue);
    }

}
