import java.util.ArrayList;
import java.util.Random;

public class CPUPerfect extends Grid {

    static char self = ' ';
    static char opp = ' ';
    static int evaluation = 0;
    static int bestMove = 0;
    
    public static void play(char player) {
        self = player;
        opp = (self=='X') ? 'O' : 'X';
        // minimax(player, boardState());
        // placePosition(bestMove, player);
        
        if (available()==9) {
            //printGrid();
            Random rand = new Random();
            int pos = rand.nextInt(1, 10);
            placePosition(pos, player);
            //printGrid();
        } else {
            minimax(player, boardState());
            placePosition(bestMove, player);
        }
    }

    private static int minimax(char currentPlayer, char[][] state) {
        char player = (currentPlayer=='X') ? 'O' : 'X';
        int maxEval = -100;
        int minEval = 100;
        int potentialMove = 0;
        int score = 0;
        //printGrid();
        if (checkWin()==0) {
            if (self==currentPlayer) {
                for (int posi : posMoves(state)) {
                    placePosition(posi, currentPlayer);
                    evaluation = Math.max(maxEval, minimax(player, state));
                    if (evaluation>maxEval) {
                        maxEval = evaluation;
                        potentialMove = posi;
                    }
                    clearPos(posi);
                }
                bestMove = potentialMove;
                return maxEval;
            } else {
                for (int posj : posMoves(state)) {
                    placePosition(posj, currentPlayer);
                    evaluation = Math.min(minEval, minimax(player, state));
                    minEval = (evaluation<minEval) ? evaluation : minEval;
                    clearPos(posj);
                }
                return minEval; 
            }
        } else {
            score = evaluate(self, player, state);
            //System.out.println("Score: " + score);
            return score;
        }
    }

    private static ArrayList<Integer> posMoves(char[][] board) {//returns a list of all possible moves availiable on the board
        ArrayList<Integer> posMoves = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (checkPosition(i)==' ') {
                posMoves.add(i);
            }
        }
        return posMoves;
    }

    private static int evaluate(char maximizing, char winner, char[][] state) {
        if (checkWin() == 1) { //evaluates to 0 if game is a tie
            int staticScore = (maximizing==winner) ? (1 * posMoves(state).size()) + 1 : (-1 * posMoves(state).size()) - 1;
            return staticScore;
        } else {
            return 0;
        }
    }
}
