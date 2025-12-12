package org.holidayReq;

import java.io.*;
import java.util.ArrayList;

public class ReadFromFile {

    public ArrayList<String> getFileContent() {

        ArrayList<String> dates = new ArrayList<>();

        // used scanner to read files before but this lead to issues of previous input being read so incorrect information was being received.
        // I switched to using a buffer reader to avoid this.
        try (BufferedReader bufferReader = new BufferedReader(
                new FileReader("HolidayReq.txt")
        )) {
            while (bufferReader.ready()) {
                // reads each line in the file and adds it to the dates array.
                dates.add(bufferReader.readLine());
            }
        }
        // The catch block is run if the file doesn't exist or is empty
        catch (IOException e) {
            App.statusReport("No holiday has been submitted.\n" + e);
        }
        return dates;
    }
}