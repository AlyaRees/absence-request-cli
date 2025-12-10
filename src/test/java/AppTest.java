import org.holidayReq.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AppTest {

    static App app = new App();

    // deletes the file before each test, should it already exist

    @Test

    public void testHolidayStatus() {
        UpdateFile updateFile = new UpdateFile();
        WriteToFile writer = new WriteToFile();
        ReadFromFile reader = new ReadFromFile();
        HolidayRequest request = new HolidayRequest("Homer Simpson", "112233", "11/11/1111", "22/22/2222");
        HolidayRequest request2 = new HolidayRequest("Jerry Smith", "556677", "11/11/1111", "22/22/2222");
        int approve = 1;
        int decline = 2;
        int secondEntry = 2;
        int firstEntry = 1;

        assertEquals(new ArrayList<String>(), reader.getFileContent());

        writer.save(request.fileContents());
        writer.save(request2.fileContents());

        ArrayList<String> result = reader.getFileContent();

        assertEquals("Name: Homer Simpson Employee Number: 112233 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL", result.get(0));
//        assertEquals("[Name: Homer Simpson Employee Number: 112233 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL," +
//                " Name: Jerry Smith Employee Number: 556677 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL]", result.toString());

        //updateFile.holidayStatus(firstEntry, approve);
        //updateFile.holidayStatus(secondEntry, decline);

        //assertEquals("Name: Homer Simpson Employee Number: 112233 Date: 11/11/1111 22/22/2222 - APPROVED", reader.getHolidayRequest(firstEntry));
        //assertEquals("Name: Jerry Smith Employee Number: 556677 Date: 11/11/1111 22/22/2222 - DECLINED", ;


    }

    @Test

    public void testGetFileContent() {

        ReadFromFile reader = new ReadFromFile();
        WriteToFile writer = new WriteToFile();
        HolidayRequest request = new HolidayRequest("Homer Simpson", "112233", "11/11/1111", "22/22/2222");
        HolidayRequest request2 = new HolidayRequest("Jerry Smith", "556677", "11/11/1111", "22/22/2222");

        assertEquals(new ArrayList<String>(), reader.getFileContent());

        // writes to a new file
        writer.save(request.fileContents());
        writer.save(request2.fileContents());

        // gets the information from the file and puts it in an ArrayList
        ArrayList<String> result = reader.getFileContent();

        // checks the information added earlier is in the file
        assertEquals("Name: Homer Simpson Employee Number: 112233 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL", result.get(0));
        assertEquals("[Name: Homer Simpson Employee Number: 112233 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL," +
                " Name: Jerry Smith Employee Number: 556677 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL]", result.toString());

    }

    @Test

    public void testAddNumberIDs() {

        ArrayList<String> testList = new ArrayList<>();

        // Arrange
        testList.add("Name: Alya Rees Employee Number: 332244 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL");
        testList.add("Name: Homer Simpson Employee Number: 112233 Date: 11/11/1111 22/22/2222 - DECLINED");
        testList.add("Name: Jackie Chan Employee Number: 445566 Date: 22/12/2026 22/22/2222 - APPROVED");

        // Pre-conditions - all entries must be inside testList before adding their IDs
        assertEquals("Name: Alya Rees Employee Number: 332244 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL", testList.get(0));
        assertEquals("Name: Homer Simpson Employee Number: 112233 Date: 11/11/1111 22/22/2222 - DECLINED", testList.get(1));
        assertEquals("Name: Jackie Chan Employee Number: 445566 Date: 22/12/2026 22/22/2222 - APPROVED", testList.get(2));

        // Act
        app.addNumberIDs(testList);

        // Assert
        assertEquals("1 - Name: Alya Rees Employee Number: 332244 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL", testList.get(0));
        assertEquals("2 - Name: Homer Simpson Employee Number: 112233 Date: 11/11/1111 22/22/2222 - DECLINED", testList.get(1));
        assertEquals("3 - Name: Jackie Chan Employee Number: 445566 Date: 22/12/2026 22/22/2222 - APPROVED", testList.get(2));

    }

}
