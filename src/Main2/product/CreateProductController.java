package product;

import productFunctions.GetProductGateway;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class CreateProductController {

    /**
     * Generates random id for product that does not yet exist in the .ser file
     * @return the String representation of unique id
     * @throws IOException if the file is empty
     * @throws ClassNotFoundException if file is empty when trying to get HashMap from ser file
     */
    private String generateID() throws IOException, ClassNotFoundException {
        productFunctions.GetProductGateway getProductGateway = new GetProductGateway();
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
