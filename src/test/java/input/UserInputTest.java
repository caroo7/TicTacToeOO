package input;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserInputTest {

    @DataProvider
    Object[][] wrongInputDataProvider() {
        return new Object[][]{{"-1"}, {"10"}, {"test"}, {"test test 222"}, {".;[]+=\\?/!@#$%^&*()"}, {" "}};
    }

    @Test(dataProvider = "wrongInputDataProvider", expectedExceptions = InputValidationException.class)
    void testInvalidData3x3(String inputData)  throws InputValidationException {
        // arrange
        RetrievedData retrievedData = new RetrievedData(inputData);
        UserInputValidator validator = new UserInputValidator(retrievedData);

        // act
        validator.validate();
    }

    @Test
    void testValidData3x3() throws InputValidationException{
        //arrange
        RetrievedData retrievedData = new RetrievedData("5");
        UserInputValidator validator = new UserInputValidator(retrievedData);

        // act
        int retrievedPosition = validator.validate();

        // assert
        Assert.assertEquals(retrievedPosition, 5);
    }

}