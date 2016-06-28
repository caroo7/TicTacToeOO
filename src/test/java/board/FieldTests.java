package board;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FieldTests {

    //probably remove this test (use list now instead set, so this is unnecessary)
    /*@Test
    void fieldEqualityTest() {
        // arrange
        Field firstField = new Field(1, Sign.EMPTY);
        Field secondField = new Field(2, Sign.EMPTY);
        Field thirdField = new Field(2, Sign.EMPTY);

        // act
        boolean shouldBeFalse = firstField.equals(secondField);
        boolean shouldBeTrue = secondField.equals(thirdField);

        // assert
        Assert.assertFalse(shouldBeFalse);
        Assert.assertTrue(shouldBeTrue);
    }*/

}