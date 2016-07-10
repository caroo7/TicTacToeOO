package arbiter;

import static org.testng.Assert.*;

import board.Sign;
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
        assertTrue(trueResult);
        assertFalse(falseResult);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testPutOutOfRange() {
        //arrange
        TakenPositionsWrapper positions = new TakenPositionsWrapper();

        //act
        positions.tryToPutOnPosition(20, Sign.O);
    }

}