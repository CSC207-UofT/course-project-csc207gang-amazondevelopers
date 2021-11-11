package Settings;

import ProductFunctions.ProductReadWriter;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DeleteProductsGateway implements DeleteProductGatewayInterface {

    /**
     * Deletes the products of this user from the product.ser file and the IdToProduct.ser file.
     *
     * @return true if all products were successfully deleted and false otherwise.
     */
    public boolean deleteProducts(List<String> listIds) throws IOException, ClassNotFoundException {
        File file = new File("src/Main/IdToProduct.ser");
        if (!(file.length() == 0)) {
            // access the serialized file for this user.
            ProductReadWriter rw = new ProductReadWriter();
            HashMap<String, Object> productSavedDict = rw.readFromFile("src/Main/IdToProduct.ser");
            for (String id: listIds){
                if (productSavedDict.containsKey(id)) {
                    productSavedDict.remove(id);
                }
                else {
                    // if that string id does not exist
                    return false;
                }
            }
            // saving back the updated hashmap
            rw.saveToFile("src/Main/IdToProduct.ser", productSavedDict);
            return true;
        }
        // no product do not exist
        return false;
    }
}
