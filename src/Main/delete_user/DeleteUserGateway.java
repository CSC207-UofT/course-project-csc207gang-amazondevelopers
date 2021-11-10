package delete_user;

import InputAndOutput.SystemInOut;
import OptionsPackage.UserOptionsController;
import UserFunctions.User;
import UserFunctions.UserReadWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class DeleteUserGateway {
    User user;

    public DeleteUserGateway(User user) {
        this.user = user;
    }

    public void deleteUser(String username, SystemInOut input) throws IOException, ClassNotFoundException {
        File file = new File("src/Main/user.ser");
        if (!(file.length() == 0)) {
            // access the serialized file for this user.
            UserReadWriter rw = new UserReadWriter();
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            if (usersSavedDict.containsKey(username)) {
                usersSavedDict.remove(username);
                rw.saveToFile("src/Main/user.ser", usersSavedDict);

            }
            input.sendOutput("This username does not exist, so it cannot be deleted ");
            UserOptionsController options = new UserOptionsController(user);
            options.userInput(input);

        }
        input.sendOutput("This username does not exist, so it cannot be deleted ");
        UserOptionsController options = new UserOptionsController(user);
        options.userInput(input);


    }
}
