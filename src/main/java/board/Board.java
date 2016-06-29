package board;

import java.util.List;
import java.util.Set;

public class Board {

    BoardDimension dimension;

    List<Field> fields;

    public Board(BoardDimension dimension, List<Field> fields) {
            this.dimension = dimension;
            this.fields = fields;
    }

    public boolean addToFields(Field field) {
        if(fields.get(field.position).sign == Sign.EMPTY) {
            fields.remove(field.position);
            fields.add(field.position, field);
            return true;
        }
        return false;
    }

    @Override
    public String toString() { // change to proper implementation
        return fields.toString();
    }

}