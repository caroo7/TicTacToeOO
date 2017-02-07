package arbiter;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.LinkedList;

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
        assertEquals(size, positions.length);
    }

    @Test
    void testContainsNumber() {
        // act
        boolean trueResult = sequence.containsNumber(0);
        boolean falseResult = sequence.containsNumber(3);

        //assert
        assertTrue(trueResult);
        assertFalse(falseResult);
    }

}