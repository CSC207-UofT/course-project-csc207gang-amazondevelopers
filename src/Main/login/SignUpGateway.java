package login;

import InputAndOutput.SystemInOut;
import UserFunctions.User;
import UserFunctions.UserReadWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SignUpGateway implements SignUpGatewayInterface {

    public void allowSignUp(String username) throws IOException, ClassNotFoundException {

// TODO Delete user, check if there are multiple of same usernames.

        File file = new File("src/Main/user.ser");
        if (file.length() == 0){
            UserReadWriter rw = new UserReadWriter();
            HashMap<String, Object> emptyHashMap = new HashMap<>();
            rw.saveToFile("src/Main/user.ser", emptyHashMap);
        }

        // access the serialized file for this user.
        UserReadWriter rw = new UserReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
        usersSavedDict.put(username, new User(username));
        rw.saveToFile("src/Main/user.ser", usersSavedDict);
    }


}
