package Field;

public class MineSquare extends Square {

    private String token = "*";

    public boolean isAMine() {
        return true;
    }

    public String toString() {
        if(this.isRevealed()){
            return token;
        } else {
            return ".";
        }
    }

}
