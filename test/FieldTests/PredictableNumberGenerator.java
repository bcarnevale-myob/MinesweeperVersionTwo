package FieldTests;

import Field.NumberGenerator;

public class PredictableNumberGenerator implements NumberGenerator {

    private final int numberOfMines;
    private final int mine1Row;
    private final int mine1Column;
    private final int mine2Row;
    private final int mine2Column;
    private int calledTimes = 0;

    // public PredictableNumberGenerator(List<Coordinates> mines) { }

    public PredictableNumberGenerator(int numberOfMines, int mine1Row, int mine1Column) {
        this(numberOfMines,mine1Row,mine1Column,0,0);
    }

    public PredictableNumberGenerator(int numberOfMines, int mine1Row, int mine1Column, int mine2Row, int mine2Column) {
        this.numberOfMines = numberOfMines;
        this.mine1Row = mine1Row;
        this.mine1Column = mine1Column;
        this.mine2Row = mine2Row;
        this.mine2Column = mine2Column;
    }

    @Override
    public int nextInt(int upperBound) {
        calledTimes++;
        if(calledTimes == 1) {
            return this.numberOfMines;
        } else if(calledTimes == 2) {
            return this.mine1Row;
        } else if(calledTimes == 3) {
            return this.mine1Column;
        } else if(calledTimes == 4) {
            return this.mine2Row;
        }

        return this.mine2Column;
    }

}
