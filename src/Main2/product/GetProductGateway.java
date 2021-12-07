package product;
import read_writer.DictionaryReadWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Gets the product by their ID< and returns that product
 */

public class GetProductGateway implements GetProductGatewayInterface {



    /**
     * Get eh product from the .ser file
     * @param productId the ID of the product
     * @return the product given the ID
     */

    public Product getProduct(String productId){
        DictionaryReadWriter rw = new DictionaryReadWriter();
        HashMap<String, Object> idToProductHashMap = rw.readFromFile("src/Main2/IdToProduct.ser");
        return (Product) idToProductHashMap.get(productId);
    }

    /**
     * Check if the product with the given ID is in the .ser file
     * @param productId the ID of the product
     * @return true or false, given whenther the product ID is saved in the data base
     */
    // return true if id exists in IDToProduct.ser file and false otherwise.
    public boolean checkId(String productId){
        File file = new File("src/Main2/IdToProduct.ser");
        if (file.length() == 0){
            return false;
        }
        else{
            DictionaryReadWriter rw = new DictionaryReadWriter();
            HashMap<String, Object> idToProductHashMap = rw.readFromFile("src/Main2/IdToProduct.ser");
            return idToProductHashMap.containsKey(productId);
        }
    }

    /**
     * Get the hashmap of the Id to products
     * @return the hashmap of the Id to product
     */
    public HashMap<String, Object> getHashMap(){
        File file = new File("src/Main2/IdToProduct.ser");
        if (file.length() == 0) {
            return new HashMap<>();
        }
        else {
            DictionaryReadWriter rw = new DictionaryReadWriter();
            return rw.readFromFile("src/Main2/IdToProduct.ser");
        }


    }
}