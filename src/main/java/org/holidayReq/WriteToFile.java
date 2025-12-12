package org.holidayReq;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public void save(String content) {
        try {
            // append 'true' so previous data is not overwritten.
            FileWriter fileWriter = new FileWriter("HolidayReq.txt", true);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException error) {
            App.statusReport("Error writing to file.");
        }
    }
}