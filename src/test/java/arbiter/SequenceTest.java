package arbiter;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SequenceTest {

    private int[] positions;

    private Sequence sequence;

    @BeforeTest
    void init() {
        // arrange
        positions = new int[] {0, 1, 2};
        sequence = new Sequence(positions);
    }

    @Test
    void testSequenceLength() {
        // act
        int size = sequence.numberSequence.size();

        // assert
        Assert.assertEquals(size, positions.length);
    }

    @Test
    void testContainsNumber() {
        // act
        boolean trueResult = sequence.containsNumber(0);
        boolean falseResult = sequence.containsNumber(3);

        //assert
        Assert.assertTrue(trueResult);
        Assert.assertFalse(falseResult);
    }

}