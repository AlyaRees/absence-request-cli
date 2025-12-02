package org.holidayReq;

import java.util.ArrayList;

public class App {

    UserInteractions userInteractions = new UserInteractions();
    ReadFromFile reader = new ReadFromFile();
    WriteToFile writer = new WriteToFile();
    DateHandling dateHandling = new DateHandling();
    UpdateFile holidayInteraction = new UpdateFile();

    String validateInput(int index, ArrayList<String> fileContent) {
        String selectedRequest = "";
        do {
            display("\nSelect holiday to review:\n");
            try {
                index = userInteractions.returnUserInputInt();
                selectedRequest = getHolidayRequest(index);
            } catch (IndexOutOfBoundsException e) {
                statusReport("Enter numbers within the scope of the selection only.");

            }
        } while (index > fileContent.size() || index == 0);

        return selectedRequest;
    }

    static String getHolidayRequest(int index) {
        index = index - 1;
        ReadFromFile reader = new ReadFromFile();
        String selectedDate = reader.getFileContent().get(index);
        return selectedDate;
    }

    ArrayList<String> addNumberIDs(ArrayList<String> list) {
        int placement = 1;
        int index = 0;
        while (index < list.size()) {
            list.set(index, placement + " - " + list.get(index));
            index++;
            placement++;
        }
        return list;
    }

    static void statusReport(String message) {
        System.out.println(message);
    }

    static void display(String message) {
        System.out.println(message);
    }

    static void displayElements(ArrayList<String> list) {
        list.forEach(item -> display(item));
    }

    private void optionOneInteraction() {

        UserInteractions.userPrompt("\nEnter your full name:\n");
        String userFullName = userInteractions.returnUserInputStr();

        UserInteractions.userPrompt("\nEnter your employee number:\n");
        String employeeNum = userInteractions.returnUserInputStr();

        UserInteractions.userPrompt("\nEnter holiday you want to book:\n(Use the format DD/MM/YYYY)\n\nDate from:\n");
        String startDate = userInteractions.returnUserInputStr();

        startDate = dateHandling.checkAndUpdateDate("\n\nDate from:\n", startDate);

        UserInteractions.userPrompt("\nDate to:\n");
        String endDate = userInteractions.returnUserInputStr();

        endDate = dateHandling.checkAndUpdateDate("\nDate to:\n", endDate);

        UserInteractions.userPrompt("\nYou want to book from: " + startDate + " to " + endDate + "\nCorrect? (Y/N)\n");
        String areDatesCorrect = userInteractions.returnUserInputStr();

        while (areDatesCorrect.equalsIgnoreCase("N")) {
            UserInteractions.userPrompt("\nEnter holiday you want to book:\n(Use the format DD/M/YYYY)\n\nDate from:\n");
            startDate = userInteractions.returnUserInputStr();

            UserInteractions.userPrompt("\nDate to:\n");
            endDate = userInteractions.returnUserInputStr();
            UserInteractions.userPrompt("\nYou want to book from: " + startDate + " to " + endDate + "\nCorrect? (Y/N)\n");

            areDatesCorrect = userInteractions.returnUserInputStr();
        }

        if (areDatesCorrect.equalsIgnoreCase("Y")) {
            HolidayRequest request = new HolidayRequest(userFullName, employeeNum, startDate, endDate);
            writer.save(request);
            holidayInteraction.reformatFile();
            statusReport("Details saved.");

        } else {
            statusReport("Invalid input.");
        }
    }

    private void optionThreeInteraction() {

        UserInteractions.userPrompt("\nEnter admin password: \n");
        String enteredPassword = userInteractions.returnUserInputStr();

        String password = "password";

        while (!enteredPassword.equals(password)) {
            statusReport("\nIncorrect password entered.\n");
            enteredPassword = userInteractions.returnUserInputStr();
        }
        statusReport("\nLogin successful.\n");

        ArrayList<String> fileContent = reader.getFileContent();
        // Gets the file content, puts it into an array list and adds number IDs
        displayElements(addNumberIDs(fileContent));

        int requestIndex = userInteractions.returnUserInputInt();

        String selectedRequest = validateInput(requestIndex, fileContent);

        display("\nYou selected:\n");
        display(selectedRequest);
        display("\n1 - Approve\n2 - Decline");
        int selectedApproveOrDecline = userInteractions.returnUserInputInt();
        holidayInteraction.updateHolidayStatus(requestIndex, selectedApproveOrDecline);
        display("\nThe following request has been updated:\n");
        display(getHolidayRequest(requestIndex));
    }

    public void run() {

        UserInteractions.userPrompt("\nSelect (1) or (2)\n\n 1 - Book holiday\n " +
                "2 - Check holiday approval status\n " +
                "3 - Approve holiday (admin only)\n");

        // replace with switch statement to tighten the constraints for user input here (should be 1 or 2 only)

        switch (userInteractions.returnUserInputInt()) {
            case 1 -> optionOneInteraction();
            case 2 -> {
                statusReport("\nHoliday approval status:\n");
                displayElements(reader.getFileContent());
            }
            case 3 -> optionThreeInteraction();
            default -> statusReport("\nPlease select a valid option.");
        }
        userInteractions.closeScanner();

        // userInteractions.customScanner.next(); -> should throw an error because we're trying to use the scanner after closing it!
    }
}

// first issue -> scanner doesn't work the way I thought it did...
// keeps printing the selected number when the code has finished executing.
// turns out I didn't notice a line of code printing out the user input at the end... oops!
// issue with scanner using all whitespace as delimiter. When a name with whitespace was entered (eg Alya Rees) it would skip to the next line. This was avoided by explicitly declaring that the delimiter is a newline.
// extra features to add. Input validation (eg regex to check correct date format).
// issue with getting code tangled up!
// issue - didn't stop to read and understand code! commit message - Refactored checkAndUpdateDate 1dad081
// change the date format to dd/mm/yyyy