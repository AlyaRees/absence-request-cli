import org.holidayReq.UserInteractions;
import org.holidayReq.Validate;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Mocks {

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
        UserInteractions userInteractions = new UserInteractions();
        Validate mockValidate = mock(Validate.class);

        // Employee numbers must be six digits long.

        String sixDigitEmployeeNum = "112233";
        String invalidEmployeeNum = "-990023";
        String invalidInput = "pretamanger";

        // call with valid input
        validate.checkAndUpdate(sixDigitEmployeeNum);

        // expect userPrompt to not be called
        verify(mockUserInteractions, times(0)).getUserInputStr();
        assertEquals(sixDigitEmployeeNum, validate.checkAndUpdate(sixDigitEmployeeNum));

        // call with invalid input

        // getUserInput needs to return valid input this second time around

    }

    private static void setInput(String input) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
    }
}
