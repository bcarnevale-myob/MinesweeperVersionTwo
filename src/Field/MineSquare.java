package Field;

public class MineSquare implements Square {

    private String symbol = "*";

    @Override
    public boolean isAMine() {
        return true;
    }

    @Override
    public boolean isRevealed() {
        return false;
    }

    public String toString() {
        return symbol;
    }

}
