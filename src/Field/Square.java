package Field;

public abstract class Square {

    private boolean isRevealed = false;
    private int hintCount = 0;

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal() {
        isRevealed = true;
    }

    public int getHintCount() {
        return hintCount;
    }

    public void increaseHintCount() {
        hintCount++;
    }

    public abstract boolean isAMine();
}
