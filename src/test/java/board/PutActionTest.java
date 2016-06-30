package board;

import config.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PutActionTest {

    private Board board;

    @BeforeTest
    void init() {
        BoardBuilder builder = new BoardBuilder();
        board = builder.build();
    }

    @DataProvider
    Object[][] addFieldODataProvider() {
        return new Object[][]{{5, true}, {5, false}};
    }

    @Test(dataProvider = "addFieldODataProvider")
    void testAddFieldsAndValidate(int position, boolean expectedResult) {
        // arrange
        PutField putO = new PutO(board);

        // act
        boolean result = putO.putFieldOnPosition(position);

        // assert
        Assert.assertEquals(result, expectedResult);
    }

    @DataProvider
    Object[][] addFieldOXDataProvider(){
        //arrange
        return new Object[][]{{0, Sign.O, new PutO(board)}, {1, Sign.X, new PutX(board)}};
    }

    @Test(dataProvider = "addFieldOXDataProvider")
    void testAddOXFieldsOnPosition(int position, Sign sign, PutField putAction) {
        //act
        boolean result = putAction.putFieldOnPosition(position);

        //assert
        Assert.assertEquals(result, true);
        Assert.assertNotNull(board.fields.get(position));
        Assert.assertEquals(board.fields.get(position).toString(), sign.toString());
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    void testAddFieldOutOfBoardRange() {
        // arrange
        PutField putO = new PutO(board);

        // act
        putO.putFieldOnPosition(Configuration.BOARD_SIZE * Configuration.BOARD_SIZE + 1);
    }

}