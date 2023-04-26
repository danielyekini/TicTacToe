public class Grid {
    private static char[][] gameGrid = new char[][]
    {{' ', '|', ' ', '|', ' '},
    {'-', '+', '-', '+', '-'},
    {' ', '|', ' ', '|', ' '},
    {'-', '+', '-', '+', '-'},
    {' ', '|', ' ', '|', ' '}};

    public static void printGrid() {
        System.out.println("\n");
        for (char[] cs : gameGrid) {
            System.out.println(cs);
        }
    }

    protected static char checkPosition(int position) {
        int n = (position <= 3) ? 0
        : (position <= 6) ? 2 : 4;

        int m = (position==1 || position==4 || position==7) ? 0
        : (position==2 || position==5 || position==8) ? 2 : 4;

        return gameGrid[n][m];
    }

    public static int placePosition(int position, char player) {
        if (checkPosition(position) == ' ') {
            int n = (position <= 3) ? 0
            : (position <= 6) ? 2 : 4;

            int m = (position==1 || position==4 || position==7) ? 0
            : (position==2 || position==5 || position==8) ? 2 : 4;

            gameGrid[n][m] = player;
            return 1;
        } else {
            return 0;
        }
    }

    public static int checkWin() { //returns 1 if winning move found, returns -1 for a tie and 0 for no outcome
        int winner = 
        //ROW1
        (checkPosition(1)!=' ' && checkPosition(1)==checkPosition(2) && checkPosition(2)==checkPosition(3)) ? 1
        //ROW2
        : (checkPosition(4)!=' ' && checkPosition(4)==checkPosition(5) && checkPosition(5)==checkPosition(6)) ? 1
        //ROW3
        : (checkPosition(7)!=' ' && checkPosition(7)==checkPosition(8) && checkPosition(8)==checkPosition(9)) ? 1
        //COLUMN1
        : (checkPosition(1)!=' ' && checkPosition(1)==checkPosition(4) && checkPosition(4)==checkPosition(7)) ? 1
        //COLUMN2
        : (checkPosition(2)!=' ' && checkPosition(2)==checkPosition(5) && checkPosition(5)==checkPosition(8)) ? 1
        //COLUMN3
        : (checkPosition(3)!=' ' && checkPosition(3)==checkPosition(6) && checkPosition(6)==checkPosition(9)) ? 1
        //DIAGONAL1
        : (checkPosition(1)!=' ' && checkPosition(1)==checkPosition(5) && checkPosition(5)==checkPosition(9)) ? 1
        //DIAGONAL2
        : checkPosition(3)!=' ' && (checkPosition(3)==checkPosition(5) && checkPosition(5)==checkPosition(7)) ? 1
        //TIE
        : (checkPosition(1)!=' ' && checkPosition(2)!=' ' && checkPosition(3)!=' ' && checkPosition(4)!=' ' && checkPosition(5)!=' ' 
        && checkPosition(6)!=' ' && checkPosition(7)!=' ' && checkPosition(8)!=' ' && checkPosition(9)!=' ') ? -1 : 0;

        return winner;
    }

    protected static int available() {
        int numSpaces = 0;
        for (char[] cs : gameGrid) {
            for (char c : cs) {
                if (c==' ') {
                    numSpaces++;
                }
            }
        }
        return numSpaces;
    }

    protected static char[][] boardState() {
        char[][] grid = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = gameGrid[i][j];
            }
        }
        return grid;
    }

    protected static void clearPos(int position) {
        int n = (position <= 3) ? 0
        : (position <= 6) ? 2 : 4;

        int m = (position==1 || position==4 || position==7) ? 0
        : (position==2 || position==5 || position==8) ? 2 : 4;

        gameGrid[n][m] = ' ';
    }

    protected static void newGrid() {
        gameGrid = new char[][]
        {{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};
    }

}
