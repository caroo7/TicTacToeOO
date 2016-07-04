package arbiter;

import board.Sign;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import player.StepsCounter;

public class ArbiterTest {

    private Arbiter arbiter;

    @BeforeTest()
    void init() {
        // arrange
        ArbiterBuilder builder = new ArbiterBuilder();
        arbiter = builder.build3x3(new TakenPositionsWrapper());
    }

    //*******************************************************************************************************************

    @Test
    void testArbiterPreparing() {
        // assert
        Assert.assertTrue(arbiter.playerOWinSequences.size() > 0);
        Assert.assertTrue(arbiter.playerXWinSequences.size() > 0);
    }

    //*******************************************************************************************************************

    @DataProvider
    Object[][] winningSequencesDataProvider() {
        return new Object[][]{{Sign.X, new int[]{0, 1, 2}, 0}, {Sign.X, new int[]{0, 3, 6}, 0}, {Sign.X, new int[]{0, 4, 8}, 0}, {Sign.X, new int[]{2, 4, 6}, 2}};
    }

    @Test(dataProvider = "winningSequencesDataProvider")
    void testWinningSequenceCheck(Sign sign, int[] positions, int lastMove) {
        // arrange
        SequencesInitializer3x3 initializer = new SequencesInitializer3x3();
        arbiter.playerOWinSequences = initializer.createAllWinSequences();
        arbiter.playerXWinSequences = initializer.createAllWinSequences();
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

    private void prepareTakenPositions(Sign sign, int[] positions) {
        for (int position : positions) {
            arbiter.takenPositionsWrapper.tryToPutOnPosition(position, sign);
        }
    }
    //*******************************************************************************************************************

    @DataProvider
    Object[][] conflictingPositionsDataProvider() {
        return new Object[][]{{Sign.O, 0, 2, 5}, {Sign.O, 4, 5, 4}, {Sign.X, 0, 2, 5}, {Sign.X, 4, 5, 4}};
    }

    @Test(dataProvider = "conflictingPositionsDataProvider")
    void testRemoveImpossibleSequences(Sign sign, int positionForO, int positionForX, int sizeAfterRemove) {
        // arrange
        prepareTakenPositions(Sign.O, new int[]{positionForO});
        prepareTakenPositions(Sign.X, new int[]{positionForX});

        // act
        arbiter.checkWinCondition(sign, positionForX);

        // assert
        if(sign.equals(Sign.X)) {
            Assert.assertEquals(arbiter.playerOWinSequences.size(), sizeAfterRemove);
        } else {
            Assert.assertEquals(arbiter.playerXWinSequences.size(), sizeAfterRemove);
        }
    }

}