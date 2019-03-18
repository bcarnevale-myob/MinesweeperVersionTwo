package Field;

public class MineSquare implements Square {

    private String symbol = "*";
    private boolean isRevealed = false;

    @Override
    public boolean isAMine() {
        return true;
    }

    @Override
    public boolean revealSquare() {
        isRevealed = true;
        return isRevealed;
    }

    public String toString() {
        return symbol;
    }

}
