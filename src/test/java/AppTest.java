import org.holidayReq.App;
import org.holidayReq.DateHandling;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class AppTest {

    @Test

    public void testIsValidFormat() {

        DateHandling dateHandle = new DateHandling();

        assertTrue(dateHandle.isValidFormat("04/11/2025"));
        assertTrue(dateHandle.isValidFormat("27/12/2025"));
        assertFalse(dateHandle.isValidFormat("hey"));

    }

    @Test

    public void testAddNumberIDs() {

        App app = new App();

        ArrayList<String> testList = new ArrayList<>();

        // Arrange
        testList.add("Name: Alya Rees Employee Number: 943382 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL");
        testList.add("Name: Homer Simpson Employee Number: 112233 Date: 11/11/1111 22/22/2222 - DECLINED");
        testList.add("Name: Jackie Chan Employee Number: 445566 Date: 22/12/2026 22/22/2222 - APPROVED");

        // Pre-conditions - all entries must be inside testList before adding their IDs
        assertEquals("Name: Alya Rees Employee Number: 943382 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL", testList.get(0));
        assertEquals("Name: Homer Simpson Employee Number: 112233 Date: 11/11/1111 22/22/2222 - DECLINED", testList.get(1));
        assertEquals("Name: Jackie Chan Employee Number: 445566 Date: 22/12/2026 22/22/2222 - APPROVED", testList.get(2));

        // Act
        app.addNumberIDs(testList);

        // Assert
        assertEquals("1 - Name: Alya Rees Employee Number: 943382 Date: 11/11/1111 22/22/2222 - PENDING APPROVAL", testList.get(0));
        assertEquals("2 - Name: Homer Simpson Employee Number: 112233 Date: 11/11/1111 22/22/2222 - DECLINED", testList.get(1));
        assertEquals("3 - Name: Jackie Chan Employee Number: 445566 Date: 22/12/2026 22/22/2222 - APPROVED", testList.get(2));

    }
}