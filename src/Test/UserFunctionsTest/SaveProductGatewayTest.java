package UserFunctionsTest;

import OptionsPackage.SearchGateway;
import ProductFunctions.CreateProductGateway;
import ProductFunctions.GetProductGateway;
import ProductFunctions.Product;
import Settings.DeleteProductsGateway;
import Settings.DeleteUserGateway;
import UserFunctions.SaveProductGateway;
import UserFunctions.User;
import login.GetUserGateway;
import login.SignUpGateway;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
