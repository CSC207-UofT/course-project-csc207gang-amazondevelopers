package UserFunctions;


import InputAndOutput.SystemInOut;
import OptionsPackage.UserOptionsController;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FollowGateway {
    User user;

    public FollowGateway(User user) {
        this.user = user;
    }

    public void follow(String username, SystemInOut input) throws IOException, ClassNotFoundException {
        // check if username of the person we want to follow exists
        File file = new File("src/Main/user.ser");
        if (!(file.length() == 0)) {
            UserReadWriter rw = new UserReadWriter();
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            if (usersSavedDict.containsKey(username)) {
                this.user.getListFollowing().add(username);



                SaveUserChangesGateways saveChanges = new SaveUserChangesGateways();
                saveChanges.save(user.getUsername(), user);


            }
            input.sendOutput("this user you want to follow does not exist, please try again");
            UserOptionsController options = new UserOptionsController(user);
            options.userInput(input);
        }
    }
}