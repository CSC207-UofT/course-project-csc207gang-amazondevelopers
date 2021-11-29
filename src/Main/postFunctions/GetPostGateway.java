package postFunctions;
import inputOutputFunctions.SystemInOut;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Get the post from the IdToPost.ser file
 */
public class GetPostGateway {

    /**
     * Takes in a string id representing a product and return the post associated with it
     * @param productId the id of the product whose post object we want to return
     * @return post associated with the String product id
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException thrown if the class is not found
     */
    public Post getPost(String productId) throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        File file = new File("src/Main/IdToPost.ser");
        if (file.length() == 0){
            PostCreationPresenter presenter = new PostCreationPresenter();
            presenter.noPostPresent();

            // go back to options
            // go back to options
            return null;
        }
        PostReadWriter rw = new PostReadWriter();
        HashMap<String, Object> idToPostDict = rw.readFromFile("src/Main/IdToPost.ser");
        if (idToPostDict.get(productId) != null){
            return (Post) idToPostDict.get(productId);
        }
        // go back to option
        return null;
    }
}
