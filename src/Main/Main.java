import InputAndOutput.SystemInOut;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        SystemInOut inOut = new SystemInOut();
        // we need to give user the option to either login or signup, then give them the option to browse etc
        loginOptionsController loginOption = new loginOptionsController();
        try {
            loginOption.userInput();
        } catch(Exception e){
            inOut.sendOutput("error occurred");
        }

    }
}
