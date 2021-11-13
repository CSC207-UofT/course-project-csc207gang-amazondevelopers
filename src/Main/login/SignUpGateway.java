package login;

import InputAndOutput.SystemInOut;
import UserFunctions.User;
import UserFunctions.UserReadWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SignUpGateway implements SignUpGatewayInterface {
    /**
     * Checks if username is available by checking within the user.ser file
     * @param username the username of the user
     * @param user the user object
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void allowSignUp(String username, User user) throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();

        File file = new File("src/Main/user.ser");
        if (file.length() == 0){
            UserReadWriter rw = new UserReadWriter();
            HashMap<String, Object> emptyHashMap = new HashMap<>();
            rw.saveToFile("src/Main/user.ser", emptyHashMap);
        }

        // access the serialized file for this user.
        UserReadWriter rw = new UserReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
        if (!usersSavedDict.containsKey(username)) {
            usersSavedDict.put(username, user);
            rw.saveToFile("src/Main/user.ser", usersSavedDict);
        }
        else{
            input.sendOutput("This username is taken, please enter another one!");
            SignUpController signUp = new SignUpController();
            signUp.getNewUsername();
        }





    }

}
