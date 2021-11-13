package ProductFunctions;

import InputAndOutput.SystemInOut;
import OptionsPackage.UserOptionsController;
import OptionsPackage.UserOptionsUseCase;
import UserFunctions.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Gets the product by their ID< and returns that product
 */

public class GetProductGateway implements GetProductGatewayInterface{
    // ID to product

    public Object getProduct(String productId) throws IOException, ClassNotFoundException {
        SystemInOut input = new SystemInOut();

        File file = new File("src/Main/IdToProduct.ser");
        if (file.length() == 0){
            input.sendOutput("There are no products in this program yet!");
            // go back to options
            return null;
        }
        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> idToProductDict = rw.readFromFile("src/Main/IdToProduct.ser");
        if (idToProductDict.get(productId) != null){
            return idToProductDict.get(productId);
        }
        // go back to option
        return null;
    }
}
