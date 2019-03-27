package MinePlacer;

import Field.Coordinates;

public interface IMinePlacer {

    int numberOfMines();

    Coordinates nextCoordinate();

}
