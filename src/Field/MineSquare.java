package Field;

public class MineSquare implements Square {

    private String symbol = "*";

    @Override
    public boolean isAMine() {
        return true;
    }

    public String toString() {
        return symbol;
    }

}
