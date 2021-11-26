package ProductFunctions;
import java.io.IOException;

/**
 * Used by CreateProductGateway to add product to product.ser and IdToProduct.ser
 */
public interface CreateProductGatewayInterface {
    /**
     *
     * @param newProduct Product object
     * @param productId the unique identifier of the product
     * @param tag tag (category) of the product
     * @throws IOException reading from file if it is empty
     * @throws ClassNotFoundException reading from file that is empty to try and produce a HashMap
     */
    void addProductToRepo(Product newProduct, String productId, String tag) throws IOException, ClassNotFoundException;
}
