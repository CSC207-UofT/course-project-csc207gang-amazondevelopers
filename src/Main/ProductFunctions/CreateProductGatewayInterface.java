package ProductFunctions;
import java.io.IOException;

public interface CreateProductGatewayInterface {
    void addProductToRepo(Product newProduct, String productId, String tag) throws IOException, ClassNotFoundException;
}
