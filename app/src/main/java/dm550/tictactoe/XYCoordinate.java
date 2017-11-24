package dm550.tictactoe;

public class XYCoordinate implements Coordinate {

    /** variables specifying horizontal position on the board */
    private int x;

    /** variable specifying vertical positoin on the board */
    private int y;

    /** constructor creating a Coordinate from x and y values */
    public XYCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public boolean checkBoundaries(int xSize, int ySize) {
        if (this.getX() >= xSize){ // x-coordinate is > xSize-1
            return false;
        }
        else if (this.getY() >= ySize){ // y-coordinate is > xSize-1
            return false;
        }
        else if (this.getX() < 0 || this.getY() < 0){ // either x or y is negative
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public Coordinate shift(int dx, int dy) {
        int newX = this.getX() + dx; // makes new x from existing
        int newY = this.getY() + dy; // makes new y from existing
        return Coordinate(newX, newY); // returns the new coordinates as class isntances of
        // XYCoordinate (the return type was originally 'Coordinate' but coordinate is not a class
        // - it's an interface? Error from Peter? Misunderstanding from me?
    }

}
