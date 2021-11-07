package login;

import InputAndOutput.SystemInOut;
import UserFunctions.User;
import UserFunctions.UserReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class SignUpController {

    public void allowSignUp(String username) throws IOException, ClassNotFoundException {

        // access the serialized file for this user.
        UserReadWriter rw = new UserReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("user.ser");
        usersSavedDict.put(username, new User(username));
        rw.saveToFile("user.ser", usersSavedDict);




    }


}
