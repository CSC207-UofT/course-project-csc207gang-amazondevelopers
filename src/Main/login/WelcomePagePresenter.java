package login;
import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;

import java.io.IOException;

public class WelcomePagePresenter {
    public String decision(SystemInOut input) throws IOException{
        input.sendOutput("What would you like to do? Select the number of choice: \n 1.Signin\n 2.Signup\n 3.Quit\n Input * at anytime to undo your input");
        // user input
        return input.getInput();
    }
}
