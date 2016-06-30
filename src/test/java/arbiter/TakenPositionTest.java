package arbiter;

import board.Sign;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TakenPositionTest {

    @Test
    void testPutOnPosition() {
        //arrange
        TakenPositionsWrapper positions = new TakenPositionsWrapper();

        //act
        boolean trueResult = positions.tryToPutOnPosition(0, Sign.O);
        boolean falseResult = positions.tryToPutOnPosition(0, Sign.X);

        //assert
        Assert.assertTrue(trueResult);
        Assert.assertFalse(falseResult);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testPutOutOfRange() {
        //arrange
        TakenPositionsWrapper positions = new TakenPositionsWrapper();

        //act
        positions.tryToPutOnPosition(20, Sign.O);
    }

}