package MinePlacer;

import Field.Coordinates;

public interface MinePlacer {

    int numberOfMines();

    Coordinates nextCoordinate();

}
