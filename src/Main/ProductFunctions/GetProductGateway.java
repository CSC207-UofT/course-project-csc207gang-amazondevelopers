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

    public Product getProduct(String productId) throws IOException, ClassNotFoundException {
        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> idToProductHashMap = rw.readFromFile("src/Main/IdToProduct.ser");
        return (Product) idToProductHashMap.get(productId);
    }

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
