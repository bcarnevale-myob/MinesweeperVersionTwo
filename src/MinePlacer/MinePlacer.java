package MinePlacer;

import Field.Coordinate;

public interface MinePlacer {

    int numberOfMines();

    Coordinate nextCoordinate();

}
