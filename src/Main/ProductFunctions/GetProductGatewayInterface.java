package ProductFunctions;

import java.io.IOException;

public interface GetProductGatewayInterface {
    public Product getProduct(String productId) throws IOException, ClassNotFoundException;
}
