package ProductFunctions;

import java.io.IOException;
import java.util.HashMap;

public class GetProductGateway implements GetProductGatewayInterface{

    public Product getProduct(String productId) throws IOException, ClassNotFoundException {
        ProductReadWriter rw = new ProductReadWriter();
        HashMap<String, Object> idToProductDict = rw.readFromFile("src/Main/IdToProduct.ser");
        if (idToProductDict.get(productId) != null){
            return (Product) idToProductDict.get(productId);
        }
        return null;
    }
}
