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
    public String getUsername() throws IOException {
        SystemInOut inOut = new SystemInOut();
        SignInPresenter present = new SignInPresenter();
        present.presentSignIn();
        String username = inOut.getInput();
        if (username.strip().equals("") | username.equals("*")) {
            present.failedSignIn();
            return this.getUsername();
        }
        return username;
        }
}








