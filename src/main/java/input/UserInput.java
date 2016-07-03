package input;

import java.util.Scanner;

public class UserInput {

    public static RetrievedData retrieveInputData() {
        Scanner scanner = new Scanner(System.in);
        return new RetrievedData(scanner.next());
    }

}