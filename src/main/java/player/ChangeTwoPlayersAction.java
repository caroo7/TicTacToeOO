package player;

import config.Configuration;

public class ChangeTwoPlayersAction implements ChangePlayersAction {

    private Player playerOne;
    private Player playerTwo;
    private StepsCounter stepsCounter;

    public ChangeTwoPlayersAction(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        stepsCounter = new StepsCounter();
    }

    @Override
    public Player selectNext() {
        if(stepsCounter.getCounter() == Configuration.BOARD_SIZE * Configuration.BOARD_SIZE) {
            return null;
        }
        stepsCounter.incrementCounter();
        return stepsCounter.getCounter() % 2 == 0 ? playerOne : playerTwo;
    }
}