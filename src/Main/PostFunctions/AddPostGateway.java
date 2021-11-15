package PostFunctions;
import OptionsPackage.UserOptionsController;
import UserFunctions.SaveUserChangesGateways;
import UserFunctions.User;
import UserFunctions.UserReadWriter;
import UserFunctions.UserPostUseCase;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class AddPostGateway implements AddPostGatewayInterface{

    /**
     * Adds a post to a users post list in the .ser file
     * @param post the post added by the user
     * @param user the user that added the post
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

    /**
     * Add the post to the feed of all the followers.
     * @param post the post to be added to the feed of the user's followers
     * @param user this user
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException thrown when the class is not found
     */
    public void addFeed(Post post, User user) throws IOException,ClassNotFoundException{
        File file = new File("src/Main/user.ser");
        if (!(file.length() == 0)) {
            PostReadWriter rw = new PostReadWriter();
            UserPostUseCase upc = new UserPostUseCase(user);
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            if (usersSavedDict.containsKey(user.getUsername())) {
                upc.addToFeed(post);
            }
            rw.saveToFile("src/Main/user.ser",usersSavedDict);
        }
    }
}


