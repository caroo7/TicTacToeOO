package arbiter;

import board.Sign;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArbiterTests {

    private Arbiter arbiter;

    @BeforeTest
    void init() {
        ArbiterBuilder builder = new ArbiterBuilder();
        arbiter = builder.build3x3();
    }

    //TODO: implement it
    @Test
    void testArbiterPreparing() {
    }

    @DataProvider
    Object[][] winningSequencesDataProvider() {
        return new Object[][]{{Sign.X, new int[]{0, 1, 2}, 0}, {Sign.X, new int[]{0, 3, 6}, 0}, {Sign.X, new int[]{0, 4, 8}, 0}, {Sign.X, new int[]{2, 4, 6}, 2}};
    }

    @Test(dataProvider = "winningSequencesDataProvider")
    void testWinningSequenceCheck(Sign sign, int[] positions, int lastMove) {
        //arrange
        TakenPositions takenPositions = prepareTakenPositions(sign, positions);
        arbiter.takenPositions = takenPositions;

        //act
        boolean result = arbiter.checkWinCondition(Sign.X, lastMove);

        //assert
        Assert.assertEquals(result, true);
    }

    //TODO: implement it
    @Test
    void testWrongSequenceCheck() {
    }

    private TakenPositions prepareTakenPositions(Sign sign, int[] positions) {
        TakenPositions takenPositions = new TakenPositions();
        for (int position : positions) {
            takenPositions.tryToPutOnPosition(position, sign);
        }
        return takenPositions;
    }

}