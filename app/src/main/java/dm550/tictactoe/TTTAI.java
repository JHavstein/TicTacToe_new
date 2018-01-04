package dm550.tictactoe;

public class TTTAI extends XYCoordinate implements Coordinate {

    private int[][] AIboard;

    public TTTAI(int[][] board){
        this.AIboard = board;
    }

    @Override
    public int getX() {
        Coordinate c = AIMove();
        return c.getX();}

    @Override
    public int getY() {
        Coordinate c = AIMove();
        return c.getY();
    }

    public Coordinate AIMove(){
        return win();
    }

    public Coordinate win(){
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (this.AIboard[x][y] == 0) {
                    this.AIboard[x][y] = 2;
                    if (checkWinning2() == 2){
                        this.AIboard[x][y] = 0;
                        System.out.println("win");
                        return new XYCoordinate(x,y);
                    }
                    else {this.AIboard[x][y] = 0;}
                }
            }
        }
        return block();
    }

    public Coordinate block(){
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (this.AIboard[x][y] == 0) {
                    this.AIboard[x][y] = 1;
                    if (checkWinning2() == 1){
                        this.AIboard[x][y] = 0;
                        System.out.println("block");
                        return new XYCoordinate(x,y);
                    }
                    else {this.AIboard[x][y] = 0;}
                }
            }
        }
        return fork();
    }

    public Coordinate fork() {
        if (this.AIboard[0][0] == 2 && this.AIboard[0][2] == 2){
            if(this.AIboard[2][0] == 0){
                System.out.println("fork");
                return new XYCoordinate(2,0);
            }
            else if(this.AIboard[2][2] == 0){
                System.out.println("fork");
                return new XYCoordinate(2,2);
            }
        }
        else if (this.AIboard[0][0] == 2 && this.AIboard[2][0] == 2){
            if(this.AIboard[0][2] == 0){
                System.out.println("fork");
                return new XYCoordinate(0,2);
            }
            else if(this.AIboard[2][2] == 0){
                System.out.println("fork");
                return new XYCoordinate(2,2);
            }
        }
        else if (this.AIboard[0][0] == 2 && this.AIboard[2][2] == 2){
            if(this.AIboard[2][0] == 0){
                System.out.println("fork");
                return new XYCoordinate(2,0);
            }
            else if(this.AIboard[0][2] == 0){
                System.out.println("fork");
                return new XYCoordinate(0,2);
            }
        }
        else if (this.AIboard[2][2] == 2 && this.AIboard[0][2] == 2){
            if(this.AIboard[2][0] == 0){
                System.out.println("fork");
                return new XYCoordinate(2,0);
            }
            else if(this.AIboard[0][0] == 0){
                System.out.println("fork");
                return new XYCoordinate(0,0);
            }
        }
        else if (this.AIboard[2][2] == 2 && this.AIboard[2][0] == 2){
            if(this.AIboard[0][2] == 0){
                System.out.println("fork");
                return new XYCoordinate(0,2);
            }
            else if(this.AIboard[0][0] == 0){
                System.out.println("fork");
                return new XYCoordinate(0,0);
            }
        }
        else if (this.AIboard[0][2] == 2 && this.AIboard[2][0] == 2){
            if(this.AIboard[0][0] == 0){
                System.out.println("fork");
                return new XYCoordinate(0,0);
            }
            else if(this.AIboard[2][2] == 0){
                System.out.println("fork");
                return new XYCoordinate(2,2);
            }
        }
        return blockFork();
    }

    public Coordinate blockFork() {
        if (this.AIboard[0][0] == 1 && this.AIboard[0][2] == 1){
            if (this.AIboard[1][0] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(1, 0);
            }
            else if (this.AIboard[0][1] == 0) {
                System.out.println("blockfork");
                return new XYCoordinate(0, 1);
            }
            else if (this.AIboard[2][1] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(2, 1);
            }
            else if (this.AIboard[1][2] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(1, 2);
            }
        }
        else if (this.AIboard[0][0] == 1 && this.AIboard[2][0] == 1){
            if (this.AIboard[1][0] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(1, 0);
            }
            else if (this.AIboard[0][1] == 0) {
                System.out.println("blockfork");
                return new XYCoordinate(0, 1);
            }
            else if (this.AIboard[2][1] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(2, 1);
            }
            else if (this.AIboard[1][2] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(1, 2);
            }
        }
        else if (this.AIboard[0][0] == 1 && this.AIboard[2][2] == 1){
            if (this.AIboard[1][0] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(1, 0);
            }
            else if (this.AIboard[0][1] == 0) {
                System.out.println("blockfork");
                return new XYCoordinate(0, 1);
            }
            else if (this.AIboard[2][1] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(2, 1);
            }
            else if (this.AIboard[1][2] == 0) {
                System.out.println("blockfork");
                return new XYCoordinate(1, 2);
            }
        }
        else if (this.AIboard[2][2] == 1 && this.AIboard[0][2] == 1){
            if (this.AIboard[1][0] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(1, 0);
            }
            else if (this.AIboard[0][1] == 0) {
                System.out.println("blockfork");
                return new XYCoordinate(0, 1);
            }
            else if (this.AIboard[2][1] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(2, 1);
            }
            else if (this.AIboard[1][2] == 0) {
                System.out.println("blockfork");
                return new XYCoordinate(1, 2);
            }
        }
        else if (this.AIboard[2][2] == 1 && this.AIboard[2][0] == 1){
            if (this.AIboard[1][0] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(1, 0);
            }
            else if (this.AIboard[0][1] == 0) {
                System.out.println("blockfork");
                return new XYCoordinate(0, 1);
            }
            else if (this.AIboard[2][1] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(2, 1);
            }
            else if (this.AIboard[1][2] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(1, 2);
            }
        }
        else if (this.AIboard[0][2] == 1 && this.AIboard[2][0] == 1){
            if (this.AIboard[1][0] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(1, 0);
            }
            else if (this.AIboard[0][1] == 0) {
                System.out.println("blockfork");
                return new XYCoordinate(0, 1);
            }
            else if (this.AIboard[2][1] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(2, 1);
            }
            else if (this.AIboard[1][2] == 0){
                System.out.println("blockfork");
                return new XYCoordinate(1, 2);
            }
        }
        return center();
    }

    public Coordinate center (){
        if (this.AIboard[1][1] == 0){
            System.out.println("center");
            return new XYCoordinate(1, 1);
        }
        return oppositeCorner();
    }

    public Coordinate oppositeCorner(){
        if (this.AIboard[0][0] == 1 && this.AIboard[2][2] == 0){
            System.out.println("oppositecorner");
            return new XYCoordinate(2, 2);
        }
        if (this.AIboard[2][2] == 1 && this.AIboard[0][0] == 0){
            System.out.println("oppositecorner");
            return new XYCoordinate(0, 0);
        }
        if (this.AIboard[2][0] == 1 && this.AIboard[0][2] == 0){
            System.out.println("oppositecorner");
            return new XYCoordinate(0, 2);
        }
        if (this.AIboard[0][2] == 1 && this.AIboard[2][0] == 0){
            System.out.println("oppositecorner");
            return new XYCoordinate(2, 0);
        }
        return corner();
    }

    public Coordinate corner(){
        if (this.AIboard[0][0] == 0){
            System.out.println("corner");
            return new XYCoordinate(0, 0);
        }
        else if (this.AIboard[0][2] == 0) {
            System.out.println("corner");
            return new XYCoordinate(0, 2);
        }
        else if (this.AIboard[2][0] == 0){
            System.out.println("corner");
            return new XYCoordinate(2, 0);
        }
        else if (this.AIboard[2][2] == 0){
            System.out.println("corner");
            return new XYCoordinate(2, 2);
        }
        return side();
    }

    public Coordinate side(){
        if (this.AIboard[1][0] == 0){
            System.out.println("side");
            return new XYCoordinate(1, 0);
        }
        else if (this.AIboard[0][1] == 0) {
            System.out.println("side");
            return new XYCoordinate(0, 1);
        }
        else if (this.AIboard[2][1] == 0){
            System.out.println("side");
            return new XYCoordinate(2, 1);
        }
        System.out.println("side");
        return new XYCoordinate(1, 2);
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
