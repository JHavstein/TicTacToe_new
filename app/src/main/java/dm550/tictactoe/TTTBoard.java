package dm550.tictactoe;

/** represents a tic tac toe board of a given size */
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
    public int checkWinning() {
        // manuelly runs through all possible directions from alle possible
        // coordinates. checkWinningAlternative() gives a more sophisticated solution if
        // we are allowed to use a coordinate in the check for a win --> then we could
        // significantly limit the number of checks nessecary to determine whether a player has
        // won or not as long as the check is run each time a new move has been made.
        for (int i = 0; i <= this.size; i++) {
            for (int j = 0; i <= this.size; j++) {

                Coordinate tmp = new XYCoordinate(i, j); // new coordinate for each position on board

                for (int r = -1; r <= 1; r++) {
                    for (int s = -1; s <= 1; s++) {
                        if (checkSequence(tmp, r, s) != 0) { // checks all 8 possible directions for a sequence
                            return checkSequence(tmp, r, s); // player who has won
                        }
                    }
                }
            }
        }
        return 0; // no player has won
    } // ends checkWinning


    /**
     * internal helper function checking one row, column, or diagonal
     */
    public int checkSequence(Coordinate start, int dx, int dy) { // could be made shorter somehow
        int temp = this.board[start.getX()][start.getY()];// start coordinate (player)
        int x = start.getX();
        int y = start.getY();
        for (int i = 0; i < 2; i++) {
            x = x + dx;
            y = y + dy;
            if (this.board[x][y] != temp) {
                return 0;
            }
        }
        return temp;
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

    public int checkWinningAlternative(Coordinate c) { // added parameter
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (checkSequence(c, i, j) != 0) {
                    return checkSequence(c, i, j); // returns number of player who has won
                }
            }
        }
        Coordinate newCoord1 = new XYCoordinate(c.getX() - 1, c.getY() - 1);
        Coordinate newCoord2 = new XYCoordinate(c.getX(), c.getY() - 1);
        Coordinate newCoord3 = new XYCoordinate(c.getX() + 1, c.getY() - 1);
        Coordinate newCoord4 = new XYCoordinate(c.getX() + 1, c.getY());

        if (checkSequence(newCoord1, 1, 1) != 0) {
            return checkSequence(newCoord1, 1, 1);
        } else if (checkSequence(newCoord2, 0, 1) != 0) {
            return checkSequence(newCoord2, 0, 1);
        } else if (checkSequence(newCoord3, -1, 1) != 0) {
            return checkSequence(newCoord3, -1, 1);
        } else if (checkSequence(newCoord4, -1, 0) != 0) {
            return checkSequence(newCoord4, -1, 0);
        }
        return 0;
    }

} // ends class













