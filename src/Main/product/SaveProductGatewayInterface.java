package product;


/**
 * Used by SaveProductGateway to add product to product.ser and IdToProduct.ser
 */
public interface SaveProductGatewayInterface {
    /**
     *
     * @param newProduct Product object
     * @param productId the unique identifier of the product
     * @param tag tag (category) of the product
     */
    void addProductToRepo(Product newProduct, String productId, String tag);
}
