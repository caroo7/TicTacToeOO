package board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstScenarioTest {

    @Test
    void testAssignSignOAtTheCenter() {
        // arrange
        BoardBuilder builder = new BoardBuilder();
        Board board = builder.build();
        PutField putO = new PutO(board);

        // act
        putO.putFieldOnPosition(4);
        String result = board.toString();

        System.out.println(board.toString());

        //assert
        Assert.assertEquals(result, createResultWithOAtTheMiddle());
    }

    private String createResultWithOAtTheMiddle() {
        return "[1 , 2 , 3 \n, 4 , O , 6 \n, 7 , 8 , 9 \n]";
    }

}