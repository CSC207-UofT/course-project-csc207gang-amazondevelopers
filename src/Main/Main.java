import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) throws IOException {
        SystemInOut inOut = new SystemInOut();
        // we need to give user the option to either login or signup, then give them the option to browse etc
        loginOptionsController loginOption = new loginOptionsController();
        boolean keepRunning = true;
        while(keepRunning) {
            try {
                if(!loginOption.userInput()) {
                    keepRunning = false;
                }
            } catch (Exception e) {
                inOut.sendOutput("error occurred");
            }
        }
    }
}