package ProductFunctions;

import InputAndOutput.SystemInOut;
import UserFunctions.UserReadWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Gets the product by their ID< and returns that product
 */

public class GetProductGateway implements GetProductGatewayInterface{
    // ID to product

    public Product getProduct(String productId) throws IOException, ClassNotFoundException {

        File file = new File("src/Main/IdToProduct.ser");
        if (file.length() == 0){
            // TODO check this
            return null;
        }



        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> idToProductDict = rw.readFromFile("src/Main/IdToProduct.ser");
        if (idToProductDict.get(productId) != null){
            return (Product) idToProductDict.get(productId);
        }
        return null;
    }
}
