package dm550.tictactoe;

public interface Game {

    String getTitle();
    
    int getHorizontalSize();

    int getVerticalSize();

    String getContent(Coordinate pos);

    void addMove(Coordinate pos);

    void addMove2(Coordinate pos, int i);

    void checkResult();

    boolean isFree(Coordinate pos);
    
    void setUserInterface(UserInterface ui);

    int[][] getBoard();

    int numberOfPlayers();

    boolean isFull();

}
