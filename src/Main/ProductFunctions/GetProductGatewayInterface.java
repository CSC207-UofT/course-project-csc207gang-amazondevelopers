package ProductFunctions;

import UserFunctions.User;

import java.io.IOException;

public interface GetProductGatewayInterface {
    public Object getProduct(String productId) throws IOException, ClassNotFoundException;
}
