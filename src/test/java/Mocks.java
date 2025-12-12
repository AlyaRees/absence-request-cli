import org.holidayReq.*;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Mocks {

    /*
    I've used mocking here as this allows me to check methods are:
    - called when they should be
    - called in the right order and
    - called the right number of times

    I can change the return value of some methods (here I do that with Scanner.next() a few times to test the different behaviours of different methods).

     */

    @Test

    public void testReviewSelection() {

        // selection should be limited to a 1 - approve or 2 - decline

        CheckAndUpdate checkAndUpdate = new CheckAndUpdate();
        String invalidInput = "12";
        String validInput = "1";

        // a 'pretend' version of the scanner is created.
        Scanner mockScanner = mock(Scanner.class);

        when(mockScanner.next())
                .thenReturn(invalidInput)
                .thenReturn(validInput);

        int result = Integer.parseInt(checkAndUpdate.approveOrDeclineSelection(mockScanner));

        verify(mockScanner, times(2)).next();
        // we would expect the integer 1, not the string 1 as we parse the string into an integer.
        assertEquals(1, result);
    }

    @Test

    public void testCheckAndUpdateValidInput() {

        // Employee numbers must be six digits long.

        CheckAndUpdate checkAndUpdate = new CheckAndUpdate();
        String sixDigitEmployeeNum = "112233";
        Scanner mockScanner = mock(Scanner.class);

        // when the scanner.next() method is called, we make the return value 'sixDigitEmployeeNum'.
        when(mockScanner.next()).thenReturn(sixDigitEmployeeNum);

        String result = checkAndUpdate.employeeNumber(mockScanner);

        // we would expect the scanner to be called once in this instance and for checkAndUpdate to return 'sixDigitEmployeeNum'
        verify(mockScanner, times(1)).next();
        assertEquals(sixDigitEmployeeNum, result);

    }

    @Test

    public void testCheckAndUpdateInvalidInput() {

        CheckAndUpdate checkAndUpdate = new CheckAndUpdate();
        String sixDigitEmployeeNum = "112233";
        String invalidEmployeeNum = "-990023";
        Scanner mockScanner = mock(Scanner.class);

        // the first time scanner.next() is called, it will return invalid input
        // the second time it returns valid input
        // this 'mocks' the behaviour of a user, inputting invalid input and then valid input the second time around.
        when(mockScanner.next())
                .thenReturn(invalidEmployeeNum)
                .thenReturn(sixDigitEmployeeNum);

        String result = checkAndUpdate.employeeNumber(mockScanner);

        // because we simulated invalid input the first time, checkAndUpdate asked the user for input again. Once it receives valid input it stops looping and returns it.
        verify(mockScanner, times(2)).next();
        assertEquals(sixDigitEmployeeNum, result);

    }

}