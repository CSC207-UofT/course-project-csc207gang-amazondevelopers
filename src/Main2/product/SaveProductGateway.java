package product;
import login_functions.DictionaryReadWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SaveProductGateway implements SaveProductGatewayInterface {

    /**
     * Add the product given the descriptions to the product.ser and IDtoProduct.ser files
     * @param newProduct the new product string
     * @param productId the ID of the product
     * @param tag the category of the product
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException throws if the class is not found
     */

    public void addProductToRepo(Product newProduct, String productId, String tag) throws IOException,
            ClassNotFoundException {

        DictionaryReadWriter rw = new DictionaryReadWriter();

        File file = new File("src/Main2/product.ser");
        if (file.length() == 0){
            HashMap<String, List<String>> emptyHashMap = new HashMap<>();
            rw.saveToFile("src/Main2/product.ser", emptyHashMap);
        }

        HashMap<String, Object> productsSavedDict = rw.readFromFile("src/Main2/product.ser");
        // {tag:[ID]}
        if (productsSavedDict.containsKey(tag)) {
            List<String> productIDList = (List<String>) productsSavedDict.get(tag);
            productIDList.add(productId);
            productsSavedDict.put(tag, productIDList);
            rw.saveToFile("src/Main2/product.ser", productsSavedDict);
        }
        else {
            List<String> newList = new ArrayList<>();
            newList.add(newProduct.getId());
            productsSavedDict.put(tag,newList);
            rw.saveToFile("src/Main2/product.ser", productsSavedDict);
        }

        // {ID: product}
        File file2 = new File("src/Main2/IdToProduct.ser");
        if (file2.length() == 0){
            HashMap<String, List<String>> emptyHashMap = new HashMap<>();
            rw.saveToFile("src/Main2/IdToProduct.ser", emptyHashMap);
        }

        HashMap<String, Object> idToProductDict = rw.readFromFile("src/Main2/IdToProduct.ser");
        idToProductDict.put(productId, newProduct);
        rw.saveToFile("src/Main2/IdToProduct.ser", idToProductDict);

    }
}