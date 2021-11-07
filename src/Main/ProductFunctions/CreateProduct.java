package ProductFunctions;

import InputAndOutput.SystemInOut;
import UserFunctions.UserReadWriter;

import java.io.IOException;
import java.util.HashMap;

public class CreateProduct {

    public void addProductToRepo(SystemInOut input) throws IOException, ClassNotFoundException {
        CreatePorductGateway productGate = new CreatePorductGateway();
        Product newProduct = productGate.createNewProductFromInput(input);
        String tag = newProduct.getCategory();

        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> productsSavedDict = rw.readFromFile("product.ser");
        productsSavedDict.put(tag, newProduct);
        rw.saveToFile("product.ser", productsSavedDict);

    }


}
