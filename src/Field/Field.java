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

    public Square getSquareAt(int row, int col) {
        return field[row][col];
    }

    public String getRevealedBoard() {
        String revealedBoard = "";
        for(int x = 0; x < this.getHeight(); x++) {
            for(int y = 0; y < this.getWidth(); y++) {
                    revealedBoard += field[x][y].toString();
            }
            revealedBoard += "\n";
        }
        return revealedBoard;
    }

   /* public String getPlayerBoard() {
        String playerBoard = "";
        for(int x = 0; x < this.getHeight(); x++) {
            for(int y = 0; y < this.getWidth(); y++) {
                if(revealSquare(x,y)) {
                    playerBoard += field[x][y].toString();
                } else {
                    playerBoard += ".";
                }
            }
            playerBoard += "\n";
        }
        return playerBoard;
    }*/
   
}
