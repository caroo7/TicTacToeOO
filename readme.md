# About

TicTacToe object oriented version. Game will allow to playing standard TicTacToe game for two players on board with dimension of 3x3 size.
Result is displayed in standard output (console). Interaction with user is made through providing specific number which indicate place on the board.
Winning sequence is always equals board side length (which now is 3).

## Contribution

Only via pull requests. Fork the repository, add your commits on a well-named branch and request the pull.

## Scenarios

1. Place O in the middle of the board
2. Place X and O, so O, X and O have been played in total
3. Winning conditions checking (vertical, horizontal and diagonal). Based on sequences in case of limiting steps in checking procedure.
4. Two players who can take positions on the board. Player manager which is responsible for switching between player during the game.
5. Retrieve position from standard input and validate it properly.
6. Use components created previously to build game logic.

## Rules

3x3 board
2 human players
O and X
Filling a row, a column or a diagonal with your character means you won, game ends immediately (other player does NOT get a move).
