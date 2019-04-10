package MinePlacer;

import Field.Coordinate;

public interface IMinePlacer {

    int numberOfMines();

    Coordinate nextCoordinate();

}
