import org.holidayReq.DateHandling;
import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {

    @Test

    public void testIsValidFormat() {

        DateHandling dateHandle = new DateHandling();

        assertTrue(dateHandle.isValidFormat("04/11/2025"));
        assertTrue(dateHandle.isValidFormat("27/12/2025"));
        assertFalse(dateHandle.isValidFormat("hey"));

    }
}