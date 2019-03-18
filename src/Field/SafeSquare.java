package Field;

public class SafeSquare implements Square {

    private int hintCount = 0;

    @Override
    public boolean isAMine() {
        return false;
    }

    @Override
    public boolean isRevealed() {
        return false;
    }

    public String toString() {
        return String.valueOf(hintCount);
    }

}
