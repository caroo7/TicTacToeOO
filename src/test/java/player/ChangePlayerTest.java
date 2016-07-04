package player;

import org.testng.Assert;
import org.testng.annotations.*;

public class ChangePlayerTest {

    private ChangePlayersAction action;
    private Player playerOne = new PlayerX();
    private Player playerTwo = new PlayerO();

    @BeforeGroups("testChangePlayerActionGroup")
    void init() {
        // arrange
        action = new ChangeTwoPlayersAction(playerOne, playerTwo, new StepsCounter());
    }

    @DataProvider
    Object[][] preparePlayersDataProvider() {
        return new Object[][]{{playerTwo}, {playerOne}};
    }

    @Test(groups = "testChangePlayerActionGroup", dataProvider = "preparePlayersDataProvider")
    void testChangePlayerAction(Player playerToChange) {
        // act
        Player player = action.selectNext();

        // assert
        Assert.assertEquals(player.sign, playerToChange.sign);
    }

    @Test
    void testMaximumSteps() {
        // arrange
        action = new ChangeTwoPlayersAction(playerOne, playerTwo, new StepsCounter());
        Player player = action.selectNext();
        for(int i=1; i<9; ++i) {
            player = action.selectNext();
        }

        // assert
        Assert.assertNull(player);
    }

}