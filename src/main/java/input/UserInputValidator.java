package input;

import config.Configuration;

public class UserInputValidator {

    private RetrievedData retrievedData;

    public UserInputValidator(RetrievedData data) {
        this.retrievedData = data;
    }

    public int validate() throws InputValidationException {
        String retrievedString = retrievedData.data;
        if (retrievedString.contains(" ")) {
            throw new InputValidationException("There is a space in provided data.");
        }
        int number;
        try {
            number = Integer.parseInt(retrievedString);
        } catch (NumberFormatException e) {
            throw new InputValidationException("Provided data is not a number.");
        }
        int size = Configuration.BOARD_SIZE * Configuration.BOARD_SIZE;
        if (number < 1 || number > size) {
            throw new InputValidationException("The number is lower than 1 or greater than " + size + ".");
        }
        return number;
    }

}