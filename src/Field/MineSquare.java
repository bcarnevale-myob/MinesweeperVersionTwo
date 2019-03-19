package Field;

public class MineSquare extends Square {

    private String stringValue = "*";

    @Override
    public boolean isAMine() {
        return true;
    }

    public String toString() {
        if(this.isRevealed()){
            return stringValue;
        } else {
            return ".";
        }
    }

}
