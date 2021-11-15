package Settings;
import UserFunctions.User;
import java.io.IOException;
import java.util.List;

public class ProductDeletionUseCase {
    User user;
    DeleteProductsGateway deleteProductsGateway;

    public ProductDeletionUseCase(User user, DeleteProductsGateway deleteProductsGateway) {
        this.user = user;
        this.deleteProductsGateway = deleteProductsGateway;
    }

    /**
     * Deletes the products of this user from the product.ser file and the IdToProduct.ser file.
     *
     * @return true if all products were successfully deleted and false otherwise.
     */
    public boolean deleteProducts() throws IOException, ClassNotFoundException {
        List<String> productListOfUser = this.user.getProductsPosted();
        return deleteProductsGateway.deleteProducts(productListOfUser);
    }
}
