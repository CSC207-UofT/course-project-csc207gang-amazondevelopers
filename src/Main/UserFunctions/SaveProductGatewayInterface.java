package UserFunctions;

import ProductFunctions.Product;

import java.io.IOException;

public interface SaveProductGatewayInterface {

    public void save(String productID, Product product) throws IOException, ClassNotFoundException;
}
