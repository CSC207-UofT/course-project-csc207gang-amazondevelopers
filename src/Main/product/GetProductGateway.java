package product;
import read_writer.DictionaryReadWriter;
import java.io.File;
import java.util.HashMap;


/**
 * Gets the product by their ID< and returns that product
 */

public class GetProductGateway implements GetProductGatewayInterface {



    /**
     * Get the product from the .ser file
     * @param productId the ID of the product
     * @return the product given the ID
     */

    public Product getProduct(String productId){
        DictionaryReadWriter rw = new DictionaryReadWriter();
        HashMap<String, Object> idToProductHashMap = rw.readFromFile("src/Main/IdToProduct.ser");
        return (Product) idToProductHashMap.get(productId);
    }

    /**
     * Get the hashmap of the Id to products
     * @return the hashmap of the Id to product
     */
    public HashMap<String, Object> getHashMap(){
        File file = new File("src/Main/IdToProduct.ser");
        if (file.length() == 0) {
            return new HashMap<>();
        }
        else {
            DictionaryReadWriter rw = new DictionaryReadWriter();
            return rw.readFromFile("src/Main/IdToProduct.ser");
        }


    }
}