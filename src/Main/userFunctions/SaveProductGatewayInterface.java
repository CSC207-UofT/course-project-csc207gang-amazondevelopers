package userFunctions;
import productFunctions.Product;
import java.io.IOException;

/**
 * Used by SaveProductGateway to save a product to IdToProduct.ser
 */
public interface SaveProductGatewayInterface {
    /**
     *
     * @param productID the unique identifier of the product
     * @param product the product itself
     * @throws IOException reading from and saving to empty files
     * @throws ClassNotFoundException reading from empty file to create a HashMap
     */
    void save(String productID, Product product) throws IOException, ClassNotFoundException;
}
