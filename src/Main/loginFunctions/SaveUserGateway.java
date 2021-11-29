package loginFunctions;
import inputOutputFunctions.SystemInOut;
import optionsPackage.EnglishOptionsPresenter;
import optionsPackage.UserOptionsController;
import serializationFunctions.DictionaryReadWriter;
import userFunctions.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 */
public class SaveUserGateway implements SaveUserGatewayInterface {

    /**
     * Saves a hashmap to user.ser file, with key value pair being username to user
     * @param username A string representing the username
     * @param userToBeSaved the user object that matches the username
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException thrown if the class is not found
     */
    public void saveUser(String username, User userToBeSaved) throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        // check if username of the person we want to add exists
        File file = new File("src/Main/user.ser");
        if (!(file.length() == 0)) {
            DictionaryReadWriter rw = new DictionaryReadWriter();
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            // TODO: why not see that the username of this user that is logged in in contained inside the user.ser file?
            if (usersSavedDict.containsKey(username)) {
                usersSavedDict.put(username, userToBeSaved);
            }
            else {
                input.sendOutput("User saving was unsuccessful. You are being sent back to choose another option.");
                UserOptionsController options = new UserOptionsController(userToBeSaved);
                EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();
                options.getOption(input, engPresenter);
            }
        }
        else{
            input.sendOutput("User saving was unsuccessful. You are being sent back to choose another option.");
            UserOptionsController userOptionsController = new UserOptionsController(userToBeSaved);
            EnglishOptionsPresenter engPresenter = new EnglishOptionsPresenter();
            userOptionsController.getOption(input, engPresenter);
        }

    }
}
