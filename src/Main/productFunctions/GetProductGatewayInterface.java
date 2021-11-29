package productFunctions;
import java.io.IOException;

/**
 * Used by GetProductGateway to access the IdToProduct.ser file
 */
public interface GetProductGatewayInterface {
    /**
     *
     * @param productId the unique identifier of the product
     * @return an Object from the IdToProduct.ser file
     * @throws IOException reading from empty file
     * @throws ClassNotFoundException reading from an empty file to create a HashMap
     */
    Object getProduct(String productId) throws IOException, ClassNotFoundException;
}
