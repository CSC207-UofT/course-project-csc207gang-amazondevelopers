package optionsPackage;
import serializationFunctions.DictionaryReadWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * take user input from command line interface and
 * Takes in user input tag words and and returns a list of all products that match that description to the user,
 * taking this information from a the masterManager which accese the tageProduct dictionary in master.
 * That dictionary has keys as the tag words for each product, and a list of product associated with that tag
 * word.
 */

public class SearchGateway {

    /**
     * Return a list of product under the 'tag' category.
     * @param tag the tag that the users is searching for.
     * @return a string of products that corresponds to the tag
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException the exception thrown when the class is not found
     */
    public ArrayList<String> searchProducts(String tag) throws IOException, ClassNotFoundException {

        File file = new File("src/Main/product.ser");
        if (file.length() == 0){
            DictionaryReadWriter rw = new DictionaryReadWriter();
            HashMap<String, Object> emptyHashMap = new HashMap<>();
            rw.saveToFile("src/Main/product.ser", emptyHashMap);
        }
        DictionaryReadWriter rw = new DictionaryReadWriter();
        HashMap<String, Object> productSavedDict = rw.readFromFile("src/Main/product.ser");

        if (productSavedDict.containsKey(tag)){
            return (ArrayList<String>) productSavedDict.get(tag);
        }
        // an empty list since the tag does not exist
        return new ArrayList<>();
    }

    }
