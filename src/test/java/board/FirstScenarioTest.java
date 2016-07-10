package board;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class FirstScenarioTest {

    @Test
    void testsPlacingOInTheCenter() {
        // arrange
        BoardBuilder builder = new BoardBuilder();
        Board board = builder.build();
        UpdateBoardAction updateAction = new UpdateBoardAction(board);

        // act
        updateAction.updateBoard(4, Sign.O);
        String result = board.toString();

        //assert
        assertEquals(result, emptyBoardButForOInTheMiddle());
    }

    private String emptyBoardButForOInTheMiddle() {
        return "[1, 2, 3\n, 4, O, 6\n, 7, 8, 9\n]";
    }

}