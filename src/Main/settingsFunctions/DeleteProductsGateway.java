package settingsFunctions;
import productFunctions.Product;
import productFunctions.ProductReadWriter;
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
            HashMap<String, Object> productSavedHash = rw.readFromFile("src/Main/IdToProduct.ser");
            HashMap<String, Object> tagToIDListHash = rw.readFromFile("src/Main/Product.ser");
            for (String id: listIds){
                Product product = (Product) productSavedHash.get(id);
                String category = product.getCategory();
                List<String> idsList = (List<String>) tagToIDListHash.get(category);
                idsList.remove(id);
                if (productSavedHash.containsKey(id)) {
                    productSavedHash.remove(id);
                }
                else {
                    // if that string id does not exist
                    return false;
                }
            }
            // saving back the updated hashmap
            rw.saveToFile("src/Main/IdToProduct.ser", productSavedHash);
            rw.saveToFile("src/Main/Product.ser", tagToIDListHash);
            return true;
        }
        // no product do not exist
        return false;
    }
}
