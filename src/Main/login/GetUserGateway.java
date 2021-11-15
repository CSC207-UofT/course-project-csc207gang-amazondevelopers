package login;
import InputAndOutput.InOut;
import InputAndOutput.SystemInOut;
import UserFunctions.User;
import UserFunctions.UserReadWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class GetUserGateway implements  SignInGatewayInterface {

    /**
     * Return a user, either a new one with the given username, or an old user, that was previously saved in our system
     * @param username The username inputted from the user
     * @return A newly created or old user
     */
    public User getUser(String username) throws IOException, ClassNotFoundException {
        // TODO: gateways should just read and check files, not ask for user input, that should be the job of the controller
        SystemInOut inOut = new SystemInOut();
        File file = new File("src/Main/user.ser");
        if (file.length() == 0){
            inOut.sendOutput("No user exists yet, please sign up. You are being redirected to the welcome page.");
            WelcomePageController welcome = new WelcomePageController();
            welcome.userLoginDecision(inOut);
        }
        // access the serialized file for this user.
        UserReadWriter rw = new UserReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
        if (usersSavedDict.containsKey(username)){
            return (User)usersSavedDict.get(username);
        }
        // if the user does not exist, return a user with an empty username, which the empty username is unaccepted
        // username anyways
        // TODO: fix this
        return new User("");
    }
}
