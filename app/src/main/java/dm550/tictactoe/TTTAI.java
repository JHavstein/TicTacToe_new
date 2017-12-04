package dm550.tictactoe;

/**
 * Created by jonasalexanderhavsteineriksen on 04/12/2017.
 */
public class TTTAI extends XYCoordinate implements Coordinate {

    private int[][] AIboard;

    private int x;

    private int y;

    public TTTAI(int[][] board){
        this.AIboard = board;

    }

    // For testing
    private Coordinate generateMove(int[][] test){
        for (int y = 0; y < test.length; y++) {
            for (int x = 0; x < test.length; x++) {
                if (test[x][y] == 0) {
                    return new XYCoordinate(x, y);
                }
                else{};
            }
        }
        throw new IllegalArgumentException("");
    }

    @Override
    public int getX() {
        return generateMove(this.AIboard).getX();
    }

    @Override
    public int getY() {
        return generateMove(this.AIboard).getY();
    }


} // ends class