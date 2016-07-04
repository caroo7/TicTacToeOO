package logic;

import arbiter.ArbiterBuilder;
import arbiter.TakenPositionsWrapper;
import board.*;
import player.*;

public class Game3x3For2PlayersBuilder {

    Game build() {

        Game3x3 game = new Game3x3();
        //******************************************************
        BoardBuilder builder = new BoardBuilder();
        game.board = builder.build();
        game.updateAction = new UpdateBoardAction(game.board);
        game.view = new BoardView();
        //*******************************************************

        //*******************************************************
        game.playerO = new PlayerO();
        game.playerX = new PlayerX();
        game.actualPlayer = game.playerO;
        StepsCounter stepsCounter = new StepsCounter();
        game.changePlayer = new ChangeTwoPlayersAction(game.playerO, game.playerX, stepsCounter);
        //********************************************************

        //********************************************************
        game.takenPositions = new TakenPositionsWrapper();
        game.arbiter = new ArbiterBuilder().build3x3(game.takenPositions);
        //********************************************************

        game.displayHelper = new GameDisplayHelper();
        return game;
    }

}