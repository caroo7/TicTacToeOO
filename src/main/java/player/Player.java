package player;

import arbiter.TakenPositionsWrapper;
import board.Sign;

public abstract class Player {

    int playerLastMove = -1;

    int playerMovesNumber = 0;

    Sign sign;

    boolean tryToPutPlayerAtPositon(int position, TakenPositionsWrapper takenPositionsWrapper) {
        boolean result = takenPositionsWrapper.tryToPutOnPosition(position, sign);
        if(result) {
            playerLastMove = position;
            playerMovesNumber++;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Player player = (Player) o;
        return sign == player.sign;
    }
}