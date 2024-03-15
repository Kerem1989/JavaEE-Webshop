package se.dmitrykhalizov.webbshoplabb.ui;

import org.springframework.stereotype.Service;

import java.util.Scanner;


@Service
public class IO {
    static Scanner input = new Scanner(System.in);

    public String getValidStringInput() {
        String userInput;
        boolean isUserInputInvalid;

        do {
            userInput = input.nextLine();
            if (!userInput.matches("[-a-zA-ZåäöÅÄÖ0-9@._ ]+")) {
                System.out.println("Incorrect format, you cannot use special characters!");
                isUserInputInvalid = true;
            } else if (userInput.isEmpty()) {
                System.out.println("entry cannot be blank..");
                isUserInputInvalid = true;
            } else {
                isUserInputInvalid = false;
            }

        } while (isUserInputInvalid);

        return userInput;
    }
}
