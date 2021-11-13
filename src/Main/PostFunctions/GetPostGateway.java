package PostFunctions;

import InputAndOutput.SystemInOut;
import ProductFunctions.Product;
import ProductFunctions.ProductReadWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class GetPostGateway {
    // ID to product

    public Post getPost(String productId) throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();
        File file = new File("src/Main/IdToPost.ser");
        if (file.length() == 0){
            input.sendOutput("There are no posts in this program yet!");
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
