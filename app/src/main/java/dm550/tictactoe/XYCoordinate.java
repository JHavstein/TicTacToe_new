package dm550.tictactoe;

public class XYCoordinate implements Coordinate {

    private int x;

    private int y;

    public XYCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public XYCoordinate() {
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
        if (this.x <= xSize && this.y <= ySize && this.x >= 0 && this.y >= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Coordinate shift(int dx, int dy) {
        return new XYCoordinate(this.x+dx,this.y+dy);

    }

}
