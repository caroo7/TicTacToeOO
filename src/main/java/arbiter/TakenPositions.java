package arbiter;

import java.util.HashMap;
import java.util.Map;
import board.Sign;

public class TakenPositions {

    Map<Integer, Sign> takenPositions = new HashMap<>();

    //think about this implementation (KISS)
    boolean tryToPutOnPosition(int position, Sign sign) {
        if(takenPositions.containsKey(position)) {
            return false;
        } else {
            takenPositions.put(position, sign);
            return true;
        }
    }

}
