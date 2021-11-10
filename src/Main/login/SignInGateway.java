package login;

import InputAndOutput.SystemInOut;
import UserFunctions.ReadWriter;
import UserFunctions.User;
import UserFunctions.UserReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class SignInGateway implements  SignInGatewayInterface {

    /**
     * Return a user, either a new one with the given username, or an old user, that was previously saved in our system
     * @param username The username inputted from the user
     * @param inOut To send output to the user
     * @return A newly created or old user
     * @throws IOException
     * @throws ClassNotFoundException
     */

    public User allowSignIn(String username, SystemInOut inOut) throws IOException, ClassNotFoundException {

        // access the serialized file for this user.
        UserReadWriter rw = new UserReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");

        if (usersSavedDict.containsKey(username)){
            return (User)usersSavedDict.get(username);
        }
        // if the user does not exist, return a user with an empty username, which the empty username is unaccepted
        // username anyways

        return new User("");


    }

}
