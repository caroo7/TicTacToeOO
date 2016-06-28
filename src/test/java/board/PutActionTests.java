package board;

import action.PutField;
import action.PutO;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PutActionTests {

    private Board board;

    @BeforeTest
    void init() {
        BoardBuilder builder = new BoardBuilder();
        board = builder.build();
    }

    @DataProvider
    Object[][] fieldsDataProvider() {
        return new Object[][]{{5, true}, {5, false}};
    }

    @Test(dataProvider = "fieldsDataProvider")
    void addFieldsOnPositionTest(int position, boolean expectedResult) {
        // arrange
        PutField putO = new PutO(board);

        // act
        boolean result = putO.putFieldOnPosition(position);

        // assert
        Assert.assertEquals(result, expectedResult);
    }

}