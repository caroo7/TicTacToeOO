package logic;

import arbiter.Arbiter;
import arbiter.TakenPositionsWrapper;
import board.*;
import input.InputValidationException;
import input.RetrievedData;
import input.UserInput;
import input.UserInputValidator;
import player.ChangePlayersAction;
import player.Player;

public class Game3x3 implements Game {

    Board board;
    UpdateBoardAction updateAction;
    BoardView view;

    Player playerO;
    Player playerX;
    Player actualPlayer;
    ChangePlayersAction changePlayer;

    TakenPositionsWrapper takenPositions;
    Arbiter arbiter;

    GameDisplayHelper displayHelper;

    @Override
    public void play() {
        gameMainLoop();
    }

    private void gameMainLoop() {
        while (true) {
            displayHelper.display(view.prepareReadableOutput(board.toString()));

            // player interactions
            boolean interactionResult;
            try {
                interactionResult = playerInteraction(actualPlayer);
            } catch (InputValidationException e) {
                displayHelper.display(e.getMessage());
                continue;
            }
            if (!interactionResult) {
                displayHelper.display("Cannot occupy field, it's already taken. Try again.");
                continue;
            }

            // check win
            if(arbiter.checkWinCondition(actualPlayer.getSign(), actualPlayer.getPlayerLastMove())) {
                displayHelper.display(view.prepareReadableOutput(board.toString()));
                displayHelper.display("Player " + actualPlayer.getSign() + " won. End of the game.");
                break;
            }

            // change player
            actualPlayer = changePlayer.selectNext();

            // check draw
            if(actualPlayer == null) {
                displayHelper.display(view.prepareReadableOutput(board.toString()));
                displayHelper.display("We have a draw. End of the game.");
                break;
            }
        }
    }

    //******************************************************************************************
    private boolean playerInteraction(Player player) throws InputValidationException {
        int position = getDataFromInput();
        boolean putResult = player.tryToPutPlayerAtPositon(position-1, takenPositions);
        if(putResult) {
            putResult = updateBoardFields(position-1, player);
        }
        return putResult;
    }

    private boolean updateBoardFields(int position, Player player) {
        return updateAction.updateBoard(position, player.getSign());
    }
    //******************************************************************************************

    private int getDataFromInput() throws InputValidationException {
        RetrievedData retrievedData = UserInput.retrieveInputData();
        UserInputValidator validator = new UserInputValidator(retrievedData);
        return validator.validate();
    }

}