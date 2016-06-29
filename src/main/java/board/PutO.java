package board;

public class PutO extends PutField {

    public PutO(Board board) {
        super(board);
    }

    @Override
    public boolean putFieldOnPosition(int position) {
        return board.addToFields(new Field(position, Sign.O));
    }
}
