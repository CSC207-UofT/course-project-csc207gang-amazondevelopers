package login;
import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;
import java.io.IOException;

/**
 * Controller class to take in username of the user at the welcome page
 */
public class SignInController {

// handles username input

    /**
     * A controller that takes in user username form the user, and return it as a string.
     * @return String username of the user.
     */
    public String getUsername(InOut inOut) throws IOException {
        inOut.sendOutput("What is your username? (please do not leave this field empty)");
        String username = inOut.getInput();
        while (username.equals("")){
            inOut.sendOutput("Invalid Username, please reenter your username.");
            this.getUsername(inOut);
        }

        return username;
        }
}








