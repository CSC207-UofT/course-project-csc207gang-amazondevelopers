package ProductFunctions;

import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.HashMap;

public class CreateProduct {

    public void addProductToRepo(SystemInOut input) throws IOException, ClassNotFoundException {
        CreateProductGateway productGate = new CreateProductGateway();
        Product newProduct = productGate.createNewProductFromInput(input);
        String tag = newProduct.getCategory();

        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> productsSavedDict = rw.readFromFile("product.ser");
        productsSavedDict.put(tag, newProduct);
        rw.saveToFile("product.ser", productsSavedDict);

    }


}
