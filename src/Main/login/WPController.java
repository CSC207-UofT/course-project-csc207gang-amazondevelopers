package login;

import InputAndOutput.SystemInOut;

import java.io.IOException;

public class WPController {

    public String getWPInput(SystemInOut inOut) throws IOException {
        inOut.sendOutput("What would you like to do? Select the number of choice: \n 1.Signin\n 2.Signup\n" +
                "3.Quit\n Input * at any time to undo your action");

        String userDecision = inOut.getInput();
        return userDecision;

    }

}
