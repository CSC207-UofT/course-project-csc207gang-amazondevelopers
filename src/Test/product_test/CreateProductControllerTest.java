package product_test;

import delete_gateways.DeleteProductsGateway;
import delete_gateways.DeleteUserGateway;
import login.SaveUserGateway;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import product.CreateProductController;
import product.Product;
import user.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CreateProductControllerTest {

    SaveUserGateway saveUserGateway = new SaveUserGateway();
    // create a new user profile to make products for
    User testUser = new User("TestCreateProductUser");

    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
    CreateProductController createProduct = new CreateProductController(testUser);

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        // if there is a preexisting user TestCreateProductUser, delete it
        deleteUserGateway.deleteUser("TestCreateProductUser");
        // create the new user profile before each test
        saveUserGateway.saveUser("TestCreateProductUser", testUser);

    }

    @After
    public void takeDown() throws IOException, ClassNotFoundException {
        // delete the test user profile before each test, to delete all the products that were created during the test
        deleteUserGateway.deleteUser("TestCreateProductUser");
    }

    @Test
    public void createProductSizeTest() throws Exception {
        String name = "Pokemon";
        String price = "12";
        String category = "toy";
        String quantity = "2";
        ArrayList<String> information = new ArrayList<String>(Arrays.asList(name, price, category, quantity));
        Product testProduct = createProduct.createProduct(information);
        assertEquals("product.Product", testProduct.getClass().getName());
        assertEquals("Pokemon", testProduct.getName());
        assertEquals(12, testProduct.getPrice(), 0);
        assertEquals("toy", testProduct.getCategory());
        assertEquals(2, testProduct.getQuantity(), 0);
        ArrayList<String> idList = new ArrayList<String>();
        idList.add(testProduct.getId());
        deleteProductsGateway.deleteProducts(idList);


    }


}
