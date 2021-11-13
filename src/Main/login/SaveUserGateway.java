package login;
import InputAndOutput.SystemInOut;
import OptionsPackage.UserOptionsController;
import UserFunctions.User;
import UserFunctions.UserReadWriter;
import follow_users.FollowController;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SaveUserGateway {
    User user;

    public SaveUserGateway(User user) {
        this.user = user;
    }

    public void saveUser(String username, User userToBeSaved) throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        // check if username of the person we want to add exists
        File file = new File("src/Main/user.ser");

        if (!(file.length() == 0)) {
            UserReadWriter rw = new UserReadWriter();
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            if (usersSavedDict.containsKey(username)) {
                usersSavedDict.replace(username, userToBeSaved);
            }
            else {
                input.sendOutput("User saving was unsuccessful. You are being sent back to choose another option.");
                FollowController followOptions = new FollowController(user);
                followOptions.allowFollow();
            }
        }
        else{
            input.sendOutput("User saving was unsuccessful. You are being sent back to choose another option.");
            UserOptionsController userOptionsController = new UserOptionsController(user);
            userOptionsController.getOption();
        }

    }
}
