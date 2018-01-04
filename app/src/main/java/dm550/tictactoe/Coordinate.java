package dm550.tictactoe;

public interface Coordinate {
    int getX();
    int getY();
    boolean checkBoundaries(int xSize, int ySize);
    Coordinate shift(int dx, int dy);

}

