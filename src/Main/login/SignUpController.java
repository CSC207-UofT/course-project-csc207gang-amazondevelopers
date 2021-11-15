package login;
import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;
import java.io.IOException;

public class SignUpController {
    /**
     * Gets the username from the user input.
     * @return String representing the username inputted by the user
     * @throws IOException error occured during reading a file, when there is an input / output error
     */
    public String getNewUsername(InOut inOut) throws IOException {
        inOut.sendOutput("What would you like to put as your username? " +
                "(please do not leave this field empty and do not put * as your username)");
        String newUsername = inOut.getInput();
        if (newUsername.strip().equals("") | newUsername.equals("*")) {
            inOut.sendOutput("Invalid Username, please reenter your username.");
            newUsername = this.getNewUsername(inOut);
        }
        return newUsername;
    }


}
