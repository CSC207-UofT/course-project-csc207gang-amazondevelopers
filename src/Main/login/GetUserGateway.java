package login;

import login.sign_in.SignInGatewayInterface;
import read_writer.DictionaryReadWriter;
import user.User;


import java.io.File;
import java.util.HashMap;


public class GetUserGateway implements SignInGatewayInterface {

    /**
     * Return a user, either a new one with the given username, or an old user, that was previously saved in our system
     * @param username The username inputted from the user
     * @return A newly created or old user
     */
    public User getUser(String username){
        File file = new File("src/Main/user.ser");
        // access the serialized file for this user.
        DictionaryReadWriter rw = new DictionaryReadWriter();
        if (!(file.length() == 0)) {
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            if (usersSavedDict.containsKey(username)) {
                return (User) usersSavedDict.get(username);
            }
        }
        // if the user does not exist, return a user with an empty username, which the empty username is unaccepted
        // username anyways
        // TODO: fix this
        return new User("");
    }
}
