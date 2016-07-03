package board;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BoardTest {

    // arrange
    private BoardBuilder builder;
    private Board board;
    private DisplayBoardAction displayAction;
    private UpdateBoardAction updateAction;

    @BeforeTest
    void init() {
        // arrange
        builder = new BoardBuilder();
        board = builder.build();
        displayAction = new DisplayBoardAction(board);
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

    @Test
    void testDisplayEmptyBoard() {
        // act
        String result = displayAction.displayBoard();

        // assert
        Assert.assertEquals(result, createExpectedEmptyView());
    }

    private String createExpectedEmptyView() {
        return "[1, 2, 3\n, 4, 5, 6\n, 7, 8, 9\n]";
    }

    @Test
    void testPrepareReadableBoardView() {
        // arrange
        BoardView view = new BoardView();

        // act
        String result = view.prepareReadableOutput(displayAction.displayBoard());

        // assert
        Assert.assertEquals(result, createExpectedEmptyReadableView());
    }

    private String createExpectedEmptyReadableView() {
        return "1 2 3\n4 5 6\n7 8 9\n";
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