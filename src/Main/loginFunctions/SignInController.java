package loginFunctions;
import inputOutputFunctions.InOut;
import serializationFunctions.DictionaryReadWriter;
import userFunctions.User;

import java.io.IOException;
import java.util.HashMap;

/**
 * Controller class to take in username of the user at the welcome page
 */
public class SignInController {

// handles username input

    /**
     * A controller that takes in user username form the user, and return it as a string.
     * @return String username of the user.
     */
    public String getUsername(InOut inOut) throws IOException, ClassNotFoundException {
        SignInPresenter present = new SignInPresenter();
        present.presentSignIn();
        String username = inOut.getInput();
        if (username.strip().equals("") | username.equals("*")) {
            present.failedSignIn();
            return this.getUsername(inOut);
        }
        // access the serialized file for this user.
        DictionaryReadWriter rw = new DictionaryReadWriter();
        // TODO: shouldnt be reading -> this is function of gateway
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
        PasswordPresenter passwordPresenter = new PasswordPresenter();
        passwordPresenter.promptPasswordSignIn((User)usersSavedDict.get(username));
        return username;
        }
}








