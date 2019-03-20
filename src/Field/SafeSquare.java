package Field;

public class SafeSquare extends Square {

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

}
