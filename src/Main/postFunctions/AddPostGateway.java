package postFunctions;
import serializationFunctions.DictionaryReadWriter;
import userFunctions.User;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Add options.post to the serialized file.
 */
public class AddPostGateway implements AddPostGatewayInterface{

    /**
     * Adds a options.post to a users options.post list in the user.ser file
     * @param post the options.post added by the user
     * @param user the user that added the options.post
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
}


