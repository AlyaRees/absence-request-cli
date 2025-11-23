import java.util.Scanner;

public class UserInteractions {

    Scanner customScanner = new Scanner(System.in).useDelimiter("\n");

    void closeScanner() {
        customScanner.close();
    }

    static void userPrompt(String message) {
        System.out.println(message);
    }
}

 abstract class GetUserInput {

    protected  Scanner customScanner;

    abstract String returnUserInput();

    public GetUserInput(Scanner customScanner) {
        this.customScanner = customScanner;
    }    
}

class GetUserInputNumber extends GetUserInput {

    GetUserInputNumber(Scanner customScanner) {
        super(customScanner);
    }

    String returnUserInput() {
        return String.valueOf(customScanner.nextInt());
    }
}

class GetUserInputString extends GetUserInput {

    GetUserInputString(Scanner customScanner) {
        super(customScanner);
    }

    String returnUserInput() {
        return customScanner.next();
    }
}