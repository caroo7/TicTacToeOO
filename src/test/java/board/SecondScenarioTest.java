package board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondScenarioTest {

    @Test
    void testPutOXSignsAtSeveralPlaces() {
        // arrange
        BoardBuilder builder = new BoardBuilder();
        Board board = builder.build();
        UpdateBoardAction updateAction = new UpdateBoardAction(board);

        // act
        updateAction.updateBoard(0, Sign.O);
        updateAction.updateBoard(1, Sign.X);
        updateAction.updateBoard(4, Sign.O);
        updateAction.updateBoard(5, Sign.X);
        updateAction.updateBoard(7, Sign.O);
        updateAction.updateBoard(8, Sign.X);
        String result = board.toString();

        //assert
        Assert.assertEquals(result, createResultWithOAndX());
    }

    private String createResultWithOAndX() {
        return "[O, X, 3\n, 4, O, X\n, 7, O, X\n]";
    }

}
