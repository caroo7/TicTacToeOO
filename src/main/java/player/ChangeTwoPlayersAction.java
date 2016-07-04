package player;

import config.Configuration;

public class ChangeTwoPlayersAction implements ChangePlayersAction {

    private Player playerOne;
    private Player playerTwo;
    private StepsCounter stepsCounter;

    public ChangeTwoPlayersAction(Player playerOne, Player playerTwo, StepsCounter stepsCounter) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.stepsCounter = stepsCounter;
    }

    @Override
    public Player selectNext() {
        if(stepsCounter.getCounter() == Configuration.BOARD_SIZE * Configuration.BOARD_SIZE - 1) {
            return null;
        }
        stepsCounter.incrementCounter();
        return stepsCounter.getCounter() % 2 == 0 ? playerOne : playerTwo;
    }

}