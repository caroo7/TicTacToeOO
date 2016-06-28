package action;

import board.Board;

public abstract class PutField {

    protected Board board;

    public PutField(Board board) {
        this.board = board;
    }

    public abstract boolean putFieldOnPosition(int position);

}