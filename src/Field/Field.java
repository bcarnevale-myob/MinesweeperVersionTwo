package Field;

public class Field {


    private final Square[][] field;

    public Field(int row, int col) {
        this.field = new Square[row][col];
    }

    public boolean isEmpty() {
        return true;
    }
    
}
