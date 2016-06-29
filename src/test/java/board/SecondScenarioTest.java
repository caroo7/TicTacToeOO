package board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondScenarioTest {

    @Test
    void testPutOXSignsAtSeveralPlaces() {
        // arrange
        BoardBuilder builder = new BoardBuilder();
        Board board = builder.build();
        PutField putO = new PutO(board);
        PutField putX = new PutX(board);

        // act
        putO.putFieldOnPosition(0);
        putX.putFieldOnPosition(1);
        putO.putFieldOnPosition(4);
        putX.putFieldOnPosition(5);
        putO.putFieldOnPosition(7);
        putX.putFieldOnPosition(8);
        String result = board.toString();

        //assert
        Assert.assertEquals(result, createResultWithOAndX());
    }

    private String createResultWithOAndX() {
        return "[O, X, 3\n, 4, O, X\n, 7, O, X\n]";
    }

}
