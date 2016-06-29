package board;

public class PutX extends PutField {

    public PutX(Board board) {
        super(board);
    }

    @Override
    public boolean putFieldOnPosition(int position) {
        return board.addToFields(new Field(position, Sign.X));
    }
}
