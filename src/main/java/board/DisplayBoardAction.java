package board;

public class DisplayBoardAction {

    private Board board;

    public DisplayBoardAction(Board board) {
        this.board = board;
    }

    public String displayBoard() {
        return board.toString();
    }

}