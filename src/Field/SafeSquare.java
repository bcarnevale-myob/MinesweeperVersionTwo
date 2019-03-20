package Field;

public class SafeSquare extends Square {

    @Override
    public boolean isRevealed() {
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
