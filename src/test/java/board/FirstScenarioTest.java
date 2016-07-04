package board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstScenarioTest {

    @Test
    void testAssignSignOAtTheCenter() {
        // arrange
        BoardBuilder builder = new BoardBuilder();
        Board board = builder.build();
        UpdateBoardAction updateAction = new UpdateBoardAction(board);

        // act
        updateAction.updateBoard(4, Sign.O);
        String result = board.toString();

        //assert
        Assert.assertEquals(result, createResultWithOAtTheMiddle());
    }

    private String createResultWithOAtTheMiddle() {
        return "[1, 2, 3\n, 4, O, 6\n, 7, 8, 9\n]";
    }

}