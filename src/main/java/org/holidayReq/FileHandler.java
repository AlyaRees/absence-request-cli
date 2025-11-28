package org.holidayReq;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class HandlesFile {
    protected String fileName = "HolidayReq.txt";
}

 class ReadFromFile extends HandlesFile {

    File fileObject = new File(fileName);
    ArrayList<String> dates = new ArrayList<>();

    ArrayList<String> getFileContent() {
        try (Scanner fileReader = new Scanner(fileObject)) {
            while (fileReader.hasNextLine()) {
                dates.add(fileReader.nextLine().trim());
            }
        } catch (FileNotFoundException error) {
            App.statusReport("No holiday has been submitted.\n");
        }
        return dates;
    }
}

class WriteToFile extends HandlesFile {

    void save(HolidayRequest request) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(request.fileContents());
        } catch (IOException error) {
            App.statusReport("Error writing to file.");
            error.printStackTrace();
        }
    }
}

  class UpdateFile extends ReadFromFile {

    public void reformatFile() {

        ReadFromFile fileReader = new ReadFromFile();
        ArrayList<String> formattedLines = new ArrayList<>();

        // read from file
        fileReader.getFileContent()
                .forEach(request -> formattedLines.add(request.replaceAll("\\BName", "\nName")));

        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            fileWriter.write(updatedFileContent(formattedLines));
        } catch (IOException error) {
            App.statusReport("Error writing to file.");
            error.printStackTrace();
        }
    }

    void updateHolidayStatus(int selectedOption, int userSelection) {

        HolidayInteractions holidayInteraction = new HolidayInteractions();
        String selectedRequest = App.getHolidayRequest(selectedOption);
        String fileContent = updatedFileContent(getFileContent());

        String updatedLine = selectedRequest.replaceAll("-\\s\\w+(?:\\s\\w+)?$", holidayInteraction.approveOrDecline(userSelection));
        String updatedContent = fileContent.replaceAll(selectedRequest, updatedLine);

        try (FileWriter fileWriter = new FileWriter(fileName, false)) {
            // before we write to the file
            fileWriter.write(updatedContent + "\n");
            fileWriter.close();

        } catch (IOException error) {
            App.statusReport("Error writing to file.");
            error.printStackTrace();
        }
    }

    String updatedFileContent(ArrayList<String> fileContent) {
        return String.join("\n", fileContent);
    }
}