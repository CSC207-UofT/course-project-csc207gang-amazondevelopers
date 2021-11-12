package login;

import InputAndOutput.SystemInOut;
import OptionsPackage.UserOptionsController;
import UserFunctions.User;
import UserFunctions.UserReadWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class GetUserGateway {
    User user;

    public GetUserGateway(User user) {
        this.user = user;
    }

    public User getUser(String username) throws IOException, ClassNotFoundException {

        SystemInOut input = new SystemInOut();

        File file = new File("src/Main/user.ser");
        if (file.length() == 0) {

            input.sendOutput("This user that you are accessing does not exist");
            UserOptionsController options = new UserOptionsController(user);
            options.getOption();
        }
        // access the serialized file for this user.
        UserReadWriter rw = new UserReadWriter();
        HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
        if (!usersSavedDict.containsKey(username)) {
            usersSavedDict.put(username, new User(username));
            rw.saveToFile("src/Main/user.ser", usersSavedDict);
        } else {
            input.sendOutput("This username is takes, please enter another one!");
            SignUpController signUp = new SignUpController();
            signUp.getNewUsername();
        }
        return null;



    }
}
