package UserFunctions;

import ProductFunctions.Product;
import ProductFunctions.ProductReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class SaveProductGateway implements SaveProductGatewayInterface{

    public void save(String productID, Product product) throws IOException, ClassNotFoundException {
        // save the changed, new user.
        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> productSavedDict = rw.readFromFile("src/Main/IdToProduct.ser");
        productSavedDict.put(productID, product);
        rw.saveToFile("src/Main/IdToProduct.ser", productSavedDict);
    }
}
