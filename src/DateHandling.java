import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateHandling {

    UserInteractions userInteractions = new UserInteractions();
    GetUserInputString getUserInputString = new GetUserInputString(userInteractions.customScanner);

    String checkAndUpdateDate(String message, String date) {
        while (!isValidFormat(date)) {
            askForDateAgain(message);
            date = getUserInputString.returnUserInput();
        }
        return date;
    }

    void askForDateAgain(String message) {
        userInteractions.userPrompt("\nInvalid format. Try again.");
        userInteractions.userPrompt(message);
    }

    boolean isValidFormat(String date) {
        Pattern dateFormat = Pattern.compile("^\\d{2}\\/\\d{2}\\/\\d{4}$");
        Matcher checkFormat = dateFormat.matcher(date);

        return checkFormat.matches();
    }
}
