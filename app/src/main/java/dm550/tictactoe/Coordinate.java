package dm550.tictactoe;

public interface Coordinate {
    
    public int getX();

    public int getY();
    
    public boolean checkBoundaries(int xSize, int ySize);

    public Coordinate shift(int dx, int dy);

}

