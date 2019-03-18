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

    public int getWidth() {
        return field.length;
    }

    public int getHeight() {
        return field[0].length;
    }

    public void placeMineSquareAt(int row, int col) {
        field[row][col] = new MineSquare();
    }

    public Square squareAtPosition(int row, int col) {
        return field[row][col];
    }
}
