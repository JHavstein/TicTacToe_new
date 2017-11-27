package dm550.tictactoe;

/** represents a tic tac toe board of a given size */
import java.lang.Math;

public class TTTBoard {

    /**
     * 2-dimensional array representing the board
     * coordinates are counted from top-left (0,0) to bottom-right (size-1, size-1)
     * board[x][y] == 0   signifies free at position (x,y)
     * board[x][y] == i   for i > 0 signifies that Player i made a move on (x,y)
     */
    public int[][] board;

    /**
     * size of the (quadratic) board
     */
    public int size;

    /**
     * constructor for creating a copy of the board
     * not needed in Part 1 - can be viewed as an example
     */
    public TTTBoard(TTTBoard original) {
        this.size = original.size;
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                this.board[y][x] = original.board[y][x];
            }
        }
    }

    /**
     * constructor for creating an empty board for a given number of players
     */
    public TTTBoard(int numPlayers) {
        this.size = numPlayers + 1;
        this.board = new int[this.getSize()][this.getSize()];
    }

    /**
     * checks whether the board is free at the given position
     */
    public boolean isFree(Coordinate c) {
        if (this.board[c.getX()][c.getY()] == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * returns the players that made a move on (x,y) or 0 if the positon is free
     */
    public int getPlayer(Coordinate c) {
        if (isFree(c) == true) {
            return 0;
        } else {
            return this.board[c.getX()][c.getY()];
        }
    }

    /**
     * record that a given player made a move at the given position
     * checks that the given positions is on the board
     * checks that the player number is valid
     */
    public void addMove(Coordinate c, int player, int numPlayers) {
        if (c.checkBoundaries(this.size, this.size) == true && player <= numPlayers) { // coordinate is outside board
            this.board[c.getX()][c.getY()] = player;
        } else {
            throw new IllegalArgumentException("Error");
        }
    }

    /**
     * returns true if, and only if, there are no more free positions on the board
     */
    public boolean checkFull() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (this.board[i][j] == 0) {
                    return false; // if board[i][j]==0, then the board is not full
                }
            }
        }
        return true; // if no 0's were encountered while traversing the board array
    }

    /**
     * returns 0 if no player has won (yet)
     * otherwise returns the number of the player that has three in a row
     */

    public int checkWinning(Coordinate start) {
        // manuelly runs through all possible directions from alle possible
        // coordinates. checkWinningAlternative() gives a more sophisticated solution if
        // we are allowed to use a coordinate in the check for a win --> then we could
        // significantly limit the number of checks nessecary to determine whether a player has
        // won or not as long as the check is run each time a new move has been made.
        for (int i=0; i<=2; i++){
            for (int j=0; j<=2; j++){
                if (checkSequence(start, i-1, j-1) > 0){
                    return this.board[start.getX()][start.getY()];
                }
                else{;}
            }
        }
        return 0;
    } // ends checkWinning


    /**
     * internal helper function checking one row, column, or diagonal
     */
    public int checkSequence(Coordinate start, int dx, int dy) { // checks only specific direction with given dx dy
        int x0 = start.getX();
        int y0 = start.getY();
        int x1 = start.getX()+dx;
        int y1 = start.getY()+dy;
        int x2 = start.getX()+dx+dx;
        int y2=start.getY()+dy+dy;
        if (x0 > this.size-1 || y0 > this.size-1 || x1 > this.size-1 ||
                y1 > this.size-1 || x2 > this.size-1 || y2 > this.size-1){
            return 0;
        }
        else if (this.board[x0][y0] == 0 || this.board[x1][y1] == 0 ||
                this.board[x2][y2] == 0){
            return 0;
        }
        else if (this.board[x0][y0] == this.board[x1][y1] &&
                this.board[x0][y0]==this.board[x2][y2]){ // three in a row in the direction dx/dy
            return this.board[x0][y0];
        }
        else{
            return 0;
        }
    }  // ends checkSqeuence()

    /**
     * getter for size of the board
     */
    public int getSize() {
        return this.size;
    }

    /**
     * pretty printing of the board
     * usefule for debugging purposes
     */
    public String toString() {
        String result = "";
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                result += this.board[y][x] + " ";
            }
            result += "\n";
        }
        return result;
    }

} // ends class













