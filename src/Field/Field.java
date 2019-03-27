package Field;

import MinePlacer.IMinePlacer;

public class Field {

    private final Square[][] field;
    private final IMinePlacer minePlacer;

    public Field(Size size, IMinePlacer minePlacer) {
        this.minePlacer = minePlacer;
        this.field = new Square[size.getHeight()][size.getWidth()];

        for(int x = 0; x < size.getHeight(); x++) {
            for(int y = 0; y < size.getWidth(); y++) {
                field[x][y] = new SafeSquare();
            }
        }
            this.setRandomMinePositions();
    }

    private void setRandomMinePositions() {
        int numberOfMinesToPlace = minePlacer.numberOfMines();

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
                Coordinates position = new Coordinates(x,y);
                this.revealSquare(position);
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

    public boolean squareIsAMine(Coordinates position) {
        int row = position.getX();
        int col = position.getY();
        return field[row][col].isAMine();
    }

    public void revealSquare(Coordinates position) {
        int row = position.getX();
        int col = position.getY();
        field[row][col].reveal();
    }

    private void revealAllMines() {
        for(int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getWidth(); y++) {
                Coordinates position = new Coordinates(x,y);
                if(squareIsAMine(position)) {
                    revealSquare(position);
                }
            }
        }
    }

    private void addHintsToField() {
        for(int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getWidth(); y++) {
                Coordinates position = new Coordinates(x,y);
                if(squareIsAMine(position)) {
                    increaseHintCountAround(position);
                }
            }
        }
    }

    private void increaseHintCountAround(Coordinates position) {
        int currentX = position.getX();
        int currentY = position.getY();
        for(int x = currentX - 1; x <= currentX + 1; x++) {
            if(!(isOutOfBounds(x, this.getHeight())))
                for(int y = currentY - 1; y <= currentY + 1; y++) {
                    if(!(isOutOfBounds(y, this.getWidth()))) {
                        field[x][y].increaseHintCount();
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

    public String printField() {
        String result = "";

        for (int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getWidth(); y++) {
                result = result + this.field[x][y].toString();
            }
            result = result + "\n";
        }
        return result;
    }

}
