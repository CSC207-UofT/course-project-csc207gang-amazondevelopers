package login_functions;

import inputOutputFunctions.SystemInOut;
import loginFunctions.SaveUserGatewayInterface;
import optionsPackage.EnglishOptionsPresenter;
import optionsPackage.UserOptionsController;
import serializationFunctions.DictionaryReadWriter;
import userFunctions.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SaveUserGateway {


    /**
     * Saves a hashmap to user.ser file, with key value pair being username to user
     * @param username A string representing the username
     * @param userToBeSaved the user object that matches the username
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException thrown if the class is not found
     */
    public void saveUser(String username, User userToBeSaved) throws IOException, ClassNotFoundException {
        File file = new File("src/Main2/user.ser");
        if (!(file.length() == 0)) {
            DictionaryReadWriter rw = new DictionaryReadWriter();
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main2/user.ser");
            usersSavedDict.put(username, userToBeSaved);
        }
        else{ // file is empty
            DictionaryReadWriter rw = new DictionaryReadWriter();
            HashMap<String, User> newHashMap = new HashMap<>();
            newHashMap.put(username, userToBeSaved);
            rw.saveToFile("src/Main2/user.ser", newHashMap);
        }
    }

}
//