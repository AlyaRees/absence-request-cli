import org.holidayReq.*;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Mocks {

    @Test

    public void testCheckAndUpdateWithValidInput() {

        // Employee numbers must be six digits long.

        Validate validate = new Validate();
        String sixDigitEmployeeNum = "112233";
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.next()).thenReturn(sixDigitEmployeeNum);

        String result = validate.checkAndUpdate(mockScanner);

        verify(mockScanner, times(1)).next();
        assertEquals(sixDigitEmployeeNum, result);

    }

    @Test

    public void testCheckAndUpdateWithInvalidInput() {

        Validate validate = new Validate();
        String sixDigitEmployeeNum = "112233";
        String invalidEmployeeNum = "-990023";
        Scanner mockScanner = mock(Scanner.class);

        when(mockScanner.next())
                .thenReturn(invalidEmployeeNum)
                .thenReturn(sixDigitEmployeeNum);

        String result = validate.checkAndUpdate(mockScanner);

        verify(mockScanner, times(2)).next();
        assertEquals(sixDigitEmployeeNum, result);

    }
}