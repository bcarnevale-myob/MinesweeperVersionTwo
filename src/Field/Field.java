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

    public String getCurrentField() {
        String playerField = "";

        for (int x = 0; x < this.size.getHeight(); x++) {
            for (int y = 0; y < this.size.getWidth(); y++) {
                Coordinate coordinate = new Coordinate(x, y);
                if ((hasMineAt(coordinate)) && (field[x][y].isRevealed())) {
                    return getRevealedField();
                }
                playerField += field[x][y].toString();
            }
            playerField += "\n";
        }

        return playerField;
    }

    // This method is only used by the tests, in the future we would find a way for this to be private and still testable
    public String getRevealedField() {
        String revealedField = "";

        for (int x = 0; x < this.size.getHeight(); x++) {
            for (int y = 0; y < this.size.getWidth(); y++) {
                Coordinate coordinate = new Coordinate(x, y);
                this.hit(coordinate);
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

    public boolean hasMineAt(Coordinate coordinate) {

        return field[coordinate.getX()][coordinate.getY()].isAMine();
    }

    public void hit(Coordinate coordinate) {

        field[coordinate.getX()][coordinate.getY()].reveal();
    }

    private void addHintsToField() {
        for (int x = 0; x < this.size.getHeight(); x++) {
            for (int y = 0; y < this.size.getWidth(); y++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (hasMineAt(coordinate)) {
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
                    if (!isOutOfBounds(y, this.size.getWidth()) && !hasMineAt(new Coordinate(x,y))) {
                        ((SafeSquare) field[x][y]).increaseHintCount();
                    }
                }
        }
    }

    private boolean isOutOfBounds(int coordinate, int maxValue) {
        return (coordinate < 0) || (coordinate >= maxValue);
    }

}
