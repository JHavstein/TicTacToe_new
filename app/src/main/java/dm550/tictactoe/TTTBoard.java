package dm550.tictactoe;

/** represents a tic tac toe board of a given size */
public class TTTBoard {

    /** 2-dimensional array representing the board
     * coordinates are counted from top-left (0,0) to bottom-right (size-1, size-1)
     * board[x][y] == 0   signifies free at position (x,y)
     * board[x][y] == i   for i > 0 signifies that Player i made a move on (x,y)
     */
    public int[][] board;

    /** size of the (quadratic) board */
    public int size;

    /** constructor for creating a copy of the board
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

    /** constructor for creating an empty board for a given number of players */
    public TTTBoard(int numPlayers) {
        this.size = numPlayers+1;
        this.board = new int[this.getSize()][this.getSize()];
    }

    /** checks whether the board is free at the given position */
    public boolean isFree(XYCoordinate c) {
        if (this.board[c.getX()][c.getY()] == 0){
            return true;
        }
        else{
            return false;
        }
    }

    /** returns the players that made a move on (x,y) or 0 if the positon is free */
    public int getPlayer(XYCoordinate c) {
        if (isFree(c) == true){
            return 0;
        }
        else{
            return this.board[c.getX()][c.getY()];
        }
    }

    /** record that a given player made a move at the given position
     * checks that the given positions is on the board
     * checks that the player number is valid
     */
    public void addMove(XYCoordinate c, int player, int numPlayers) {
        if (c.checkBoundaries(this.size, this.size) == false){ // coordinate is outside board
            throw new IllegalArgumentException();
        }
        else if (player > numPlayers){
            throw new IllegalArgumentException(); // player number is invaled
        }
        else if (isFree(c) == false){
            ; // how should it be handles if there is a player at given coordinate?
        }
        else{
            this.board[c.getX()][c.getY()] = player; // player added to coordinate
        }
    }

    /** returns true if, and only if, there are no more free positions on the board */
    public boolean checkFull() {
        for (int i = 0; i < this.size; i++){
            for (int j = 0; j < this.size; j++)  {
                if (this.board[i][j] == 0){
                    return false; // if board[i][j]==0, then the board is not full
                }
                else{
                    ; // pass
                }
            }
        }
        return true; // if no 0's were encountered while traversing the board array
    }

    /** returns 0 if no player has won (yet)
     * otherwise returns the number of the player that has three in a row
     */
    public int checkWinning() {
        // TODO
return -1
    }


    /** internal helper function checking one row, column, or diagonal */
    public int checkSequence(XYCoordinate start, int dx, int dy) { // could be made shorter somehow
        int i;
        int temp = this.board[start.getX()][start.getY()];// start coordinate
        if (dx == 1 && dy == 0){
            for (i = 0; i <= 2; i++){
                if (this.board[start.getX()+i][start.getY()] != temp) {
                    return 0;
                }
                 else{
                        return temp; // player at start position has three in a row
                    }
                }
            }
        else if (dx == 0 && dy == 1){
            for(i = 0; i <= 2; i++){
                if (this.board[start.getX()][start.getY()+i] != temp){
                    return 0;
                }
                else{
                    return temp; // player at start position has three in a column
                }
            }
        }
        else if (dx == 1 && dy == 1) {
            for (i = 0; i <= 2; i++) {
                if (this.board[start.getX() + i][start.getY() + i] != temp) {
                    return 0;
                } else {
                    return temp; // player has three in a row in a diagonal towards the right
                }
            }
        }
        else if (dx == 1 && dy == -1){
            for (i = 0; i <= 2; i++){
                if (this.board[start.getX()][start.getY()] != temp){
                    return 0;
                }
                else{
                    return temp; // player has three in a row in a diagonal towards the left
                }
            }
        }
        else {
            return 0; // if no sequence of three in a row
        }
        return -1; // if error - conditional never entered
    }  // ends checkSqeuence()

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
