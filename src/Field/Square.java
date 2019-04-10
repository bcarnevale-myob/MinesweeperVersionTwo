package Field;

public abstract class Square {

    private int hintCount = 0;

    private boolean isRevealed = false;

    public boolean isRevealed() {
        return isRevealed;
    }

    public void reveal() {
        isRevealed = true;
    }

    public abstract boolean isAMine();

    public void increaseHintCount() {
        hintCount++;
    }

    public int getHintCount() {
        return hintCount;
    }

}
