package arbiter;

import board.Sign;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ArbiterTest {

    private Arbiter arbiter;

    @BeforeTest
    void init() {
        // arrange
        ArbiterBuilder builder = new ArbiterBuilder();
        arbiter = builder.build3x3();
    }

    //*******************************************************************************************************************

    @Test
    void testArbiterPreparing() {
        // assert
        Assert.assertEquals(arbiter.winningSign, Sign.X);
        Assert.assertTrue(arbiter.availableWinSequences.size() > 0);
    }

    //*******************************************************************************************************************

    @DataProvider
    Object[][] winningSequencesDataProvider() {
        return new Object[][]{{Sign.X, new int[]{0, 1, 2}, 0}, {Sign.X, new int[]{0, 3, 6}, 0}, {Sign.X, new int[]{0, 4, 8}, 0}, {Sign.X, new int[]{2, 4, 6}, 2}};
    }

    @Test(dataProvider = "winningSequencesDataProvider")
    void testWinningSequenceCheck(Sign sign, int[] positions, int lastMove) {
        // arrange
        arbiter.takenPositionsWrapper.takenPositions.clear();
        prepareTakenPositions(sign, positions);

        // act
        boolean result = arbiter.checkWinCondition(Sign.X, lastMove);

        // assert
        Assert.assertEquals(result, true);
    }

    //*******************************************************************************************************************
    @DataProvider
    Object[][] badSequencesDataProvider() {
        return new Object[][]{{Sign.X, new int[]{1, 2, 3}, 1}, {Sign.X, new int[]{0, 4, 7}, 0}, {Sign.X, new int[]{4, 5, 6}, 4}, {Sign.X, new int[]{0, 4, 5}, 0}};
    }

    @Test(dataProvider = "badSequencesDataProvider")
    void testWrongSequenceCheck(Sign sign, int[] positions, int lastMove) {
        // arrange
        arbiter.takenPositionsWrapper.takenPositions.clear();
        prepareTakenPositions(sign, positions);

        // act
        boolean result = arbiter.checkWinCondition(Sign.X, lastMove);

        // assert
        Assert.assertEquals(result, false);
    }
    //*******************************************************************************************************************

    @Test
    void testWrongSignWithCorrectSequence() {
        // arrange
        arbiter.takenPositionsWrapper.takenPositions.clear();
        prepareTakenPositions(Sign.O, new int[]{0, 1, 2});

        // act
        boolean result = arbiter.checkWinCondition(Sign.X, 0);

        // assert
        Assert.assertEquals(result, false);
    }

    //*******************************************************************************************************************

    private void prepareTakenPositions(Sign sign, int[] positions) {
        for (int position : positions) {
            arbiter.takenPositionsWrapper.tryToPutOnPosition(position, sign);
        }
    }

}