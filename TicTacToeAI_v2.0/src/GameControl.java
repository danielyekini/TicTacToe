public class GameControl {

    static int xWins = 0;
    static int oWins = 0;
    static int ties = 0;
    
    public static void start() {
        for (int i = 0; i < 5; i++) {
            int winner = 0;
            while (winner == 0) {
                Grid.printGrid();
                int userPos = Input.integer("Select Position (1-9): ");
                Grid.placePosition(userPos, 'X');
                // CPUPerfect.play('X');
                // Grid.printGrid();
                winner = Grid.checkWin();
                if (winner==1) {
                    xWins++;
                    Grid.newGrid();
                    break;
                } else if (winner==-1) {
                    ties++;
                    Grid.newGrid();
                    break;
                }
                //int userPos = Input.integer("Select Position (1-9): ");
                //Grid.placePosition(userPos, 'O');
                CPUPerfect.play('O');
                Grid.printGrid();
                winner = Grid.checkWin();
                if (winner==1) {
                    oWins++;
                    Grid.newGrid();
                    break;
                } else if (winner==-1) {
                    ties++;
                    Grid.newGrid();
                    break;
                }
            }
        }
        System.out.println("\nX Wins: " + xWins);
        System.out.println("O Wins: " + oWins);
        System.out.println("Ties: " + ties);
    } 
}
