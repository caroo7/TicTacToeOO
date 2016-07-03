package logic;

import arbiter.Arbiter;
import arbiter.TakenPositionsWrapper;
import board.Board;
import board.UpdateBoardAction;
import input.InputValidationException;
import input.RetrievedData;
import input.UserInput;
import input.UserInputValidator;
import player.ChangePlayersAction;
import player.Player;

public class Game3x3 implements Game {

    private Board board;
    private UpdateBoardAction updateBoard;

    private Player playerO;
    private Player playerX;
    private Player actualPlayer;

    private ChangePlayersAction changePlayer;

    private TakenPositionsWrapper takenPositionsWrapper;
    private Arbiter arbiter;

    @Override
    public void play() {

    }

    private void gameMainLoop() {
        while (true) {

            if (!playerInteraction(actualPlayer)) {
                continue;
            }

            // check win here (moze playera wsadzic do pakietu z arbitrem i wolac bezposrednio tam - unikniecie getterow!!!!)
            if(arbiter.checkWinCondition(actualPlayer.getSign(), actualPlayer.getPlayerLastMove())) {
                // display board
                break;
            }

            // change player here
            actualPlayer = changePlayer.selectNext();

            if(actualPlayer == null) {
                //draw
                break;
            }
        }
    }

    private boolean playerInteraction(Player player) {
        int position;
        try {
            position = getDataFromInput();
        } catch (InputValidationException e) {
            return false;
        }

        // if below condition is true use UpdateBoardAction to update board state
        return player.tryToPutPlayerAtPositon(position, takenPositionsWrapper);
    }

    private int getDataFromInput() throws InputValidationException {
        RetrievedData retrievedData = UserInput.retrieveInputData();
        UserInputValidator validator = new UserInputValidator(retrievedData);
        return validator.validate();
    }

}