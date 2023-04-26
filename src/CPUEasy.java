
import java.util.ArrayList;
import java.util.Random;

public class CPUEasy {

    public static void play(char player) {
        ArrayList<Integer> positions = new ArrayList<Integer>();
        positions.add(1);positions.add(2);positions.add(3);positions.add(4);positions.add(5);positions.add(6);positions.add(7);positions.add(8);positions.add(9);
    
        Random rand = new Random();
        int pos;

        boolean foundPos = false;

        while (foundPos == false) {
            int n = rand.nextInt(positions.size());
            pos = positions.get(n);
            if (Grid.placePosition(pos++, player) == 0) {
                positions.remove(n);
                continue;
            } else {
                foundPos = true;
            }
        }
    }
}
