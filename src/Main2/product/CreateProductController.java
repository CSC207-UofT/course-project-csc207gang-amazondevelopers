package product;
import user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CreateProductController {

    User user;

    public CreateProductController(User user) {
        this.user= user;
    }

    /**
     * Takes in an arraylist containing all information needed to create a product and returns the created product.
     * @param information a list of all information needed to create a product
     * @return returns a Product
     */
    public Product createProduct(ArrayList<String> information) throws IOException, ClassNotFoundException {
        SaveProductGatewayInterface saveProductGateway = new SaveProductGateway();
        ProductUseCase productUseCase = new ProductUseCase(saveProductGateway);
        String newId = generateID();
        Product newProduct = productUseCase.createProduct(information, newId);
        // saves the product to product.ser file
        productUseCase.saveNewProductToSer(newProduct);
        return newProduct;
    }

    /**
     * Generates random id for product that does not yet exist in the .ser file
     * @return the String representation of unique id
     * @throws IOException if the file is empty
     * @throws ClassNotFoundException if file is empty when trying to get HashMap from ser file
     */
    private String generateID() throws IOException, ClassNotFoundException {
        GetProductGateway getProductGateway = new GetProductGateway();
        HashMap<String, Object> hashMap = getProductGateway.getHashMap();
        int hashMapSize = hashMap.size();
        if (hashMapSize == 0) {
            Random random = new Random();
            return String.valueOf(random.nextInt());
        } else {
            boolean idUsed = true;
            Random random = new Random();
            String id = String.valueOf(random.nextInt());
            while (idUsed) {
                if (!hashMap.containsKey(id)) {
                    idUsed = false;
                } else {
                    id = String.valueOf(random.nextInt());
                }
            }
            return id;
        }
    }
}
