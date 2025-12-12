package org.holidayReq;

import java.util.Scanner;

public class UserInteractions {

    public Scanner scanner;

    // all user interactions, including interactions with the scanner.

    public UserInteractions(Scanner scanner) {
        this.scanner = scanner;
    }

    void closeScanner() {
        scanner.close();
    }

    public void userPrompt(String message) {
        System.out.println(message);
    }

    int getUserInputInt() {
        return scanner.nextInt();
    }

    public String getUserInputStr() {
        return scanner.next();
    }
}