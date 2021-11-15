package ProductFunctions;
import java.io.IOException;

public interface GetProductGatewayInterface {
    Object getProduct(String productId) throws IOException, ClassNotFoundException;
}
