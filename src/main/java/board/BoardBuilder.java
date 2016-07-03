package board;

import config.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BoardBuilder {

    public Board build() {
        return new Board(new BoardDimension(Configuration.BOARD_SIZE), initializeFields());
    }

    List<Field> initializeFields() {
        int twoDimSize = Configuration.BOARD_SIZE * Configuration.BOARD_SIZE;
        List<Field> fields = new ArrayList<>();
        for(int i=0; i<twoDimSize; ++i) {
            fields.add(new Field(i, Sign.EMPTY));
        }
        return fields;
    }

}