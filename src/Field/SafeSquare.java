package Field;

public class SafeSquare extends Square {

    private int hintCount = 0;

    public boolean isAMine() {
        return false;
    }

    public String toString() {
        if(this.isRevealed()){
            return String.valueOf(getHintCount());
        } else {
            return ".";
        }
    }

    void increaseHintCount() {
        hintCount++;
    }

    private int getHintCount() {
        return hintCount;
    }
}
