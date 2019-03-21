package Field;

public class Field {

    private final Square[][] field;
    private final NumberGenerator numberGenerator;

    public Field(int row, int col, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.field = new Square[row][col];
        for(int x = 0; x < row; x++) {
            for(int y = 0; y < col; y++) {
                field[x][y] = new SafeSquare();
            }
        }
        this.setRandomMinePositions();
    }

    private void setRandomMinePositions() {
        int row;
        int col;

        int numberOfMinesToPlace = numberGenerator.nextInt(numberOfSquares());

        for(int i = 1; i <= numberOfMinesToPlace; i++) {
            row = numberGenerator.nextInt(this.getHeight());
            col = numberGenerator.nextInt(this.getWidth());
            this.placeMineSquare(row, col);
        }
    }

    public String getPlayerField() {
        String playerField = "";
        addHintsToField();
        for(int x = 0; x < this.getHeight(); x++) {
            for(int y = 0; y < this.getWidth(); y++) {
                if((squareIsAMine(x,y)) && (field[x][y].isRevealed())) {
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

    public void placeMineSquare(int row, int col) {
        field[row][col] = new MineSquare();
    }

    public boolean squareIsAMine(int row, int col) {
        return field[row][col].isAMine();
    }

    public void revealSquare(int row, int col){
        field[row][col].reveal();
    }

    private void revealAllMines() {
        for(int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getWidth(); y++) {
                if(squareIsAMine(x,y)) {
                    revealSquare(x,y);
                }
            }
        }
    }

    private void addHintsToField() {
        for(int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getWidth(); y++) {
                if(squareIsAMine(x,y)) {
                    increaseHintCountAround(x,y);
                }
            }
        }
    }

    private void increaseHintCountAround(int row, int col) {
        for(int x = row - 1; x <= row + 1; x++) {
            if(!(isOutOfBounds(x, this.getHeight())))
                for(int y = col - 1; y <= col + 1; y++) {
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

}
