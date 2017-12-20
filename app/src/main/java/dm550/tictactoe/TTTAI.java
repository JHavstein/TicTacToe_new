package dm550.tictactoe;

public class TTTAI extends XYCoordinate implements Coordinate {

    private int[][] AIboard;

    public TTTAI(int[][] board){
        this.AIboard = board;
    }

    @Override
    public int getX() {
        Coordinate c = AIMove(2, 1);
        return c.getX();}

    @Override
    public int getY() {
        Coordinate c = AIMove(2,1);
        return c.getY();
    }

    public Coordinate AIMove(int AI, int player){
        return AIWin(AI, player);
    }

    public Coordinate AIWin(int AI, int player){
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (this.AIboard[x][y] == 0) {
                    this.AIboard[x][y] = AI;
                    if (checkWinning2() == AI){
                        this.AIboard[x][y] = 0;
                        System.out.println("AIWin");
                        return new XYCoordinate(x,y);
                    }
                    else {this.AIboard[x][y] = 0;}
                }
            }
        }
        return oppositeWin(AI, player);
    }

    public Coordinate oppositeWin(int AI, int player){
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (this.AIboard[x][y] == 0) {
                    this.AIboard[x][y] = player;
                    if (checkWinning2() == player){
                        this.AIboard[x][y] = 0;
                        System.out.println("oppositeWin");
                        return new XYCoordinate(x,y);
                    }
                    else {this.AIboard[x][y] = 0;}
                }
            }
        }
        return AIFork(AI, player);
    }

    public Coordinate AIFork(int AI, int player) {
        if (this.AIboard[0][0] == AI && this.AIboard[0][2] == AI){
            if(this.AIboard[2][0] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(2,0);
            }
            else if(this.AIboard[2][2] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(2,2);
            }
        }
        else if (this.AIboard[0][0] == AI && this.AIboard[2][0] == AI){
            if(this.AIboard[0][2] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(0,2);
            }
            else if(this.AIboard[2][2] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(2,2);
            }
        }
        else if (this.AIboard[0][0] == AI && this.AIboard[2][2] == AI){
            if(this.AIboard[2][0] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(2,0);
            }
            else if(this.AIboard[0][2] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(0,2);
            }
        }
        else if (this.AIboard[2][2] == AI && this.AIboard[0][2] == AI){
            if(this.AIboard[2][0] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(2,0);
            }
            else if(this.AIboard[0][0] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(0,0);
            }
        }
        else if (this.AIboard[2][2] == AI && this.AIboard[2][0] == AI){
            if(this.AIboard[0][2] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(0,2);
            }
            else if(this.AIboard[0][0] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(0,0);
            }
        }
        else if (this.AIboard[0][2] == AI && this.AIboard[2][0] == AI){
            if(this.AIboard[0][0] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(0,0);
            }
            else if(this.AIboard[2][2] == 0){
                System.out.println("AIFork");
                return new XYCoordinate(2,2);
            }
        }
        return oppositeFork(AI, player);
    }

    public Coordinate oppositeFork(int AI, int player) {
        if (this.AIboard[0][0] == player && this.AIboard[0][2] == player){
            if(this.AIboard[2][0] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(2,0);
            }
            else if(this.AIboard[2][2] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(2,2);
            }
        }
        else if (this.AIboard[0][0] == player && this.AIboard[2][0] == player){
            if(this.AIboard[0][2] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(0,2);
            }
            else if(this.AIboard[2][2] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(2,2);
            }
        }
        else if (this.AIboard[0][0] == player && this.AIboard[2][2] == player){
            if(this.AIboard[2][0] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(2,0);
            }
            else if(this.AIboard[0][2] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(0,2);
            }
        }
        else if (this.AIboard[2][2] == player && this.AIboard[0][2] == player){
            if(this.AIboard[2][0] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(2,0);
            }
            else if(this.AIboard[0][0] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(0,0);
            }
        }
        else if (this.AIboard[2][2] == player && this.AIboard[2][0] == player){
            if(this.AIboard[0][2] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(0,2);
            }
            else if(this.AIboard[0][0] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(0,0);
            }
        }
        else if (this.AIboard[0][2] == player && this.AIboard[2][0] == player){
            if(this.AIboard[0][0] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(0,0);
            }
            else if(this.AIboard[2][2] == 0){
                System.out.println("oppositeFork");
                return new XYCoordinate(2,2);
            }
        }
        return opposite();
    }

    public Coordinate opposite (){
        if (this.AIboard[0][0] != 0 || this.AIboard[0][2] != 0 || this.AIboard[2][0] != 0 || this.AIboard[2][2] != 0) {
            if (this.AIboard[1][1] == 0){
                System.out.println("opposite");
                return new XYCoordinate(1, 1);
            }
        }
        return generateMove();
    }

    public Coordinate generateMove(){
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (this.AIboard[x][y] == 0) {
                    System.out.println("generateMove");
                    return new XYCoordinate(x, y);
                }
            }
        }
        throw new IllegalArgumentException("");
    }

    public int checkWinning2() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Coordinate start = new XYCoordinate(x, y);
                if (checkSequence2(start,1, 1) > 0) {
                    return checkSequence2(start, 1, 1);
                }
                if (checkSequence2(start, -1, 1) > 0) {
                    return checkSequence2(start, -1, 1);
                }
                if (checkSequence2(start, 0, 1) > 0) {
                    return checkSequence2(start, 0, 1);
                }
                if (checkSequence2(start, 1, 0) > 0) {
                    return checkSequence2(start, 1, 0);
                }
            }
        }
        return 0;
    }

    private int checkSequence2(Coordinate start, int dx, int dy) {
        int x = start.getX();
        int y = start.getY();
        if (x+2*dx >= 0 && x+2*dx < 3 && y+2*dy >= 0 && y+2*dy < 3) {
            if (this.AIboard[x][y] == 0) {
                return 0;
            }
            if (this.AIboard[x][y] == this.AIboard[x + dx][y + dy] && this.AIboard[x][y] == this.AIboard[x + 2 * dx][y + 2 * dy]) {
                return this.AIboard[start.getX()][start.getY()];
            }
        }

        return 0;
    }
}
