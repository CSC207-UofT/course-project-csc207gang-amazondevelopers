package ProductFunctions;

import InputAndOutput.SystemInOut;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Gets the product by their ID< and returns that product
 */

public class GetProductGateway implements GetProductGatewayInterface{

    SystemInOut input = new SystemInOut();

    /**
     * Get eh product from the .ser file
     * @param productId the ID of the product
     * @return the product given the ID
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException exception when the class is not found
     */

    public Product getProduct(String productId) throws IOException, ClassNotFoundException {
        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> idToProductHashMap = rw.readFromFile("src/Main/IdToProduct.ser");
        return (Product) idToProductHashMap.get(productId);
    }

    /**
     * Check if the product with the given ID is in the .ser file
     * @param productId the ID of the product
     * @return true or false, given whenther the product ID is saved in the data base
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException thrown if the class is not found
     */
    // return true if id exists in IDToProduct.ser file and false otherwise.
    public boolean checkId(String productId) throws IOException, ClassNotFoundException {
        File file = new File("src/Main/IdToProduct.ser");
        if (file.length() == 0){
            input.sendOutput("There are no products in this program yet!");
            return false;
        }
        else{
            ProductReadWriter rw = new ProductReadWriter();
            HashMap<String, Object> idToProductHashMap = rw.readFromFile("src/Main/IdToProduct.ser");
            return idToProductHashMap.containsKey(productId);
        }
    }

    /**
     * Get the hashmap of the Id to products
     * @return the hashmap of the Id to product
     * @throws IOException error occured during reading a file, when there is an input / output error
     * @throws ClassNotFoundException thrown when there is no class found.
     */
    public HashMap<String, Object> getHashMap() throws IOException, ClassNotFoundException {
        File file = new File("src/Main/IdToProduct.ser");
        if (file.length() == 0) {
            return new HashMap<>();
        }
        else {
            ProductReadWriter rw = new ProductReadWriter();
            return rw.readFromFile("src/Main/IdToProduct.ser");
        }


    }
}
