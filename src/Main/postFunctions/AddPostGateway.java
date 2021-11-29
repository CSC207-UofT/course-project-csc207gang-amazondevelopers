package postFunctions;
import serializationFunctions.DictionaryReadWriter;
import userFunctions.User;
import userFunctions.UserPostUseCase;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Add post to the serialized file.
 */
public class AddPostGateway implements AddPostGatewayInterface{

    /**
     * Adds a post to a users post list in the user.ser file
     * @param post the post added by the user
     * @param user the user that added the post
     */
    public void addPost(Post post, User user) throws IOException, ClassNotFoundException {
        File file = new File("src/Main/user.ser");
        if (!(file.length() == 0)) {
            DictionaryReadWriter rw = new DictionaryReadWriter();
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            ((User) usersSavedDict.get(user.getUsername())).addToPostList(post);
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
            DictionaryReadWriter rw = new DictionaryReadWriter();
            UserPostUseCase upc = new UserPostUseCase(user);
            HashMap<String, Object> usersSavedDict = rw.readFromFile("src/Main/user.ser");
            ((User) usersSavedDict.get(user.getUsername())).addToFeed(post);
            rw.saveToFile("src/Main/user.ser",usersSavedDict);
        }
    }
}


