package loginFunctions;
import inputOutputFunctions.SystemInOut;
import userFunctions.User;
import userFunctions.UserReadWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 */

public class SignUpGateway implements SignUpGatewayInterface {
    /**
     * Checks if username is available by checking within the user.ser file
     * @param username the username of the user
     * @param user the user object
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException thrown if the class is not found
     */
    @Override
    public void allowSignUp(String username, User user) throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        File file = new File("src/Main/user.ser");
        if (file.length() == 0){
            UserReadWriter rw = new UserReadWriter();
            HashMap<String, Object> newHashMap = new HashMap<>();
            newHashMap.put(username, user);
            rw.saveToFile("src/Main/user.ser", newHashMap);
        }
        else {
            // access the serialized file for this user.
            UserReadWriter rw = new UserReadWriter();
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            if (!usersSavedDict.containsKey(username)) {
                usersSavedDict.put(username, user);
                rw.saveToFile("src/Main/user.ser", usersSavedDict);
            } else { // the user.ser contains
                // TODO: allow user to exit out of creating an account
                input.sendOutput("This username is taken, please enter another one!");
                SignUpController signUpController = new SignUpController();
                signUpController.getNewUsername();
            }
        }

    }

}
