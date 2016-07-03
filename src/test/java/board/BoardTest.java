package board;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BoardTest {

    private UpdateBoardAction updateAction;

    // arrange
    private BoardBuilder builder;
    private Board board;

    @BeforeTest
    void init() {
        // arrange
        builder = new BoardBuilder();
        board = builder.build();
        updateAction = new UpdateBoardAction(board);
    }

    @Test
    void testBoardDimensionSize() {
        // arrange
        BoardDimension dimension = new BoardDimension(3);

        // act
        int size = dimension.getSize();

        // assert
        Assert.assertEquals(size, 3);
    }

    @Test
    void testBoardPreparing() {
        // assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.dimension);
        Assert.assertNotNull(board.fields);
        Assert.assertEquals(board.fields.size(), board.dimension.getSize() * board.dimension.getSize()); //not sure about this assertion
    }


    @DataProvider
    Object[][] fieldDataProvider() {
        return new Object[][]{{0, Sign.O, true}, {1, Sign.X, true}, {0, Sign.X, false}, {1, Sign.O, false}};
    }

    @Test(dataProvider = "fieldDataProvider")
    void testUpdateBoard(int position, Sign sign, boolean expectedResult) {
        // act
        boolean result = updateAction.updateBoard(position, sign);

        // assert
        Assert.assertEquals(result, expectedResult);
    }

}