package board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardTest {

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
        // arrange
        BoardBuilder builder = new BoardBuilder();
        Board board = builder.build();

        // assert
        Assert.assertNotNull(board);
        Assert.assertNotNull(board.dimension);
        Assert.assertNotNull(board.fields);
        Assert.assertEquals(board.fields.size(), board.dimension.getSize() * board.dimension.getSize()); //not sure about this assertion
    }


}