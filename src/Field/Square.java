package Field;

public abstract class Square {

    private boolean isRevealed = false;

    boolean isRevealed() {
        return isRevealed;
    }

    void reveal() {
        isRevealed = true;
    }

    public abstract boolean isAMine();
}
