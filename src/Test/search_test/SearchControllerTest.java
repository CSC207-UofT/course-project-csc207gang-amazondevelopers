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
    Product testProduct = new Product("testProd", "TEST", 5.0, "testCategory", "2",1);;
    SearchController searchController = new SearchController(testUser);

    SaveProductGateway saveProductGateway = new SaveProductGateway();
    SaveUserGateway saveUserGateway = new SaveUserGateway();

    DeleteProductsGateway deleteProductsGateway = new DeleteProductsGateway();
    DeleteUserGateway deleteUserGateway = new DeleteUserGateway();

    @Before
    public void setUp() throws IOException, ClassNotFoundException {
        // if there is a preexisting user TestSearchControllerUser, delete it
        deleteUserGateway.deleteUser("TestSearchControllerUser");
        // create the new user profile before each test
        saveUserGateway.saveUser("TestSearchController", testUser);
    }

    @After
    public void takeDown() {
        // delete the test user profile before each test, to delete all the products that were created during the test
        deleteUserGateway.deleteUser("TestSearchControllerUser");
    }

    //  name + " (" + id + ")" + ": $" + price + ", " + quantity + " in stock";
    //  name + " (" + id + ")" + ": $" + price + ", " + quantity + " in stock" + ", " + sizes;
    // "shoes", "TEST", 5.0, "shoes", "2",1
    @Test
    public void getProductIDTest() {
        // save a product to the repo to test with
        saveProductGateway.addProductToRepo(testProduct, "TEST", "testCategory");
        assertEquals("0) testProd (TEST): $5.0, 1 in stock, size: 2", searchController.getSearchProductStrings("testCategory").get(0));
        ArrayList<String> ids = new ArrayList<>();
        ids.add("TEST");
        deleteProductsGateway.deleteProducts(ids);
    }

    @Test
    public void getProductIDMultipleTest() {
        // save a product to the repo to test with
        Product product1 = new Product("testProd1", "TEST1", 5.0, "testCategory", "2", 1);
        Product product2 = new Product("testProd2", "TEST2", 5.0, "testCategory", "2", 1);
        saveProductGateway.addProductToRepo(product1, "TEST1", "testCategory");
        saveProductGateway.addProductToRepo(product2, "TEST2", "testCategory");

        assertEquals(searchController.getSearchProductStrings("testCategory").size(), 2);
        ArrayList<String> ids = searchController.getSearchProductStrings("testCategory");
        assertEquals("0) testProd1 (TEST1): $5.0, 1 in stock, size: 2", ids.get(0));
        assertEquals("1) testProd2 (TEST2): $5.0, 1 in stock, size: 2", ids.get(1));

        ArrayList<String> ids2 = new ArrayList<>();
        ids2.add("TEST1");
        ids2.add("TEST2");
        deleteProductsGateway.deleteProducts(ids2);
    }

    @Test
    public void getProductIDNoProductTest() {
        assertEquals(0, searchController.getSearchProductStrings("jadshjasdjsah").size());
    }

}
