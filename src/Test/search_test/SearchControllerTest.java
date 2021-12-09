package search_test;

import delete_gateways.DeleteProductsGateway;
import login.GetUserGateway;
import login.SaveUserGateway;
import product.GetProductGateway;
import product.Product;
import product.SaveProductGateway;
import user.User;
import delete_gateways.DeleteUserGateway;

import java.io.IOException;
import java.util.ArrayList;

import options.search.SearchController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchControllerTest{

    User testUser = new User("TestSearchController");
    Product testProduct = new Product("test", "TEST", 5.0, "test", "2",1);;
    SearchController searchController = new SearchController(testUser);

    SaveProductGateway saveProductGateway = new SaveProductGateway();
    GetProductGateway getProductGateway = new GetProductGateway();
    SaveUserGateway saveUserGateway = new SaveUserGateway();
    GetUserGateway getUserGateway = new GetUserGateway();

    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();

    @Before
    public void setUp() throws IOException, ClassNotFoundException {

        // if there is a preexisting user TestSearchControllerUser, delete it
        deleteUserGateway.deleteUser("TestSearchControllerUser");
        ArrayList<String> ids = new ArrayList<>();
        ids.add("TEST");
        deleteProductsGateway.deleteProducts(ids);
        // create the new user profile before each test
        saveUserGateway.saveUser("TestSearchController", testUser);
        // save a product to the repo to test with
        saveProductGateway.addProductToRepo(testProduct, "TEST", "test");
    }

    @After
    public void takeDown() throws IOException, ClassNotFoundException {
        // delete the test user profile before each test, to delete all the products that were created during the test
        deleteUserGateway.deleteUser("TestSearchControllerUser");
        ArrayList<String> ids = new ArrayList<>();
        ids.add("TEST");
        deleteProductsGateway.deleteProducts(ids);
    }

    //  name + " (" + id + ")" + ": $" + price + ", " + quantity + " in stock";
    //  name + " (" + id + ")" + ": $" + price + ", " + quantity + " in stock" + ", " + sizes;
    // "shoes", "TEST", 5.0, "shoes", "2",1
    @Test
    public void getProductIDTest() throws IOException, ClassNotFoundException {
        assertEquals("(0) test (TEST): $5.0, 1 in stock, 2", searchController.getSearchProductStrings("test").get(0));
    }

    @Test
    public void getProductIDMultipleTest() throws IOException, ClassNotFoundException {
        saveProductGateway.addProductToRepo(testProduct, "TEST", "test");

        assertEquals(searchController.getSearchProductStrings("test").size(), 2);
        ArrayList<String> ids = searchController.getSearchProductStrings("shoes");
        assertEquals("(0) test (TEST): $5.0, 1 in stock, 2", ids.get(0));
        assertEquals("(1) test (TEST): $5.0, 1 in stock, 2", ids.get(1));
    }

    @Test
    public void getProductIDNoProductTest() throws IOException, ClassNotFoundException {
        assertEquals(0, searchController.getSearchProductStrings("jadshjasdjsah").size());
    }

}
