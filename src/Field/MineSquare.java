package Field;

public class MineSquare extends Square {

    private String stringValue = "*";

    @Override
    public boolean isAMine() {
        return true;
    }

    @Override
    public boolean isRevealed() {
        return false;
    }

    public String toString() {
        if(this.isRevealed()){
            return stringValue;
        } else {
            return ".";
        }
    }

}
