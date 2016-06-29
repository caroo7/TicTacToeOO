package board;

import action.PutField;
import action.PutO;
import board.Board;
import board.BoardBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstScenarioTest {

    @Test
    void assignSignOAtTheCenter() {
        // arrange
        BoardBuilder builder = new BoardBuilder();
        Board board = builder.build();
        PutField putO = new PutO(board);

        // act
        putO.putFieldOnPosition(4);
        String result = board.toString();

        //assert
        Assert.assertEquals(result, createResultWithOAtTheMiddle());
    }

    private String createResultWithOAtTheMiddle() {
        return "[1 , 2 , 3 , 4 , O , 6 , 7 , 8 , 9 ]";
    }

}