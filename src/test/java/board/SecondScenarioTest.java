package board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondScenarioTest {

    @Test
    void testPutOXSignsAtSeveralPlaces() {
        // arrange
        BoardBuilder builder = new BoardBuilder();
        Board board = builder.build();
        UpdateBoardAction updateBoard = new UpdateBoardAction(board);

        // act
        updateBoard.updateBoard(0, Sign.O);
        updateBoard.updateBoard(1, Sign.X);
        updateBoard.updateBoard(4, Sign.O);
        updateBoard.updateBoard(5, Sign.X);
        updateBoard.updateBoard(7, Sign.O);
        updateBoard.updateBoard(8, Sign.X);
        String result = board.toString();

        //assert
        Assert.assertEquals(result, createResultWithOAndX());
    }

    private String createResultWithOAndX() {
        return "[O, X, 3\n, 4, O, X\n, 7, O, X\n]";
    }

}
