package options.post;
import read_writer.DictionaryReadWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Get the options.post from the IdToPost.ser file
 */
public class GetPostGateway {

    /**
     * Takes in a string id representing a product and return the options.post associated with it
     * @param productId the id of the product whose options.post object we want to return
     * @return options.post associated with the String product id
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException thrown if the class is not found
     */
    public Post getPost(String productId) throws IOException, ClassNotFoundException {
        File file = new File("src/Main/IdToPost.ser");
        if (file.length() == 0){
            // go back to options
            return null;
        }
        DictionaryReadWriter rw = new DictionaryReadWriter();
        HashMap<String, Object> idToPostDict = rw.readFromFile("src/Main/IdToPost.ser");
        if (idToPostDict.get(productId) != null){
            return (Post) idToPostDict.get(productId);
        }
        // go back to option
        return null;
    }
}