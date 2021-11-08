package ProductFunctions;

import InputAndOutput.SystemInOut;

import java.io.IOException;
import java.util.HashMap;
import UserFunctions.User;

public class CreateProduct {

    public void addProductToRepo(SystemInOut input, User user) throws IOException, ClassNotFoundException {
        CreateProductGateway productGate = new CreateProductGateway();
        Product newProduct = productGate.createNewProductFromInput(input,user);
        String tag = newProduct.getCategory();

        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> productsSavedDict = rw.readFromFile("product.ser");
        productsSavedDict.put(tag, newProduct);
        rw.saveToFile("product.ser", productsSavedDict);

    }


}
