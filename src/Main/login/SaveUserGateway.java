package login;

import read_writer.DictionaryReadWriter;
import user.User;

import java.io.File;
import java.util.HashMap;

public class SaveUserGateway implements SaveUserGatewayInterface {

    /**
     * Saves a hashmap to user.ser file, with key value pair being username to user
     * @param username A string representing the username
     * @param userToBeSaved the user object that matches the username
     */
    public void saveUser(String username, User userToBeSaved){
        File file = new File("src/Main/user.ser");
        if (!(file.length() == 0)) {
            DictionaryReadWriter rw = new DictionaryReadWriter();
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            usersSavedDict.put(username, userToBeSaved);
            rw.saveToFile("src/Main/user.ser", usersSavedDict);
        }
        else{ // file is empty
            DictionaryReadWriter rw = new DictionaryReadWriter();
            HashMap<String, User> newHashMap = new HashMap<>();
            newHashMap.put(username, userToBeSaved);
            rw.saveToFile("src/Main/user.ser", newHashMap);
        }
    }

}
