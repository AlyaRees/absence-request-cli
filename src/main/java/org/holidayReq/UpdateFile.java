package org.holidayReq;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateFile extends ReadFromFile {

    // maps number input to it's corresponding meaning (1 - Approves a request, 2 - declines it).
    String approveOrDecline(int userInput) {
        String adminResponse = "";
        switch (userInput) {
            case 1 -> adminResponse = "- APPROVED";
            case 2 -> adminResponse = "- DECLINED";
            default -> App.display("\nInvalid input. Please try again.\n");
        }
        return adminResponse;
    }

    // this makes sure the file is always in the correct format (each line on its own newline).
    public void reformatFile() {
        ArrayList<String> formattedLines = new ArrayList<>();
        // reads from file
        getFileContent()
                // Matches each non-word boundary followed by the word 'Request' (so the start of each line) in the file with a newline
                .forEach(request -> formattedLines.add(request.replaceAll("\\BRequest", "\nRequest")));
        try {
            FileWriter fileWriter = new FileWriter("HolidayReq.txt", false);
            fileWriter.write(fileContentToString(formattedLines));
            fileWriter.close();
        } catch (IOException error) {
            App.statusReport("Error writing to file.");
        }
    }


    public void updateRequestStatus(int selectedHolidayOption, int approveOrDeclineOption) {
        ArrayList<String> fileContent = getFileContent();
        // gets the request that's been selected by the user
        String selectedRequest = fileContent.get(selectedHolidayOption);
        // matches and replaces the APPROVE, DECLINE OR PENDING APPROVAL at the end of each line with new status.
        // '-' 'whitespace' 'word' OR '-' 'whitespace' 'word' 'whitespace' 'word'.
        String updatedRequest = selectedRequest.replaceAll("-\\s\\w+(?:\\s\\w+)?$", approveOrDecline(approveOrDeclineOption)).trim();
        String fileContentString = fileContentToString(fileContent);
        String updatedFileContent = fileContentString.replace(selectedRequest, updatedRequest);
        try {
            FileWriter fileWriter = new FileWriter("HolidayReq.txt", false);
            fileWriter.write(updatedFileContent.trim());
            fileWriter.close();
        } catch (IOException error) {
            App.statusReport("Error writing to file.");
        }
    }

    String fileContentToString(ArrayList<String> fileContent) {
        return String.join("\n", fileContent);
    }
}