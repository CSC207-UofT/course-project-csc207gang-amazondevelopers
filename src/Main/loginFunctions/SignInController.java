package loginFunctions;
import inputOutputFunctions.InOut;

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
        SignInPresenter present = new SignInPresenter();
        present.presentSignIn();
        String username = inOut.getInput();
        if (username.strip().equals("") | username.equals("*")) {
            present.failedSignIn();
            return this.getUsername(inOut);
        }
        return username;
        }
}








