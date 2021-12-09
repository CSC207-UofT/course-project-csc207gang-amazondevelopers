package delete_gateways;

import read_writer.DictionaryReadWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class DeleteUserGateway {

    /**
     * Takes in the String username of the user that wants to be deleted.
     * Deletes a user from the user.ser file and returns true if successful.
     * Returns false otherwise.
     *
     * @return true if user was successfully deleted and false otherwise.
     */
    public boolean deleteUser(String username){
        File file = new File("src/Main/user.ser");
        if (!(file.length() == 0)) {
            // access the serialized file for this user.
            DictionaryReadWriter rw = new DictionaryReadWriter();
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            if (usersSavedDict.containsKey(username)) {
                usersSavedDict.remove(username);
                rw.saveToFile("src/Main/user.ser", usersSavedDict);
                return true;
            }
        }
        // means user does not exist
        return false;
    }
}
