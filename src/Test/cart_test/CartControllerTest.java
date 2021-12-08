package cart_test;
import delete_gateways.DeleteProductsGateway;
import delete_gateways.DeleteUserGateway;
import login.GetUserGateway;
import login.SaveUserGateway;
import options.cart.CartController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import product.GetProductGateway;
import product.Product;
import product.SaveProductGateway;
import user.User;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class CartControllerTest {
    User user1;
    User user2;
    Product product1;
    @Before
    public void setUp(){
        SaveUserGateway saveUserGateway = new SaveUserGateway();
        SaveProductGateway saveProductGateway = new SaveProductGateway();
        DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
        DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
        deleteUserGateway.deleteUser("User1");
        deleteUserGateway.deleteUser("User2");
        user1 = new User("User1");
        user2 = new User("User2");
        saveUserGateway.saveUser("User1",user1);
        saveUserGateway.saveUser("User2",user2);
        ArrayList<String> ids = new ArrayList<>();
        ids.add("TEST");
        deleteProductsGateway.deleteProducts(ids);
        product1 = new Product("User1","TEST",2.0,"test",4);
        user1.addToCart(product1);
        saveProductGateway.addProductToRepo(product1,"TEST","test");

    }
    @After
    public void tearDown(){
        DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
        DeleteUserGateway deleteUserGateway = new DeleteUserGateway();
        deleteUserGateway.deleteUser("User1");
        deleteUserGateway.deleteUser("User2");
        ArrayList<String> ids = new ArrayList<>();
        ids.add("TEST");
        deleteProductsGateway.deleteProducts(ids);
    }
    @Test
    public void testBuyCart(){
        CartController browseController = new CartController();
        browseController.buyCart(user1);
        GetProductGateway getProductGateway = new GetProductGateway();
        GetUserGateway getUserGateway = new GetUserGateway();
        Product product = getProductGateway.getProduct("TEST");
        user1 = getUserGateway.getUser("User1");
        assertEquals(user1.getShoppingCart(),new ArrayList<>());
        assertEquals(product.getQuantity(), product1.getQuantity()-1);
    }
}
