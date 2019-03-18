package Field;

public class MineSquare implements Square {

    private String symbol = "*";
    private boolean isRevealed = false;

    @Override
    public boolean isAMine() {
        return true;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed() {
        isRevealed = true;
    }

    public String toString() {
        if(this.isRevealed()){
            return String.valueOf(symbol);
        } else {
            return ".";
        }
    }

}
