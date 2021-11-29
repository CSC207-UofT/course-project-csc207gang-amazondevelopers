package settingsFunctions;

import java.io.IOException;
import java.util.List;

/**
 * Used by DeleteProductsGateway to help remove keys and values from HashMaps in Product.ser and IdToProduct.ser
 */
public interface DeleteProductGatewayInterface {
    /**
     *
     * @param listIds list of unique identifiers of several products to be deleted
     * @return true or false, whether products were deleted or not
     * @throws IOException reading from empty files
     * @throws ClassNotFoundException reading from empty file to produce HashMaps
     */
    boolean deleteProducts(List<String> listIds) throws IOException, ClassNotFoundException;
}
