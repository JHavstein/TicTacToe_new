package dm550.tictactoe;

/** represents a tic tac toe board of a given size */
public class TTTBoard {

    /** 2-dimensional array representing the board
     * coordinates are counted from top-left (0,0) to bottom-right (size-1, size-1)
     * board[x][y] == 0   signifies free at position (x,y)
     * board[x][y] == i   for i > 0 signifies that Player i made a move on (x,y)
     */
    private int[][] board;

    /** size of the (quadratic) board */
    private int size;

    /** constructor for creating a copy of the board
     * not needed in Part 1 - can be viewed as an example
     */
    public TTTBoard(TTTBoard original) {
        this.size = original.size;
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                this.board[x][y] = original.board[x][y];
            }
        }
    }

    /** constructor for creating an empty board for a given number of players */
    public TTTBoard(int numPlayers) {
        this.size = numPlayers+1;
        this.board = new int[this.getSize()][this.getSize()];
    }

    /** checks whether the board is free at the given position */
    public boolean isFree(Coordinate c) {
        return this.board[c.getX()][c.getY()] == 0;
        //this is added
    }

    /** returns the players that made a move on (x,y) or 0 if the position is free */
    public int getPlayer(Coordinate c) {
        return this.board[c.getX()][c.getY()];
    }
    //this is added

    /** record that a given player made a move at the given position
     * checks that the given positions is on the board
     * checks that the player number is valid
     */
    public void addMove(Coordinate c, int player) {
        if (c.checkBoundaries(this.size,this.size) == true && player > 0 && player <= this.size-1) {
            this.board[c.getX()][c.getY()] = player;
        }
        else {
            throw new IllegalArgumentException("Error");
        }
    }
    //this is added

    /** returns true if, and only if, there are no more free positions on the board */
    public boolean checkFull() {
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                if (this.board[x][y] == 0)
                    return false;
            }
        }
        return true;
        //this is added
    }

    /** returns 0 if no player has won (yet)
     * otherwise returns the number of the player that has three in a row
     */
    public int checkWinning() {
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                Coordinate start = new XYCoordinate(x, y);
                if (checkSequence(start, 1, 1) > 0) {
                    return checkSequence(start, 1, 1);
                }
                if (checkSequence(start, -1, 1) > 0) {
                    return checkSequence(start, -1, 1);
                }
                if (checkSequence(start, 0, 1) > 0) {
                    return checkSequence(start, 0, 1);
                }
                if (checkSequence(start, 1, 0) > 0) {
                    return checkSequence(start, 1, 0);
                }
            }
        }
        return 0;
    }

    /** internal helper function checking one row, column, or diagonal */
    private int checkSequence(Coordinate start, int dx, int dy) {
        int x = start.getX();
        int y = start.getY();
        if (x+2*dx >= 0 && x+2*dx < this.size && y+2*dy >= 0 && y+2*dy < this.size) {
            if (this.board[x][y] == 0) {
                return 0;
            }
            if (this.board[x][y] == this.board[x + dx][y + dy] && this.board[x][y] == this.board[x + 2 * dx][y + 2 * dy]) {
                return this.board[start.getX()][start.getY()];
            }
        }

        return 0;
    }
    //this is added

    /** getter for size of the board */
    public int getSize() {
        return this.size;
    }

    /** pretty printing of the board
     * usefule for debugging purposes
     */
    public String toString() {
        String result = "";
        for (int y = 0; y < this.size; y++) {
            for (int x = 0; x < this.size; x++) {
                result += this.board[y][x]+" ";
            }
            result += "\n";
        }
        return result;
    }

}

