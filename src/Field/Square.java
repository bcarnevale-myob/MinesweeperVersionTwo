package Field;

public abstract class Square {

    private boolean isRevealed = false;
    private int hintCount = 0;

    boolean isAMine() {
        return false;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed() {
        isRevealed = true;
    }

    public int getHintCount() {
        return hintCount;
    }

    public void increaseHintCount() {
        hintCount++;
    }
}
