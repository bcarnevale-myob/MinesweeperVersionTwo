package Field;

public class SafeSquare implements Square {

    private int hintCount = 0;
    private boolean isRevealed = false;

    @Override
    public boolean isAMine() {
        return false;
    }

    @Override
    public boolean revealSquare() {
        return true;
    }

    public String toString() {
        return String.valueOf(hintCount);
    }

}
