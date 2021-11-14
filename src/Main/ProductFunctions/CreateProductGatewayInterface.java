package ProductFunctions;

import InputAndOutput.SystemInOut;

import java.io.IOException;

public interface CreateProductGatewayInterface {
    public void addProductToRepo(Product newProduct, String productId, String tag) throws IOException, ClassNotFoundException;
}
