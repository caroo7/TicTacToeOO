package player;

import arbiter.TakenPositionsWrapper;
import board.Sign;

public abstract class Player {

    int playerLastMove = -1;

    Sign sign;

    public boolean tryToPutPlayerAtPositon(int position, TakenPositionsWrapper takenPositionsWrapper) {
        boolean result = takenPositionsWrapper.tryToPutOnPosition(position, sign);
        if(result) {
            playerLastMove = position;
        }
        return result;
    }

    public Sign getSign() {
        return sign;
    }

    public int getPlayerLastMove() {
        return playerLastMove;
    }
}