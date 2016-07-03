package player;

import arbiter.TakenPositionsWrapper;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayerTest {

    private TakenPositionsWrapper takenPositionsWrapper;
    private Player playerOne;
    private Player playerTwo;

    @BeforeTest
    void init() {
        // arrange
        takenPositionsWrapper = new TakenPositionsWrapper();
        playerOne = new PlayerX();
        playerTwo = new PlayerO();
    }

    @Test
    void testEmptyPlayer() {
        // assert
        Assert.assertEquals(playerOne.playerLastMove, -1);
    }

    @DataProvider
    Object[][] playersPutFieldDataProvider() {
        return new Object[][]{{playerOne, 1, 1, true}, {playerTwo, 2, 2, true}, {playerOne, 2, 1, false}, {playerTwo, 1, 2, false}};
    }

    @Test(dataProvider = "playersPutFieldDataProvider")
    void testPutPlayerOnPosition(Player actualPlayer, int position, int playerLastMove, boolean expectedResult) {
        // act
        boolean result = actualPlayer.tryToPutPlayerAtPositon(position, takenPositionsWrapper);

        // assert
        Assert.assertEquals(result, expectedResult);
        Assert.assertEquals(actualPlayer.playerLastMove, playerLastMove);
    }

}