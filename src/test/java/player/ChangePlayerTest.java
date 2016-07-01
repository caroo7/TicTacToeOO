package player;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ChangePlayerTest {

    private ChangePlayersAction action;
    private Player playerOne = new PlayerX();
    private Player playerTwo = new PlayerO();

    @BeforeTest
    void init() {
        // arrange
        action = new ChangeTwoPlayersAction(playerOne, playerTwo);
    }

    @DataProvider
    Object[][] preparePlayersDataProvider() {
        return new Object[][]{{playerOne, playerTwo}, {playerTwo, playerOne}};
    }

    @Test(dataProvider = "preparePlayersDataProvider")
    void testChangePlayerAction(Player actualPlayer, Player playerToChange) {
        // act
        Player player = action.selectNext(actualPlayer);

        // assert
        Assert.assertEquals(player, playerToChange);
    }

}