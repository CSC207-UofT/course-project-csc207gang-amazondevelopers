package ProductFunctions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import UserFunctions.User;
import UserFunctions.UserReadWriter;

public class CreateProductGateway implements CreateProductGatewayInterface {

    public void addProductToRepo(Product newProduct, String productId, String tag) throws IOException,
            ClassNotFoundException {

        File file = new File("src/Main/product.ser");
        if (file.length() == 0){
            UserReadWriter rw = new UserReadWriter();
            HashMap<String, List<String>> emptyHashMap = new HashMap<>();
            rw.saveToFile("src/Main/product.ser", emptyHashMap);
        }

        ProductReadWriter rw = new ProductReadWriter();

        HashMap<String, Object> productsSavedDict = rw.readFromFile("src/Main/product.ser");
        // {tag:[ID]}
        if (productsSavedDict.containsKey(tag)) {
            List<String> productIDList = (List<String>) productsSavedDict.get(tag);
            productIDList.add(productId);
            productsSavedDict.put(tag, productIDList);
            rw.saveToFile("src/Main/Product.ser", productsSavedDict);
        }
        else {
            List<String> newList = new ArrayList<>();
            productsSavedDict.put(tag,newList);
            rw.saveToFile("src/Main/Product.ser", productsSavedDict);
        }

        // {ID: product}
        File file2 = new File("src/Main/IdToProduct.ser");
        // if no hashmap exists yet
        if (file2.length() == 0){
            UserReadWriter readWriter = new UserReadWriter();
            HashMap<String, List<String>> emptyHashMap = new HashMap<>();
            readWriter.saveToFile("src/Main/IdToProduct.ser", emptyHashMap);
        }

        HashMap<String, Object> idToProductDict = rw.readFromFile("src/Main/IdToProduct.ser");
        idToProductDict.put(productId, newProduct);
        rw.saveToFile("src/Main/IdToProduct.ser", idToProductDict);
        }


    }

