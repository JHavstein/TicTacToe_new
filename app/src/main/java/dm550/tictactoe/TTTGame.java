package dm550.tictactoe;

public class TTTGame implements Game {

    public int currentPlayer;

    public int numPlayers;

    public TTTBoard board;

    public UserInterface ui;

    public TTTGame(int numPlayers) {
        if (numPlayers == 0){
            this.currentPlayer = 1;
            this.numPlayers = 0;
            this.board = new TTTBoard(0);
            addMove2(new XYCoordinate(0,0),2);
        }
        else if (numPlayers == 1){
            this.currentPlayer = 1;
            this.numPlayers = 1;
            this.board = new TTTBoard(numPlayers);
        }
        else {
            this.currentPlayer = 1;
            this.numPlayers = numPlayers;
            this.board = new TTTBoard(numPlayers);
        }
    }

    @Override
    public String getTitle() {
        if (this.numPlayers == 0 || this.numPlayers == 1) {
            return "Tic Tac Toe with AI";
        }
        return this.numPlayers+"-way Tic Tac Toe";
    }

    @Override
    public void addMove(Coordinate pos) {
        this.board.addMove(pos, this.currentPlayer);
        if (this.currentPlayer == this.numPlayers) {
            this.currentPlayer = 1;
        } else {
            this.currentPlayer++;
        }
    }

    @Override
    public void addMove2(Coordinate pos, int player) {
        this.board.addMove2(pos, player);
    }

    @Override
    public String getContent(Coordinate pos) {
        String result = "";
        int player = this.board.getPlayer(pos);
        if (player > 0) {
            result += player;
        }
        return result;
    }

    @Override
    public int getHorizontalSize() {
        return this.board.getSize();
    }

    @Override
    public int getVerticalSize() {
        return this.board.getSize();
    }

    @Override
    public void checkResult() {
        int winner = this.board.checkWinning();
        if (winner > 0) {
            this.ui.showResult("Player "+winner+" wins!");
        }
        else if (this.board.checkFull()) {
            this.ui.showResult("This is a DRAW!");
        }
    }

    @Override
    public boolean isFree(Coordinate pos) {
        return this.board.isFree(pos);
    }

    @Override
    public void setUserInterface(UserInterface ui) {this.ui = ui;}

    public String toString() {return "Board before Player "+this.currentPlayer+" of "+this.numPlayers+"'s turn:\n"+this.board.toString();}

    @Override
    public int[][] getBoard(){
        return this.board.getBoard();
    }

    @Override
    public int numberOfPlayers(){
        return this.numPlayers;
    }

    public boolean isFull(){
        return this.board.checkFull();
    }

}
