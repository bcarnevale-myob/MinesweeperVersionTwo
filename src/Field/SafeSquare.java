package Field;

public class SafeSquare implements Square {

    private int hintCount = 0;
    private boolean isRevealed = false;

    @Override
    public boolean isAMine() {
        return false;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed() {
        isRevealed = true;
    }

    public String toString() {
        if(this.isRevealed()){
            return String.valueOf(hintCount);
        } else {
            return ".";
        }
    }

}
