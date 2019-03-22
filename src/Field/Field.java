package Field;

public class Field {

    private final Square[][] field;
    private final MinePlacer minePlacer;

    public Field(int height, int width, MinePlacer minePlacer) {
        this.minePlacer = minePlacer;
        this.field = new Square[height][width];

        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                field[x][y] = new SafeSquare();
            }
        }
            this.setRandomMinePositions();
    }

    private void setRandomMinePositions() {
        int numberOfMinesToPlace = minePlacer.numberOfMines(numberOfSquares());

        for(int i = 0; i < numberOfMinesToPlace; i++) {
            Coordinates minePosition = minePlacer.nextCoordinate();
            field[minePosition.getX()][minePosition.getY()] = new MineSquare();
        }
    }

    public String getPlayerField() {
        String playerField = "";
        addHintsToField();

        for(int x = 0; x < this.getHeight(); x++) {
            for(int y = 0; y < this.getWidth(); y++) {
                Coordinates position = new Coordinates(x,y);
                if((squareIsAMine(position)) && (field[x][y].isRevealed())) {
                    revealAllMines();
                }
                playerField += field[x][y].toString();
            }
            playerField += "\n";
        }
        return playerField;
    }

    public String getRevealedField() {
        String revealedField = "";
        addHintsToField();
        for(int x = 0; x < this.getHeight(); x++) {
            for(int y = 0; y < this.getWidth(); y++) {
                this.revealSquare(x,y);
                revealedField += field[x][y].toString();
            }
            revealedField += "\n";
        }
        return revealedField;
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        for(int x = 0; x < this.getHeight(); x++) {
            for(int y = 0; y < this.getWidth(); y++) {
                if(field[x][y] instanceof MineSquare) {
                    isEmpty = false;
                }
            }
        }
        return isEmpty;
    }

    public int getHeight() {
        return this.field.length;
    }

    public int getWidth() {
        return this.field[0].length;
    }

    private int numberOfSquares() {
        return this.getHeight()*this.getWidth();
    }

    public boolean squareIsAMine(Coordinates coordinate) {
        int row = coordinate.getX();
        int col = coordinate.getY();
        return field[row][col].isAMine();
    }

    public void revealSquare(int row, int col) {
        field[row][col].reveal();
    }

    private void revealAllMines() {
        for(int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getWidth(); y++) {
                Coordinates position = new Coordinates(x,y);
                if(squareIsAMine(position)) {
                    revealSquare(x,y);
                }
            }
        }
    }

    private void addHintsToField() {
        for(int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getWidth(); y++) {
                Coordinates position = new Coordinates(x,y);
                if(squareIsAMine(position)) {
                    increaseHintCountAround(x,y);
                }
            }
        }
    }

    private void increaseHintCountAround(int x, int y) {
        for(int currentX = x - 1; currentX <= x + 1; currentX++) {
            if(!(isOutOfBounds(currentX, this.getHeight())))
                for(int currentY = y - 1; currentY <= y + 1; currentY++) {
                    if(!(isOutOfBounds(currentY, this.getWidth()))) {
                        field[currentX][currentY].increaseHintCount();
                    }
                }
        }
    }

    private boolean isOutOfBounds(int position, int maxValue) {
        if((position < 0) || (position >= maxValue)) {
            return true;
        }
        return false;
    }

}
