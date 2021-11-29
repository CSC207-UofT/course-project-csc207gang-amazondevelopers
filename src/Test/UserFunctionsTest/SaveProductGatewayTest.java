package UserFunctionsTest;

import productFunctions.GetProductGateway;
import productFunctions.Product;
import settingsFunctions.DeleteProductsGateway;
import userFunctions.SaveProductGateway;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SaveProductGatewayTest {
    SaveProductGateway saveProductGateway = new SaveProductGateway();
    GetProductGateway getProductGateway = new GetProductGateway();
    DeleteProductsGateway deleteProductGateway = new DeleteProductsGateway();

    @Test
    public void setSaveUserChangesGatewaysTest() throws IOException, ClassNotFoundException {
        Product product = new Product("pokemon", "234", 12.0, "toy", 2);
        String productID = product.getId();
        saveProductGateway.save(productID, product);

        Product actualProduct = getProductGateway.getProduct("234");
        assertEquals(product.getName(), actualProduct.getName());
    }
}
