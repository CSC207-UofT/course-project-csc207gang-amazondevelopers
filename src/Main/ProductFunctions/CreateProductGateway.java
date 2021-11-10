package ProductFunctions;

import java.io.IOException;
import java.util.HashMap;

public class CreateProductGateway implements CreateProductGatewayInterface {

    public void addProductToRepo(Product newProduct, String productId) throws IOException, ClassNotFoundException {
        String tag = newProduct.getCategory();
        ProductReadWriter rw = new ProductReadWriter();

        HashMap<String, Object> productsSavedDict = rw.readFromFile("src/Main/product.ser");
        productsSavedDict.put(tag, newProduct);
        rw.saveToFile("src/Main/product.ser", productsSavedDict);

        HashMap<String, Object> idToProductDict = rw.readFromFile("src/Main/IdToProduct.ser");
        productsSavedDict.put(productId, newProduct);
        rw.saveToFile("src/Main/IdToProduct.ser", idToProductDict);
    }
}
