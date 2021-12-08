package product;

/**
 * Used by GetProductGateway to access the IdToProduct.ser file
 */
public interface GetProductGatewayInterface {
    /**
     *
     * @param productId the unique identifier of the product
     * @return an Object from the IdToProduct.ser file
     */
    Object getProduct(String productId);
}
