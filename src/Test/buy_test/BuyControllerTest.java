package buy_test;

import delete_gateways.DeleteProductsGateway;
import delete_gateways.DeleteUserGateway;
import login.SaveUserGateway;
import options.buy.BuyController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import product.GetProductGateway;
import product.Product;
import product.SaveProductGateway;
import user.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

public class BuyControllerTest {
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
    public void testAllowBuy(){
        BuyController buyController = new BuyController();
        ArrayList<String> ids = new ArrayList<>();
        ids.add("TEST");
        assertTrue(buyController.allowBuy(user1,ids,0));
    }
    @Test
    public void testBuy(){
        BuyController buyController = new BuyController();
        buyController.buy("TEST");
        GetProductGateway getProductGateway = new GetProductGateway();
        Product product = getProductGateway.getProduct("TEST");
        assertEquals(product.getQuantity(), product1.getQuantity()-1);
    }

}
