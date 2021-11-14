package PostFunctions;
import OptionsPackage.UserOptionsController;
import UserFunctions.SaveUserChangesGateways;
import UserFunctions.User;
import UserFunctions.UserReadWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class AddPostGateway implements AddPostGatewayInterface{

    /**
     * Adds a post to a users post list in the .ser file
     * @param post
     * @param user
     */
    public void addPost(Post post, User user) throws IOException, ClassNotFoundException {
        File file = new File("src/Main/user.ser");
        if (!(file.length() == 0)) {
            PostReadWriter rw = new PostReadWriter();
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            if (usersSavedDict.containsKey(user.getUsername())) {
                user.addToPostList(post);
            }
            rw.saveToFile("src/Main/user.ser",usersSavedDict);
        }
    }
}


