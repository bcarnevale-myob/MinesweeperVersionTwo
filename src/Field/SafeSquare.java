package Field;

public class SafeSquare extends Square {

    public String toString() {
        if(this.isRevealed()){
            return String.valueOf(getHintCount());
        } else {
            return ".";
        }
    }

}
