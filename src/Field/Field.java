package Field;

public class Field {

    private final Square[][] field;

    public Field(int row, int col) {
        this.field = new Square[row][col];
        for(int x = 0; x < row; x++) {
            for(int y = 0; y < col; y++) {
                field[x][y] = new SafeSquare();
            }
        }
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        for(int x = 0; x < field.length; x++) {
            for(int y = 0; y < field[x].length; y++) {
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

    public void placeMineSquare(int row, int col) {
        field[row][col] = new MineSquare();
    }

    public boolean squareIsAMine(int row, int col) {
        return field[row][col].isAMine();
    }

    public void revealSquare(int row, int col){
        field[row][col].setRevealed();
    }

    public String getPlayerField() {
        String playerField = "";
        addHintsToBoard();
        for(int x = 0; x < this.getHeight(); x++) {
            for(int y = 0; y < this.getWidth(); y++) {
                    playerField += field[x][y].toString();
            }
            playerField += "\n";
        }
        return playerField;
    }

    public String getRevealedField() {
        String revealedBoard = "";
        addHintsToBoard();
        for(int x = 0; x < this.getHeight(); x++) {
            for(int y = 0; y < this.getWidth(); y++) {
                this.revealSquare(x,y);
                revealedBoard += field[x][y].toString();
            }
            revealedBoard += "\n";
        }
        return revealedBoard;
    }

    public void addHintsToBoard() {
        for(int x = 0; x < this.getHeight(); x++) {
            for (int y = 0; y < this.getWidth(); y++) {
                if(squareIsAMine(x,y)) {
                    increaseHintCountAround(x,y);
                }
            }
        }
    }

    public void increaseHintCountAround(int row, int col) {
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
