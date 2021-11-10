package ProductFunctions;

import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.HashMap;

public class CreateProductGateway implements productSetterGatwewayInterface {

    public void addProductToRepo(Product newProduct) throws IOException, ClassNotFoundException {
        String tag = newProduct.getCategory();
        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> productsSavedDict = rw.readFromFile("src/Main/product.ser");
        productsSavedDict.put(tag, newProduct);
        rw.saveToFile("src/Main/product.ser", productsSavedDict);
    }
}
