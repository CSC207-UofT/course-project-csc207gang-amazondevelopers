package follow_users;


import InputAndOutput.SystemInOut;
import OptionsPackage.UserOptionsController;
import OptionsPackage.UserOptionsUseCase;
import PostFunctions.Post;
import UserFunctions.SaveUserChangesGateways;
import UserFunctions.User;
import UserFunctions.UserReadWriter;
import UserFunctions.UserUseCase;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FollowGateway {
    // This user  signed in
    User user;

    public FollowGateway(User user) {
        this.user = user;
    }

    public void follow(String username) throws IOException, ClassNotFoundException {
        // username is the username of the new person that I want to follow
        SystemInOut input = new SystemInOut();
        // check if username of the person we want to follow exists
        File file = new File("src/Main/user.ser");

        if (!(file.length() == 0)) {
            UserReadWriter rw = new UserReadWriter();
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            if (usersSavedDict.containsKey(username)) {
                UserUseCase userUseCase = new UserUseCase();
                List followingList = userUseCase.getListFollowing();
                followingList.add(username);
                SaveUserChangesGateways saveChanges = new SaveUserChangesGateways();
                saveChanges.save(user.getUsername(), user);
            }
            input.sendOutput("this user you want to follow does not exist, please try again");
            FollowController followOptions = new FollowController(user);
            followOptions.allowFollow();
        }
    }
}