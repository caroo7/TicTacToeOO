package player;

public class ChangeTwoPlayersAction implements ChangePlayersAction {

    private Player playerOne;
    private Player playerTwo;

    public ChangeTwoPlayersAction(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    @Override
    public Player selectNext(Player actualPlayer) {
        return actualPlayer.equals(playerOne) ? playerTwo : playerOne;
    }
}