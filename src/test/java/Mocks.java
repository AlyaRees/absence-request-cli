import org.holidayReq.ReadFromFile;
import org.holidayReq.UserInteractions;
import org.holidayReq.Validate;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Mocks {

    @Mock
    ReadFromFile reader;

    @Test
    public void testGetFileContent() {

        // mock the file object?
    }

    @Test

    public void testCheckAndUpdate() {

        // Don't mock validateFormat. We're testing how this behaves with the while loop.
        // Only mock getUserInput to return valid or invalid entries (depending on the tests).

        Validate validate = new Validate();
        UserInteractions mockUserInteractions = mock(UserInteractions.class);

        // Employee numbers must be six digits long.

        String sixDigitEmployeeNum = "112233";
        String invalidEmployeeNumShort = "12";
        String invalidEmployeeNumLong = "0234560";
        String invalidEmployeeNum = "-990023";
        String invalidInput = "pretamanger";

        when(mockUserInteractions.getUserInputStr()).thenReturn(sixDigitEmployeeNum);

        assertEquals(sixDigitEmployeeNum, validate.checkAndUpdate(sixDigitEmployeeNum));

    }

}
