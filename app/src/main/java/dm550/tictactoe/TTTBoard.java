package dm550.tictactoe;


public class TTTBoard {
    private int[][] board;

    private int size;

    public TTTBoard(TTTBoard original) {
        this.size = original.size;
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                this.board[x][y] = original.board[x][y];
            }
        }
    }

    public TTTBoard(int numPlayers) {
        if (numPlayers == 0){
            this.size = 3;
            this.board = new int[this.getSize()][this.getSize()];
        }
        else if (numPlayers == 1){
            this.size = 3;
            this.board = new int[this.getSize()][this.getSize()];
        }
        else {
            this.size = numPlayers + 1;
            this.board = new int[this.getSize()][this.getSize()];
        }
    }

    public boolean isFree(Coordinate c) {
        return this.board[c.getX()][c.getY()] == 0;
        //this is added
    }

    public int getPlayer(Coordinate c) {
        return this.board[c.getX()][c.getY()];
    }

    public void addMove(Coordinate c, int player) {
        if (c.checkBoundaries(this.size,this.size) && player > 0 && player < this.size) {
            this.board[c.getX()][c.getY()] = player;
        }
        else {
            throw new IllegalArgumentException("Error");
        }
    }

    public void addMove2(Coordinate c, int player){
        this.board[c.getX()][c.getY()] = player;
    }

    public boolean checkFull() {
        for (int x = 0; x < this.size; x++) {
            for (int y = 0; y < this.size; y++) {
                if (this.board[x][y] == 0)
                    return false;
            }
        }
        return true;
    }

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


    public int getSize() {
        return this.size;
    }

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

    public int[][] getBoard(){
        return this.board;
    }


}
