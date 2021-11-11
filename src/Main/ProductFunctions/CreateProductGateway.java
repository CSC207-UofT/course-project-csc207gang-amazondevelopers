package ProductFunctions;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import UserFunctions.User;
import UserFunctions.UserReadWriter;

public class CreateProductGateway implements CreateProductGatewayInterface {

    public void addProductToRepo(Product newProduct, String productId) throws IOException, ClassNotFoundException {



        File file = new File("src/Main/product.ser");
        if (file.length() == 0){
            UserReadWriter rw = new UserReadWriter();
            HashMap<String, Object> emptyHashMap = new HashMap<>();
            rw.saveToFile("src/Main/product.ser", emptyHashMap);
        }


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