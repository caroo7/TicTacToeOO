package board;

public class UpdateBoardAction {

    Board board;

    public UpdateBoardAction(Board board) {
        this.board = board;
    }

    public boolean updateBoard(int position, Sign sign) {
       return board.addToFields(new Field(position, sign));
    }

}