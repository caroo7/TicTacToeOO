package arbiter;

import java.util.HashMap;
import java.util.Map;
import board.Sign;
import config.Configuration;

public class TakenPositionsWrapper {

    Map<Integer, Sign> takenPositions = new HashMap<>();

    public boolean tryToPutOnPosition(int position, Sign sign) throws IllegalArgumentException {
        if(position < 0 || position > Configuration.BOARD_SIZE * Configuration.BOARD_SIZE) {
            throw new IllegalArgumentException("Position is out of range!");
        }
        if(takenPositions.containsKey(position)) {
            return false;
        } else {
            takenPositions.put(position, sign);
            return true;
        }
    }

}